package br.com.zup.lojavirtual.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Produto {

    @NotNull(message = "O nome não foi informado!")
    @NotEmpty(message = "O nome não foi preenchido!")
    private String nome;

    @NotNull(message = "O preço não foi indicado!")
    @NotEmpty(message = "O preço deve ser preenchido!")
    private Double preco;

    @Min(value = 1, message = "A quantidade deve ser maior do que zero!")
    private int quantidade;

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
