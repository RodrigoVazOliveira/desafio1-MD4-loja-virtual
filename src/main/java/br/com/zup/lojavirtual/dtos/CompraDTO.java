package br.com.zup.lojavirtual.dtos;

import br.com.zup.lojavirtual.models.Cliente;
import br.com.zup.lojavirtual.models.Compra;
import br.com.zup.lojavirtual.models.Produto;

import java.util.List;

public class CompraDTO {

    private String cpf;
    private List<ProdutoDTO> produtos;

    public CompraDTO() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    public Compra converterCompraDtoParaCompra(Cliente cliente, List<Produto> produtos) {
        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setProdutos(produtos);
        return compra;
    }
}