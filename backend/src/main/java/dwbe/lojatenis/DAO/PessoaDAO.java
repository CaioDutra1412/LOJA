package dwbe.lojatenis.DAO;

import dwbe.lojatenis.Model.Pessoa;

import java.util.List;

public interface PessoaDAO {
    void create(Pessoa pessoa);
    Pessoa read(String id);
    void update(Pessoa pessoa);
    void delete(String id);
    List<Pessoa> getAllPessoas();
}
