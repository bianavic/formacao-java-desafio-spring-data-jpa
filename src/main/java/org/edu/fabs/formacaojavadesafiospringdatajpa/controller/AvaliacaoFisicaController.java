package org.edu.fabs.formacaojavadesafiospringdatajpa.controller;

import org.edu.fabs.formacaojavadesafiospringdatajpa.entity.AvaliacaoFisica;
import org.edu.fabs.formacaojavadesafiospringdatajpa.entity.form.AvaliacaoFisicaForm;
import org.edu.fabs.formacaojavadesafiospringdatajpa.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl service;

    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
        return service.create(form);
    }

    @GetMapping
    public List<AvaliacaoFisica> getAll(){
        return service.getAll();
    }

}
