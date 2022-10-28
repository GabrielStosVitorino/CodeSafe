
package Home;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class Login {
    
    public static void main(String[] args) {
        
         Connection config = new Connection();
         
         JdbcTemplate template = new JdbcTemplate(config.getDataSource());
         
         String inserirScript = "INSERT INTO usuario VALUES"
                        + "(null, ?,?)";
         
//         template.update(inserirScript, "Igor", "1234");
         
         List<Usuario> listUsuario1 = template.query("select * from usuario",
                new BeanPropertyRowMapper<>(Usuario.class));
        
        for (Usuario usuario : listUsuario1) {
            System.out.println(usuario);
        }
        
        List listaUsuario1 = template.queryForList("select * from usuario");
        
        System.out.println(listaUsuario1);
        
        Tela tela = new Tela(listUsuario1.get(0));
        tela.setVisible(true);
    }
    
}
