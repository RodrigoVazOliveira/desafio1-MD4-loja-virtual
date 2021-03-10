package br.com.zup.lojavirtual.services;

import br.com.zup.lojavirtual.exceptions.ClienteDuplicadoExcecao;
import br.com.zup.lojavirtual.models.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    private  List<Cliente> clientes = new ArrayList<>();

    public Cliente cadastrar(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
            return cliente;
        }
        throw new ClienteDuplicadoExcecao("O CPF " + cliente.getCpf() + " ou e-mail " + cliente.getEmail() + " Já exliste na loja!");
    }

    public Cliente pesquisarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equalsIgnoreCase(cpf)) {
                return cliente;
            }
        }
        throw new RuntimeException("Nenhum cliente foi encontrado com CPF: " + cpf);
    }
}
