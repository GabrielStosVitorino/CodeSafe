var database = require("../database/config");

/*
function buscarUltimasMedidas(idServidor,limite_linhas) {
    instrucaoSql = `select top (${limite_linhas})
                        DATE_FORMAT(momento,'%H:%i:%s') as dataHorario
                        percentualConsumo,
                        from historico
                        JOIN componente ON fkComponente = idHistorico
                        where fkComponente = ${idServidor}
                        order by id desc`;
    console.log("Executando a instrução SQL: \n"+instrucaoSql);
    return database.executar(instrucaoSql);
}
*/

// function buscarMedidasEmTempoReal(idServidor) {
//     instrucaoSql = `select temperatura, 
//                             umidade, 
//                             DATE_FORMAT(momento,'%H:%i:%s') as momento_grafico, 
//                             fk_aquario 
//                             from medida where fk_aquario = ${idServidor} 
//                     order by id desc limit 1`;
                    
//     console.log("Executando a instrução SQL: \n"+instrucaoSql);
//     return database.executar(instrucaoSql);
// }

/*
data_uso datetime primary key,
unidade varchar(45),
consumo double,
disponivel double,
total double,
fkComponente int,
foreign key (fkComponente) references componente (idComponente)
);
*/


function buscarUltimaData(idServidor) {
    instrucaoSql = `select top 1
    DATEPART(DAY, dataHorario) as 'dia'
                            from historico
                            JOIN componente ON fkComponente = idComponente
                            JOIN servidor ON fkServidor = idServidor
                            where idServidor = ${idServidor}
                            order by idHistorico desc;`;
    console.log("Executando a instrução SQL: \n"+instrucaoSql);
    return database.executar(instrucaoSql);
}

function buscarMedidasRAMKPI(idServidor) {
    instrucaoSql = `select top 1
                        DATEPART(HOUR,dataHorario) as 'hora' ,
                        DATEPART(MINUTE,dataHorario) as 'minuto',
                        DATEPART(SECOND,dataHorario) as 'segundo',
                        percentualConsumo
                        from historico
                        JOIN componente ON fkComponente = idComponente
                        JOIN servidor ON fkServidor = idServidor
                        where idServidor = ${idServidor}
                        AND tipo = 'RAM'
                        order by idHistorico desc`;
    console.log("Executando a instrução SQL: \n"+instrucaoSql);
    return database.executar(instrucaoSql);
}

function buscarMedidasCPUKPI(idServidor) {
    instrucaoSql = `select top 1
                        DATEPART(HOUR,dataHorario) as 'hora' ,
                        DATEPART(MINUTE,dataHorario) as 'minuto',
                        DATEPART(SECOND,dataHorario) as 'segundo',
                        percentualConsumo
                        from historico
                        JOIN componente ON fkComponente = idComponente
                        JOIN servidor ON fkServidor = idServidor
                        where idServidor = ${idServidor}
                        AND tipo = 'CPU'
                        order by idHistorico desc`;
    console.log("Executando a instrução SQL: \n"+instrucaoSql);
    return database.executar(instrucaoSql);
}

function buscarMedidasDisco(idServidor) {
    instrucaoSql = `select top 1
                        DATEPART(HOUR,dataHorario) as 'hora' ,
                        DATEPART(MINUTE,dataHorario) as 'minuto',
                        DATEPART(SECOND,dataHorario) as 'segundo',
                        percentualConsumo
                        from historico
                        JOIN componente ON fkComponente = idComponente
                        JOIN servidor ON fkServidor = idServidor
                        where idServidor = ${idServidor}
                        AND tipo = 'DISCO'
                        order by idHistorico desc`;
    console.log("Executando a instrução SQL: \n"+instrucaoSql);
    return database.executar(instrucaoSql);
}

function buscarMedidasRAM(idServidor) {
instrucaoSql = `select top 7
                    DATEPART(HOUR,dataHorario) as 'hora' ,
                    DATEPART(MINUTE,dataHorario) as 'minuto',
                    DATEPART(SECOND,dataHorario) as 'segundo',
                    percentualConsumo
                    from historico
                    JOIN componente ON fkComponente = idComponente
                    JOIN servidor ON fkServidor = idServidor
                    where idServidor = ${idServidor}
                    AND tipo = 'RAM'
                    order by idHistorico desc`;
    console.log("Executando a instrução SQL: \n"+instrucaoSql);
    return database.executar(instrucaoSql);
}

function buscarMedidasCPU(idServidor) {
    instrucaoSql = `select top 7
                        DATEPART(HOUR,dataHorario) as 'hora' ,
                        DATEPART(MINUTE,dataHorario) as 'minuto',
                        DATEPART(SECOND,dataHorario) as 'segundo',
                        percentualConsumo
                        from historico
                        JOIN componente ON fkComponente = idComponente
                        JOIN servidor ON fkServidor = idServidor
                        where idServidor = ${idServidor}
                        AND tipo = 'CPU'
                        order by idHistorico desc`;
    console.log("Executando a instrução SQL: \n"+instrucaoSql);
    return database.executar(instrucaoSql);
}

function listarServidores(fkEmpresa) {
    console.log("ACESSEI O AVISO  MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listar()");
    var instrucao = `
        SELECT 
            idServidor,
            funcao            
        FROM servidor
        WHERE fkEmpresaServidor = '${fkEmpresa}';
    `;
    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
}

module.exports = {
    buscarMedidasCPUKPI,
    buscarMedidasRAMKPI,
    buscarMedidasDisco,
    buscarMedidasRAM,
    buscarMedidasCPU,
    listarServidores,
    buscarUltimaData
}