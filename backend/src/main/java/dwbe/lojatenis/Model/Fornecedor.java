package dwbe.lojatenis.Model;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor extends Pessoa {

    private String cnpj;
    private int numeroInscricao;
    private String nomeFantasia;
    private String dataDeAbertura;
    private String porte;
    private String atividadeEconomicaPrincipal;
    private String situcaoCadastral;
    private List<Produto> produtosAVenda;

    public Fornecedor(String id, String nome, String cpf, String endereco, String sexo, String telefone, String email, String cnpj, int numeroInscricao, String nomeFantasia, String dataDeAbertura, String porte, String atividadeEconomicaPrincipal, String  situcaoCadastral) {
        super(id, nome, cpf, endereco, sexo, telefone, email);
        this.cnpj = cnpj;
        this.numeroInscricao = numeroInscricao;
        this.nomeFantasia = nomeFantasia;
        this.dataDeAbertura = dataDeAbertura;
        this.porte = porte;
        this.atividadeEconomicaPrincipal = atividadeEconomicaPrincipal;
        this.situcaoCadastral = situcaoCadastral;
        this.produtosAVenda = new ArrayList<Produto>();
    }
    public int getNumeroInscricao() {
        return numeroInscricao;
    }

    public void setNumeroInscricao(int numeroInscricao) {
        this.numeroInscricao = numeroInscricao;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(String dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getAtividadeEconomicaPrincipal() {
        return atividadeEconomicaPrincipal;
    }

    public void setAtividadeEconomicaPrincipal(String atividadeEconomicaPrincipal) {
        this.atividadeEconomicaPrincipal = atividadeEconomicaPrincipal;
    }

    public String getSitucaoCadastral() {
        return situcaoCadastral;
    }

    public void setSitucaoCadastral(String situcaoCadastral) {
        this.situcaoCadastral = situcaoCadastral;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Produto> getProdutosAVenda() {
        return this.produtosAVenda;
    }

    public void setProdutosAVenda(Produto produto) {
        this.produtosAVenda.add(produto);
    }

    @Override
    public String toString() {
        return "FORNECEDOR{" +
                "id='" + super.getId() + '\'' +
                ", nome=" + super.getNome() +
                ", cpf='" + super.getCpf() + '\'' +
                ", endereco='" + super.getEndereco() + '\'' +
                ", sexo='" + super.getSexo() + '\'' +
                ", telefone='" + super.getTelefone() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                ", cnpj='" + this.getCnpj() + '\'' +
                ", numeroInscricao='" + this.getNumeroInscricao() + '\'' +
                ", nomeFantasia='" + this.getNomeFantasia() + '\'' +
                ", dataDeAbertura='" + this.getDataDeAbertura() + '\'' +
                ", porte='" + this.getPorte() + '\'' +
                ", atividadeEconomicaPrincipal='" + this.getAtividadeEconomicaPrincipal() + '\'' +
                ", situcaoCadastral='" + this.getSitucaoCadastral() + '\'' +
                '}';
    }
}
