package org.edu.fabs.formacaojavadesafiospringdatajpa.service.impl;

import org.edu.fabs.formacaojavadesafiospringdatajpa.entity.Aluno;
import org.edu.fabs.formacaojavadesafiospringdatajpa.entity.Matricula;
import org.edu.fabs.formacaojavadesafiospringdatajpa.entity.form.MatriculaForm;
import org.edu.fabs.formacaojavadesafiospringdatajpa.repository.AlunoRepository;
import org.edu.fabs.formacaojavadesafiospringdatajpa.repository.MatriculaRepository;
import org.edu.fabs.formacaojavadesafiospringdatajpa.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        matricula.setAluno(aluno);
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {
        return matriculaRepository.findById(id).get();
    }

    @Override
    public List<Matricula> getAll(String bairro) {
        if (bairro == null) {
            return matriculaRepository.findAll();
        } else {
            return matriculaRepository.findAlunosMatriculadosBairro(bairro);
        }
    }

    @Override
    public void delete(Long id) {
        matriculaRepository.deleteById(id);
    }

}
