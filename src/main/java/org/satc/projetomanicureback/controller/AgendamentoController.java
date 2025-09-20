package org.satc.projetomanicureback.controller;

import jakarta.persistence.EntityNotFoundException;
import org.satc.projetomanicureback.model.Agendamento;
import org.satc.projetomanicureback.service.AgendamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @GetMapping
    public List<Agendamento> listarAgendamentos() {
        return agendamentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Agendamento buscarAgendamento(@PathVariable Integer id) {

        return agendamentoService.buscarPorId(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado com id: " + id));
    }

    @PostMapping
    public Agendamento criarAgendamento(@RequestBody Agendamento agendamento) {
        return agendamentoService.salvar(agendamento);
    }

    @PutMapping("/{id}")
    public Agendamento atualizarAgendamento(@PathVariable Integer id, @RequestBody Agendamento agendamento) {
        return agendamentoService.atualizar(id, agendamento);
    }

    @DeleteMapping("/{id}")
    public void deletarAgendamento(@PathVariable Integer id) {
        agendamentoService.deletar(id);
    }
}
