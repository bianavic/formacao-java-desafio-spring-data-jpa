package org.edu.fabs.formacaojavadesafiospringdatajpa.repository;

import org.edu.fabs.formacaojavadesafiospringdatajpa.entity.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {
}
