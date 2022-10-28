
package Home;

import javax.swing.JPanel;


public class Usuario {

    static JPanel setSenha;
    
    private String id;
    private String usuario;
    private String senha;

    public Usuario(String id, String usuario, String senha) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public Usuario(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id 
                + ", usuario=" + usuario 
                + ", senha=" + senha + '}';
    }

    
    
}
