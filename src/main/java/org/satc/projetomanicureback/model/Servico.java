package org.satc.projetomanicureback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServico;
    private String nome;
    private String descricao;
    private Double duracaoMinutos;
    private Integer preco;


}
