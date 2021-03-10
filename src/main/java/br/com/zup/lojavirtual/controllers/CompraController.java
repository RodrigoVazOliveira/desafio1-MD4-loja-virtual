package br.com.zup.lojavirtual.controllers;

import br.com.zup.lojavirtual.dtos.CompraDTO;
import br.com.zup.lojavirtual.models.Cliente;
import br.com.zup.lojavirtual.models.Compra;
import br.com.zup.lojavirtual.services.ClienteService;
import br.com.zup.lojavirtual.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras/")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @Autowired
    private ClienteService clienteService;

    public Compra cadastrar(@RequestBody CompraDTO compraDTO) {
        Cliente cliente = clienteService.pesquisarClientePorCpf(compraDTO.getCpf());
    }
}
