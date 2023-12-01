package dwbe.lojatenis.Model;

public class Funcionario extends Pessoa {

    private double salario;
    private String cargo;

    public Funcionario(int id, String nome, String cpf, String endereco, String sexo, String telefone, String email, String status) {
        super(nome, cpf, endereco, sexo, telefone, email);
        this.salario = salario;
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}