package dwbe.lojatenis.Model;

public class Cliente extends Pessoa {

    private String status;

    public Cliente(String id, String nome, String cpf, String endereco, String sexo, String telefone, String email, String status) {
        super(id, nome, cpf, endereco, sexo, telefone, email);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
