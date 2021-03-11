package br.com.zup.lojavirtual.services;

import br.com.zup.lojavirtual.exceptions.CompraVaziaExcecao;
import br.com.zup.lojavirtual.models.Compra;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompraService {

    private List<Compra> compras = new ArrayList<>();

    public Compra cadastrar(Compra compra) {
        compras.add(compra);
        return compra;
    }

    public List<Compra> mostrarTodasAsCompras() {
        if (this.compras.size() > 0) {
            return this.compras;
        }

        throw new CompraVaziaExcecao("Não existe compras cadastradas!");
    }

    public List<Compra> pesquisarComprasPorCpf(String cpf) {
        List<Compra> listaDeCompras = procurarPorCpf(cpf);

        if (listaDeCompras.size() > 0) {
            return listaDeCompras;
        }

        throw new CompraVaziaExcecao("Nenhuma compra foi realizada como CPF " + cpf);
    }

    /**
     * Criar um lista de compras com o cpf passado por parametro
     * caso ele encontre alguma compra com o cpf.
     * @param cpf
     * @return List<Compra>
     * */
    private List<Compra> procurarPorCpf(String cpf) {
        List<Compra> listaDeCompras = new ArrayList<>();

        for (Compra compra : this.compras) {
            if (compra.getCliente().getCpf().equalsIgnoreCase(cpf)) {
                listaDeCompras.add(compra);
            }
        }

        return listaDeCompras;
    }

}
