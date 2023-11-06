package org.edu.fabs.formacaojavadesafiospringdatajpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String cpf;

    private String bairro;

    private LocalDate dataDeNascimento;

    /*
    melhora performance
    LAZY -> qdo pedir infos do aluno X,
    todas as infos sao carregadas menos aquelas referentes à lista de avaliacao fisica
    para consultar as avaliacoes fisicas, cria um metodo, um endpoint, que entao torna as avaliacoes referentes a esse aluno X
    @JsonIgnore
    neste ponto pode aparecer exceptions relacionadas à serializacao, json ou um loop infinito
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    esta é outra anotacao para utilizar
     */
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
