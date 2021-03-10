package br.com.zup.lojavirtual.services;

import br.com.zup.lojavirtual.models.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    private  List<Cliente> clientes = new ArrayList<>();

    public Cliente cadastrar(Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }

    private boolean validarClientePorEmailOuCpf(String email, String cpf) {

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
