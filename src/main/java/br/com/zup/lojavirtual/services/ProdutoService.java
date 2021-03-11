package br.com.zup.lojavirtual.services;

import br.com.zup.lojavirtual.dtos.ProdutoDTO;
import br.com.zup.lojavirtual.exceptions.ProdutoDuplicadoExcecao;
import br.com.zup.lojavirtual.exceptions.ProdutoEmFaltaExcecao;
import br.com.zup.lojavirtual.exceptions.ProdutoListaVaziaExcecao;
import br.com.zup.lojavirtual.models.Compra;
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
        throw new ProdutoListaVaziaExcecao("Não existem produtos cadastrados!");
    }

    /**
     * buscar os produtos pelos nomes de produtos que foram passado como produtoDTO
     * atráves do método criarListaDeProdutoDeCompra gerando uma nova lista
     * com os produtos que o cliente deseja comprar
     * @param produtoDTOs
     * @return List<Produto>
     * */
    public List<Produto> buscarListaDeCompra(List<ProdutoDTO> produtoDTOs) {
        List<Produto> produtosCompra = criarListaDeProdutoDeCompra(produtoDTOs);

        if (produtosCompra.size() > 0) {
            return produtosCompra;
        }

        throw new ProdutoListaVaziaExcecao("Os produtos " + produtoDTOs + " na lista de compras não existem!");
    }

    /**
     * O método criar uma lista de produtos baseado no nome que foi passado na DTO.
     * Percorrendo a lista de produtos propriamente dito, criando uma nova lista com
     * os produtos que são iguais aos nomes passados na DTO.
     * Ao adiconar na lista de produtos diminui a quantidade do produto
     * @param produtoDTOs
     * @return List<Produto>
     * */
    private List<Produto> criarListaDeProdutoDeCompra(List<ProdutoDTO> produtoDTOs) {
        List<Produto> produtosCompra = new ArrayList<>();

        for (ProdutoDTO produtoDTO : produtoDTOs) {
            for (Produto produto : this.produtos) {
                validarProduto(produtoDTO, produto, produtosCompra);
            }
        }

        return produtosCompra;
    }

    /**
     * responsável por validar se o produto que cliente deseja
     * e se ele está disponível
     * @param produtoDTO
     * @param produto
     * @param produtosCompra
     * */
    private void validarProduto(ProdutoDTO produtoDTO, Produto produto, List<Produto> produtosCompra) {
        if (produto.getNome().equalsIgnoreCase(produtoDTO.getNome())
                && verificarDisponibilidadeProduto(produto)) {
            ajustarQuantidadeDoProduto(produto);
            produtosCompra.add(produto);
        }
    }

    /**
     * responsável pora diminuir o produto ao compra
     * @param produto
     * */
    private void ajustarQuantidadeDoProduto(Produto produto) {
        produto.setQuantidade(produto.getQuantidade()-1);
    }

    /**
     * responsável por verificar se a quantidade do produto é maior que 0.
     * caso seja 0, será retornado um exceção
     * @param produto
     * @return boolean
     * */
    private boolean verificarDisponibilidadeProduto(Produto produto) {
        if (produto.getQuantidade() > 0) {
            return true;
        }
        throw new ProdutoEmFaltaExcecao("O produto " + produto.getNome() + " está em falta!");
    }
}