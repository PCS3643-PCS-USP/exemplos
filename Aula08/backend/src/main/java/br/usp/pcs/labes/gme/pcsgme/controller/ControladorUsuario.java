package br.usp.pcs.labes.gme.pcsgme.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.usp.pcs.labes.gme.pcsgme.entity.Usuario;
import br.usp.pcs.labes.gme.pcsgme.repository.GerenciadorDeUsuarios;

@RestController
@RequestMapping(produces = "application/json")
@CrossOrigin(origins={"http://localhost:3000"})
public class ControladorUsuario {
  private final GerenciadorDeUsuarios gerenciador;  
  
  public ControladorUsuario(GerenciadorDeUsuarios gerenciador) {
        this.gerenciador = gerenciador;
    }

    @GetMapping(path="/api/usuarios")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(Usuario.Simples.class)
    public Iterable<Usuario> getAll() {
        return gerenciador.findAll();
    }

    @GetMapping(path="/api/usuarios/{id}")
    public Optional<Usuario> getMaterial(@PathVariable int id) {
        return gerenciador.findById(id);
    }
}
