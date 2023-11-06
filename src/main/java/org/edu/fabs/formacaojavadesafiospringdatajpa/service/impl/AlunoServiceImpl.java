package org.edu.fabs.formacaojavadesafiospringdatajpa.service.impl;

import org.edu.fabs.formacaojavadesafiospringdatajpa.entity.Aluno;
import org.edu.fabs.formacaojavadesafiospringdatajpa.entity.AvaliacaoFisica;
import org.edu.fabs.formacaojavadesafiospringdatajpa.entity.form.AlunoForm;
import org.edu.fabs.formacaojavadesafiospringdatajpa.entity.form.AlunoUpdateForm;
import org.edu.fabs.formacaojavadesafiospringdatajpa.infra.utils.JavaTimeUtils;
import org.edu.fabs.formacaojavadesafiospringdatajpa.repository.AlunoRepository;
import org.edu.fabs.formacaojavadesafiospringdatajpa.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {

    private AlunoRepository repository;

    @Autowired
    public AlunoServiceImpl(AlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());
        repository.save(aluno);
        return aluno;
    }

    @Override
    public Aluno get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {
        if (dataDeNascimento == null) {
            return repository.findAll();
        } else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return repository.findByDataDeNascimento(localDate);
        }
    }

    @Override
    public List<Aluno> getAllAlunos() {
        return repository.findAll();
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
        Aluno aluno = repository.findById(id).get();
        return aluno.getAvaliacoes();
    }

}
