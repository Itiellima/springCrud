package demo.springcrud.services;

import demo.springcrud.model.Pessoa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PessoaServices {

    List<Pessoa> getAllpessoa();
    Optional<Pessoa> getPessoaById(Long id);
    void deletePessoaById(Long id);
    void savePessoa(Pessoa pessoa);
    void updatePessoa(Pessoa pessoa);

}
