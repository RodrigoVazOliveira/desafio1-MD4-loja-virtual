package br.com.zup.lojavirtual.controllers;

import br.com.zup.lojavirtual.models.Cliente;
import br.com.zup.lojavirtual.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes/")
public class ClienteController {
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastrar(@RequestBody Cliente cliente) {
        return clienteService.cadastrar(cliente);
    }
}
