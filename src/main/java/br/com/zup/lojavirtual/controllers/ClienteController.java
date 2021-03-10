package br.com.zup.lojavirtual.controllers;

import br.com.zup.lojavirtual.models.Cliente;
import br.com.zup.lojavirtual.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/clientes/")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastrar(@RequestBody Cliente cliente) {
        return clienteService.cadastrar(cliente);
    }

    @GetMapping("{cpf}/")
    @ResponseStatus(HttpStatus.OK)
    public Cliente pesquisarClientePorCpf(@PathVariable String cpf) {
        try {
            return clienteService.pesquisarClientePorCpf(cpf);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
