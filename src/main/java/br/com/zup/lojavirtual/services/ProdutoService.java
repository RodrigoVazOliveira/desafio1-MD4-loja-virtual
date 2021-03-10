package br.com.zup.lojavirtual.services;

import br.com.zup.lojavirtual.dtos.ProdutoDTO;
import br.com.zup.lojavirtual.exceptions.ProdutoDuplicadoExcecao;
import br.com.zup.lojavirtual.exceptions.ProdutoListaVaziaExcecao;
import br.com.zup.lojavirtual.models.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();

    public Produto cadastrar(Produto produto) {
        if (!produtos.contains(produto)) {
            produtos.add(produto);
            return produto;
        } else {
            throw new ProdutoDuplicadoExcecao("O produto " + produto.getNome() + " já foi cadastro na loja!");
        }
    }

    public List<Produto> mostrarProdutos() {
        if (produtos.size() > 0) {
            return produtos;
        }
        throw new ProdutoListaVaziaExcecao("Não existe produto cadastrado!");
    }

    public List<Produto> buscarListaDeCompra(List<ProdutoDTO> produtoDTOs) {
        List<Produto> produtosCompra = null;

        for (ProdutoDTO produtoDTO : produtoDTOs) {
            for (Produto produto : this.produtos) {
                if (produto.getNome().equalsIgnoreCase(produtoDTO.getNome())) {
                    produtosCompra.add(produto);
                }
            }
        }

        if (produtosCompra.size() > 0) {
            return produtosCompra;
        }

        throw new ProdutoListaVaziaExcecao("Os produtos na lista de compras não existem!");
    }
}