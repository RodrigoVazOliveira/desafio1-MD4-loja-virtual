package br.com.zup.lojavirtual.models;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Produto {

    @NotNull(message = "O campo nome não foi informado!")
    @NotEmpty(message = "O nome não foi preenchido!")
    private String nome;

    @NotNull(message = "O campo preço não foi informado!")
    @DecimalMin("0.0")
    private Double preco;

    @NotNull(message = "O campo quntidade não foi informado")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
