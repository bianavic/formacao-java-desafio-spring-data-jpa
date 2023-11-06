package org.edu.fabs.formacaojavadesafiospringdatajpa.controller;

import jakarta.validation.Valid;
import org.edu.fabs.formacaojavadesafiospringdatajpa.entity.Aluno;
import org.edu.fabs.formacaojavadesafiospringdatajpa.entity.AvaliacaoFisica;
import org.edu.fabs.formacaojavadesafiospringdatajpa.entity.form.AlunoForm;
import org.edu.fabs.formacaojavadesafiospringdatajpa.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form) {
        return service.create(form);
    }

    @GetMapping("/lista")
    public List<Aluno> getAllAlunos() {
        return service.getAllAlunos();
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaId(id);
    }

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                              String dataDeNacimento){
        return service.getAll(dataDeNacimento);
    }

}
