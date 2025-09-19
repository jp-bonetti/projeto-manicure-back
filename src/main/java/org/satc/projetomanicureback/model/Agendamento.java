package org.satc.projetomanicureback.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAgendamento;
    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "idCliente")
    private Cliente cliente;
    @ManyToMany
    @JoinTable(
            name = "agendamento_servico",
            joinColumns = @JoinColumn(name = "agendamento_id", referencedColumnName = "idAgendamento"),
            inverseJoinColumns = @JoinColumn(name = "servico_id", referencedColumnName = "idServico")
    )
    private List<Servico> servicos;
    private LocalDateTime dataHora;
    private String status;
    private String observacoes;

}
