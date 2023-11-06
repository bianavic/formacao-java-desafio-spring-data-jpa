package org.edu.fabs.formacaojavadesafiospringdatajpa.service.impl;

import org.edu.fabs.formacaojavadesafiospringdatajpa.entity.Aluno;
import org.edu.fabs.formacaojavadesafiospringdatajpa.entity.AvaliacaoFisica;
import org.edu.fabs.formacaojavadesafiospringdatajpa.entity.form.AvaliacaoFisicaForm;
import org.edu.fabs.formacaojavadesafiospringdatajpa.entity.form.AvaliacaoFisicaUpdateForm;
import org.edu.fabs.formacaojavadesafiospringdatajpa.repository.AlunoRepository;
import org.edu.fabs.formacaojavadesafiospringdatajpa.repository.AvaliacaoFisicaRepository;
import org.edu.fabs.formacaojavadesafiospringdatajpa.service.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements AvaliacaoFisicaService  {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return avaliacaoFisicaRepository.findById(id).get();
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {
        avaliacaoFisicaRepository.deleteById(id);
    }

}
