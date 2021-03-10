package br.com.zup.lojavirtual.services;

import br.com.zup.lojavirtual.models.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();

    public Produto cadastrar(Produto produto) {
        produtos.add(produto);
        return produto;
    }

    public List<Produto> mostrarProdutos() {
        if (produtos.size() > 0) {
            return produtos;
        }
        throw new RuntimeException("Não existe produto cadastrado!");
    }
}