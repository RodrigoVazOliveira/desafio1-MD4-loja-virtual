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

}
