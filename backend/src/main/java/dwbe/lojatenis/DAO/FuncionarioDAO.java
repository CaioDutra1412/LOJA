package dwbe.lojatenis.DAO;

import dwbe.lojatenis.Model.Funcionario;

import java.util.List;
public interface FuncionarioDAO {
    void create(Funcionario funcionario);
    Funcionario read(String id);
    void update(Funcionario funcionario);
    void delete(String id);
    List<Funcionario> getAllFuncionarios();
}
