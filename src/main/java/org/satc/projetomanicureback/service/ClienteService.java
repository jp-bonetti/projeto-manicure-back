package org.satc.projetomanicureback.service;

import jakarta.persistence.EntityNotFoundException;
import org.satc.projetomanicureback.model.Cliente;
import org.satc.projetomanicureback.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Integer id) {
        return clienteRepository.findById(id);
    }

    public Cliente atualizar(Integer id, Cliente clienteAtualizado) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setEmail(clienteAtualizado.getEmail());
                    // atualize outros campos conforme necessário
                    return clienteRepository.save(cliente);
                })
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
    }

    public void deletar(Integer id) {
        clienteRepository.deleteById(id);
    }


}
