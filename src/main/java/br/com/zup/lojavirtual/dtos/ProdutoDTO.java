package br.com.zup.lojavirtual.dtos;

public class ProdutoDTO {

    private String nome;

    public ProdutoDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return " Produto: " +
                "nome='" + nome ;
    }
}
