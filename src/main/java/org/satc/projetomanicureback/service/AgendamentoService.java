package org.satc.projetomanicureback.service;

import jakarta.persistence.EntityNotFoundException;
import org.satc.projetomanicureback.model.Agendamento;
import org.satc.projetomanicureback.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }

    public Optional<Agendamento> buscarPorId(Integer id) {
        return agendamentoRepository.findById(id);
    }

    public Agendamento salvar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento atualizar(Integer id, Agendamento agendamentoAtualizado) {
        return agendamentoRepository.findById(id)
                .map(agendamento -> {
                    agendamento.setDataHora(agendamentoAtualizado.getDataHora());
                    agendamento.setCliente(agendamentoAtualizado.getCliente());
                    agendamento.setServicos(agendamentoAtualizado.getServicos());
                    // Adicione outros campos conforme necessário
                    return agendamentoRepository.save(agendamento);
                })
                .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado"));
    }

    public void deletar(Integer id) {
        agendamentoRepository.deleteById(id);
    }

}


