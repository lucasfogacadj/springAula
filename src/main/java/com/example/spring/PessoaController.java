package com.example.spring;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PessoaController {
    private final PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    @PostMapping("/pessoa")
    public Pessoa criarPessoa(@RequestParam String nome){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        return pessoaRepository.salvar(pessoa);
    }

    @GetMapping("/pessoa/{id}")
    public Pessoa buscaPorId(@PathVariable Long id){
        return pessoaRepository.buscaPorId(id);
    }

    @PutMapping("/pessoa/{id}")
    public Pessoa atualizar(@PathVariable Long id, @RequestParam String name){
        Pessoa pessoa = pessoaRepository.buscaPorId(id);
        pessoa.setNome(name);
        return pessoaRepository.atualizar(pessoa);
    }
    @DeleteMapping("/pessoa/{id}")
    public void deletar(@PathVariable Long id){
        pessoaRepository.deletarPorId(id);
    }

    @GetMapping("/pessoa")
    public List<Pessoa> listarTodos(){
        return pessoaRepository.listarTodos();
    }



}
