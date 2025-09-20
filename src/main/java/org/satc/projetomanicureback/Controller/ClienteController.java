package org.satc.projetomanicureback.Controller;

import jakarta.persistence.EntityNotFoundException;
import org.satc.projetomanicureback.model.Cliente;
import org.satc.projetomanicureback.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Cliente buscarCliente(@PathVariable Integer id) {
        return clienteService.buscarPorId(id).orElseThrow(
                () -> new EntityNotFoundException("Cliente não encontrado com id: " + id)
        );
    }

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        return clienteService.atualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Integer id) {
        clienteService.deletar(id);
    }
}
