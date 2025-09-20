package org.satc.projetomanicureback.Controller;

import jakarta.persistence.EntityNotFoundException;
import org.satc.projetomanicureback.model.Servico;
import org.satc.projetomanicureback.service.ServicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    private final ServicoService servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @GetMapping
    public List<Servico> listarServicos() {
        return servicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Servico buscarPorId(@PathVariable Integer id) {
        return servicoService.buscarPorId(id).orElseThrow(
                () -> new EntityNotFoundException("Serviço não encontrado com id: " + id)
        );
    }

    @PostMapping
    public Servico criarServico(@RequestBody Servico servico) {
        return servicoService.salvar(servico);
    }

    @PutMapping("/{id}")
    public Servico atualizarServico(@PathVariable Integer id, @RequestBody Servico servico) {
        return servicoService.atualizar(id, servico);
    }

    @DeleteMapping("/{id}")
    public void deletarServico(@PathVariable Integer id) {
        servicoService.deletar(id);
    }
}
