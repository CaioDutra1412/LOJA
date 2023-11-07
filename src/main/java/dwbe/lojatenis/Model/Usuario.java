package dwbe.lojatenis.Model;

import java.util.List;
import java.util.Objects;

public class Usuario {

    private String nome;
    private String username;
    private String password;
    private List<String> papeis;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getPapeis() {
        return papeis;
    }

    public void setPapeis(List<String> papeis) {
        this.papeis = papeis;
    }

    public Usuario(){

    }

    public Usuario(String pnome, String pusername, String ppassword){
        this.nome = pnome;
        this.username = pusername;
        this.password = ppassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario user = (Usuario) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);

    }

}
