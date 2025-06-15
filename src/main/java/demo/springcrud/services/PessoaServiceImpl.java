package demo.springcrud.services;


import demo.springcrud.model.Pessoa;
import demo.springcrud.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaServices{

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> getAllpessoa() {
        return pessoaRepository.findAll();
    }

    @Override
    public Optional<Pessoa> getPessoaById(Long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public void deletePessoaById(Long id) {
        pessoaRepository.deleteById(id);
    }

    @Override
    public void savePessoa(Pessoa pessoa) {
        if (pessoa.getId() == null){
            pessoaRepository.save(pessoa);
        }
        else{
            pessoaRepository.save(pessoa);
        }
    }

    // PARA CASO AJA SEPARAÇÃO ENTRE EDITAR E SALVAR
    @Override
    public void updatePessoa(Pessoa pessoa) {
        if (pessoa.getId() != null){
            pessoaRepository.save(pessoa);
        }
    }


}
