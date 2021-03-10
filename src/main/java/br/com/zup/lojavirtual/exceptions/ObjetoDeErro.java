package br.com.zup.lojavirtual.exceptions;


/**
 * responsável modelo de objeto de exceção de validação de cmapos
 * */
public class ObjetoDeErro {
    private String mensagem;
    private String campo;

    public ObjetoDeErro(String mensagem, String campo) {
        this.mensagem = mensagem;
        this.campo = campo;
    }

    public ObjetoDeErro() {
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }
}
