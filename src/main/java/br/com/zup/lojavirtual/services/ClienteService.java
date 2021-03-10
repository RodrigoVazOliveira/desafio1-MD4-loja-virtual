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
}
