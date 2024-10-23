package br.usp.pcs.labes.gme.pcsgme.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.usp.pcs.labes.gme.pcsgme.entity.Material;
import br.usp.pcs.labes.gme.pcsgme.repository.GerenciadorDeMateriais;
import jakarta.validation.Valid;

@RestController
@RequestMapping(produces = "application/json")
@CrossOrigin(origins={"http://localhost:3000", "http://pcs.usp.br"})
public class ControladorMaterial {
  private final GerenciadorDeMateriais gerenciador;  
  
  public ControladorMaterial(GerenciadorDeMateriais gerenciador) {
        this.gerenciador = gerenciador;
    }

    @GetMapping(path="/api/materiais")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Material> getAll() {
        return gerenciador.findAll();
    }

    @PostMapping(path="/api/materiais")
    public ResponseEntity<?> adicionar(@Valid @RequestBody Material m, Errors errors) {
        if (errors.hasErrors()) {
            return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Material salvo = gerenciador.save(m);
        return new ResponseEntity<>(salvo, HttpStatus.OK);
    }

    @GetMapping(path="/api/materiais/{id}")
    public Optional<Material> getMaterial(@PathVariable int id) {
        return gerenciador.findByCodigo(id);
    }

    @GetMapping(path="/api/materiais/preco/{preco}")
    public List<Material> getMateriais(@PathVariable double preco) {
        return gerenciador.getMateriaisComPrecosAte(preco);
    }
}
