package br.com.zup.lojavirtual.exceptions;

public class CompraVaziaExcecao extends RuntimeException {
    private int Status = 200;
    private String campo = "";
    private String razao = "Ok";
    private String tipoErro = "Lista de compras vazia";

    public CompraVaziaExcecao(String message) {
        super(message);
    }

    public CompraVaziaExcecao() {
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
