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

    /**
     * buscar os produtos pelos nomes de produtos que foram passado como produtoDTO
     * atráves do método criarListaDeProdutoDeCompra gerando uma nova lista
     * com os produtos de compra
     * @param produtoDTOs
     * @return List<Produto>
     * */
    public List<Produto> buscarListaDeCompra(List<ProdutoDTO> produtoDTOs) {
        List<Produto> produtosCompra = criarListaDeProdutoDeCompra(produtoDTOs);

        if (produtosCompra.size() > 0) {
            return produtosCompra;
        }

        throw new ProdutoListaVaziaExcecao("Os produtos na lista de compras não existem!");
    }

    /**
     * O método criar uma lista de produtos baseado no nome que foi passado na DTO.
     * Percorrendo a lista de produtos propriamente dito, criando uma nova lista com
     * os produtos que são iguais aos nomes passados na DTO.
     * @param produtoDTOs
     * @return List<Produto>
     * */
    private List<Produto> criarListaDeProdutoDeCompra(List<ProdutoDTO> produtoDTOs) {
        List<Produto> produtosCompra = null;

        for (ProdutoDTO produtoDTO : produtoDTOs) {
            for (Produto produto : this.produtos) {
                if (produto.getNome().equalsIgnoreCase(produtoDTO.getNome())) {
                    produtosCompra.add(produto);
                }
            }
        }

        return produtosCompra;
    }

}