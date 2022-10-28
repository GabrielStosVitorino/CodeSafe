
package Home;
import org.apache.commons.dbcp2.BasicDataSource;


public class Connection {
    
    private BasicDataSource dataSource;
    
    public Connection(){
        dataSource = new BasicDataSource();
        dataSource​.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource​.setUrl("jdbc:mysql://localhost:3306/bancoTeste");
        dataSource​.setUsername("root");
        dataSource​.setPassword("dudu1804");
    }
    
     public BasicDataSource getDataSource() {
        return dataSource;
    }
    
}
