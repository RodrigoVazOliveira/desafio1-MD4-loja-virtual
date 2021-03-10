package br.com.zup.lojavirtual.controllers;

import br.com.zup.lojavirtual.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras/")
public class CompraController {

    @Autowired
    private CompraService compraService;
}
