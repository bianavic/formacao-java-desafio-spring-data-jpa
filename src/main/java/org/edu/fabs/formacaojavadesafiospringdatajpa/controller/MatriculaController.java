package org.edu.fabs.formacaojavadesafiospringdatajpa.controller;

import jakarta.validation.Valid;
import org.edu.fabs.formacaojavadesafiospringdatajpa.entity.Matricula;
import org.edu.fabs.formacaojavadesafiospringdatajpa.entity.form.MatriculaForm;
import org.edu.fabs.formacaojavadesafiospringdatajpa.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl service;

    @PostMapping
    public Matricula create(@Valid @RequestBody MatriculaForm form) {
        return service.create(form);
    }

    @GetMapping
    public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
        return service.getAll(bairro);
    }

}
