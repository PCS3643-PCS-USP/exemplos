package br.usp.pcs.labes.gme.pcsgme.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

@RestController
@RequestMapping(produces = "application/json")
@SessionScope // Para ser por sessão
public class ControladorSessao {
    private int teste = -1;

    @GetMapping(path="/api/teste/{id}")
    public void setTeste(@PathVariable int id) {
        this.teste = id;
    }

    @GetMapping(path="/api/teste/")
    public int getTeste() {
        return teste;
    }
}
