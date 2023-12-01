package dwbe.lojatenis.Model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private String status;

    public Cliente(String nome, String cpf, String endereco, String sexo, String telefone, String email, String status) {
        super(nome, cpf, endereco, sexo, telefone, email);
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CLIENTE{" +
                "id='" + super.getId() + '\'' +
                ", nome=" + super.getNome() +
                ", cpf='" + super.getCpf() + '\'' +
                ", endereco='" + super.getEndereco() + '\'' +
                ", sexo='" + super.getSexo() + '\'' +
                ", telefone='" + super.getTelefone() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                ", status='" + this.getStatus() + '\'' +
                '}';
    }
}
