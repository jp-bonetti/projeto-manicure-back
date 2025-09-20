package org.satc.projetomanicureback.service;

import org.satc.projetomanicureback.repository.ServicoRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }
}
