package br.com.zup.lojavirtual.controllers;

import br.com.zup.lojavirtual.models.Produto;
import br.com.zup.lojavirtual.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produtos/")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastrar(@RequestBody @Valid Produto produto) {
        return produtoService.cadastrar(produto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> mostrarProdutos() {
        try {
            return produtoService.mostrarProdutos();
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.OK, e.getMessage());
        }
    }
}
