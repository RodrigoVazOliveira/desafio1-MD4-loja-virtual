package br.com.zup.lojavirtual.models;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Cliente {

    @NotNull(message = "O campo nome deve ser fornecido!")
    @NotEmpty(message = "O nome deve ser informado!")
    private String nome;

    @NotNull(message = "O campo CPF deve ser fornecido!")
    @NotEmpty(message = "O CPF deve ser informado!")
    @CPF(message = "O CPF informado é inválido!")
    private String cpf;

    @NotNull(message = "O campo e-mail deve ser fornecido!")
    @NotEmpty(message = "O e-mail deve ser informado!")
    @Email(message = "O e-mail informado é inválido!")
    private String email;

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf) || Objects.equals(email, cliente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, email);
    }
}
