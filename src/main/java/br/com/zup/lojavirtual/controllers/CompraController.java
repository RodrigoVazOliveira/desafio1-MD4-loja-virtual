package br.com.zup.lojavirtual.controllers;

import br.com.zup.lojavirtual.dtos.CompraDTO;
import br.com.zup.lojavirtual.models.Cliente;
import br.com.zup.lojavirtual.models.Compra;
import br.com.zup.lojavirtual.models.Produto;
import br.com.zup.lojavirtual.services.ClienteService;
import br.com.zup.lojavirtual.services.CompraService;
import br.com.zup.lojavirtual.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras/")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Compra cadastrar(@RequestBody CompraDTO compraDTO) {
        Cliente cliente = clienteService.pesquisarClientePorCpf(compraDTO.getCpf());
        List<Produto> produtos = produtoService.buscarListaDeCompra(compraDTO.getProdutos());
        return compraService.cadastrar(compraDTO.converterCompraDtoParaCompra(cliente, produtos));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Compra> mostrarTodasAsCompras() {
        return compraService.mostrarTodasAsCompras();
    }
}
