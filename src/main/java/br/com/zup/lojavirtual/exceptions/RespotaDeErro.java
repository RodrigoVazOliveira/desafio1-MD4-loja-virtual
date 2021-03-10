package br.com.zup.lojavirtual.exceptions;

import java.util.List;


/**
* responsavel por montar a resposta de validação de campos
* */
public class RespotaDeErro {
    private String tipoDeErro;
    private int codigoDoErro;
    private String statusCode;
    private List<ObjetoDeErro> objetoDeErro;

    public RespotaDeErro(String tipoDeErro, int codigoDoErro, String statusCode, List<ObjetoDeErro> objetoDeErro) {
        this.tipoDeErro = tipoDeErro;
        this.codigoDoErro = codigoDoErro;
        this.statusCode = statusCode;
        this.objetoDeErro = objetoDeErro;
    }

    public RespotaDeErro() {
    }

    public String getTipoDeErro() {
        return tipoDeErro;
    }

    public void setTipoDeErro(String tipoDeErro) {
        this.tipoDeErro = tipoDeErro;
    }

    public int getCodigoDoErro() {
        return codigoDoErro;
    }

    public void setCodigoDoErro(int codigoDoErro) {
        this.codigoDoErro = codigoDoErro;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public List<ObjetoDeErro> getObjetoDeErro() {
        return objetoDeErro;
    }

    public void setObjetoDeErro(List<ObjetoDeErro> objetoDeErro) {
        this.objetoDeErro = objetoDeErro;
    }
}
