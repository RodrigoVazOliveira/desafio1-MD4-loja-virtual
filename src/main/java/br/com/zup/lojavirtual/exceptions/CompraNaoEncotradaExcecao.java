package br.com.zup.lojavirtual.exceptions;

public class CompraNaoEncotradaExcecao extends RuntimeException {
    private int Status = 400;
    private String campo = "CPF";
    private String razao = "Bad Request";
    private String tipoErro = "Nenhuma compra foi encontrada!";

    public CompraNaoEncotradaExcecao(String message) {
        super(message);
    }

    public CompraNaoEncotradaExcecao() {
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getTipoErro() {
        return tipoErro;
    }

    public void setTipoErro(String tipoErro) {
        this.tipoErro = tipoErro;
    }
}
