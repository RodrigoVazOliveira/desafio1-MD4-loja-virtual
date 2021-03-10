package br.com.zup.lojavirtual.controllers;

import br.com.zup.lojavirtual.services.ClienteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes/")
public class ClienteController {
    private ClienteService clienteService;

    
}
