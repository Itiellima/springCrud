package demo.springcrud.controller;

import demo.springcrud.model.Pessoa;
import demo.springcrud.services.PessoaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    PessoaServices pessoaServices;

    @GetMapping
    public String index(){
        return "Index";
    }

    @GetMapping("/listPessoa")
    public String listPessoa(Model model){
        model.addAttribute("pessoa", pessoaServices.getAllpessoa());
        return "ListPessoa";
    }

    @GetMapping("/inserirPessoa")
    public String insert(Model model){
        model.addAttribute("pessoa", new Pessoa());
        return "PessoaForm";
    }

    @PostMapping("/salvarPessoa")
    public String salvar(@ModelAttribute("pessoa") Pessoa pessoa){
        pessoaServices.savePessoa(pessoa);
        return "redirect:/pessoa/listPessoa";
    }

    @GetMapping("/editarPessoa/{id}")
    public String editar(@PathVariable Long id, Model model){
        Optional<Pessoa> pessoa = pessoaServices.getPessoaById(id);
        if(pessoa.isPresent()){
            model.addAttribute("pessoa", pessoa.get());
            return "PessoaForm";
        }else{
            return "redirect:/pessoa/listPessoa";
        }

    }

    @GetMapping("/excluirPessoa/{id}")
    public String delete(@PathVariable Long id){
        pessoaServices.deletePessoaById(id);
        return "redirect:/pessoa/listPessoa";
    }



}
