package dwbe.lojatenis.Model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

    private String status;
    private List<Venda> historicoCompras;

    public Cliente(String id, String nome, String cpf, String endereco, String sexo, String telefone, String email, String status) {
        super(id, nome, cpf, endereco, sexo, telefone, email);
        this.status = status;
        this.historicoCompras = new ArrayList<>();
    }

    public void adicionarVenda(Venda venda) {
        historicoCompras.add(venda);
    }

    public List<Venda> obterHistoricoCompras() {
        return historicoCompras;
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
