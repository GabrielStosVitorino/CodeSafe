package com.sptech.codesafe;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Coletor {

    Connection config = new Connection("Azure");
    JdbcTemplate template = new JdbcTemplate(config.getDataSource());
    // CONEXÃO LOOCA
    Looca looca = new Looca();
    // Gerenciar Grupo de Discos
    DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
    List<com.github.britooo.looca.api.group.discos.Disco> discos = grupoDeDiscos.getDiscos();
    
    Logger logger = Logger.getLogger("Coletor");
    FileHandler fh;

    // Atributos para serem chamados na exibição de CodeSafe.java
    private String atualRAM;
    private String atualCPU;
    private String atualDisco;
    private String serverRAM;
    private String serverCPU;
    private String serverDisco;

    public Coletor() {
        try {  
            fh = new FileHandler("../ColetorLog.log");  
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);  
        } catch (SecurityException | IOException e) {  
            logger.severe("Erro ao inicializar arquivo de log.");
        }
    }

    // RAM
    public Historico coletarRAM() {
        Historico registroRAM = new Historico(identificarComponente("RAM"));
        registroRAM.setUnidadeMedida("GB");
        BigDecimal consumoRAM = new BigDecimal(looca.getMemoria().getEmUso().doubleValue() / 1073741824).setScale(2, RoundingMode.HALF_EVEN);
        registroRAM.setConsumo(consumoRAM.doubleValue());
        BigDecimal totalRAM = new BigDecimal(looca.getMemoria().getTotal().doubleValue() / 1073741824).setScale(2, RoundingMode.HALF_EVEN);
        registroRAM.setTotal(totalRAM.doubleValue());
        BigDecimal percentualConsumoRAM = new BigDecimal((registroRAM.getConsumo() * 100) / registroRAM.getTotal()).setScale(2, RoundingMode.HALF_EVEN);
        registroRAM.setPercentualConsumo(percentualConsumoRAM.doubleValue());
        this.atualRAM = (percentualConsumoRAM).toString();
        this.serverRAM = (totalRAM).toString();
        return registroRAM;
    }

    ;
    
    // CPU
    public Historico coletarCPU() {
        Historico registroCPU = new Historico(identificarComponente("CPU"));
        registroCPU.setUnidadeMedida("GHz");
        BigDecimal totalCPU = new BigDecimal(looca.getProcessador().getFrequencia() / 1e+9).setScale(2, RoundingMode.HALF_EVEN);
        registroCPU.setTotal(totalCPU.doubleValue());
        BigDecimal percentualCPU = new BigDecimal(looca.getProcessador().getUso()).setScale(2, RoundingMode.HALF_EVEN);
        registroCPU.setPercentualConsumo(percentualCPU.doubleValue());
        BigDecimal consumoCPU = new BigDecimal((registroCPU.getTotal() * registroCPU.getPercentualConsumo()) / 100).setScale(2, RoundingMode.HALF_EVEN);
        registroCPU.setConsumo(consumoCPU.doubleValue());
        this.atualCPU = (percentualCPU).toString();
        this.serverCPU = (totalCPU).toString();
        return registroCPU;
    }

    ;
    
    // DISCO
    List<Volume> volumes = grupoDeDiscos.getVolumes();

    public Historico coletarDISCO() {
        Double discoDisponivel = 0.0;
        Double discoTotal = 0.0;
        Double discoConsumido = 0.0;
        for (Volume volume : volumes) {
            discoDisponivel += volume.getDisponivel().doubleValue();
            discoTotal += volume.getTotal().doubleValue();
            discoConsumido += (volume.getTotal().doubleValue() - volume.getDisponivel().doubleValue());
        }
//        System.out.println(discoDisponivel);
//        System.out.println(discoTotal);
//        System.out.println(discoConsumido);
        Historico registroDISCO = new Historico(identificarComponente("DISCO"));
        registroDISCO.setUnidadeMedida("GB");
        BigDecimal totalVolume = new BigDecimal(discoTotal.doubleValue() / 1e+9).setScale(0, RoundingMode.HALF_EVEN);
        registroDISCO.setTotal(totalVolume.doubleValue());
        BigDecimal consumoDisco = new BigDecimal(discoConsumido / 1e+9).setScale(2, RoundingMode.HALF_EVEN);
        registroDISCO.setConsumo(consumoDisco.doubleValue());
        BigDecimal percentualDisco = new BigDecimal((registroDISCO.getConsumo() * 100) / registroDISCO.getTotal()).setScale(0, RoundingMode.HALF_EVEN);
        registroDISCO.setPercentualConsumo(percentualDisco.doubleValue());
        this.atualDisco = (percentualDisco).toString();
        this.serverDisco = (totalVolume).toString();
        return registroDISCO;
//        BigDecimal totalDisco = new BigDecimal(looca.getGrupoDeDiscos().getTamanhoTotal().doubleValue() / 1e+9).setScale(0, RoundingMode.HALF_EVEN);
//        registroDISCO.setTotal(totalDisco.doubleValue());
//        this.totalDisco = (totalDisco).toString();
    }

    public Integer identificarComponente(String tipoComponente) {
        Integer idComponenteCorreto = null;

        try {
            Servidor servidorTeste = new Servidor();
            List<Servidor> buscaServidor = template.query("SELECT * FROM servidor WHERE funcao = ?",
                    new BeanPropertyRowMapper<>(Servidor.class), InetAddress.getLocalHost().getHostName());
            for (Servidor servidor : buscaServidor) {
                Componente componenteTeste = new Componente();
                List<Componente> buscaComponente = template.query("SELECT * FROM componente WHERE fkServidor = ? AND tipo = ?",
                        new BeanPropertyRowMapper<>(Componente.class), servidor.getIdServidor(), tipoComponente);
                for (Componente componente : buscaComponente) {
                    idComponenteCorreto = componente.getIdComponente();
                }
            }
        } catch (UnknownHostException ex) {
            logger.severe(String.format("Erro ao identificar componente: %s", ex));
        }
        return idComponenteCorreto;
    }

    // GET e SET
    public List<Disco> getDiscos() {
        return discos;
    }

    public void setDiscos(List<Disco> discos) {
        this.discos = discos;
    }

    public String getAtualRAM() {
        return atualRAM;
    }

    public void setAtualRAM(String atualRAM) {
        this.atualRAM = atualRAM;
    }

    public String getAtualCPU() {
        return atualCPU;
    }

    public void setAtualCPU(String atualCPU) {
        this.atualCPU = atualCPU;
    }

    public String getAtualDisco() {
        return atualDisco;
    }

    public void setAtualDisco(String atualDisco) {
        this.atualDisco = atualDisco;
    }

    @Override
    public String toString() {
        return String.format("\n"
                + "__________________________________\n"
                + "|Componente |  Total    |  Uso    |\n"
                + "|RAM:       |  %s GB  |  %s%% |\n"
                + "|CPU:       |  %s GHz |  %s%% |\n"
                + "|Disco:     |   %s GB  |  %s%% |",
                serverRAM, atualRAM, serverCPU, atualCPU, serverDisco, atualDisco);
    }

}
