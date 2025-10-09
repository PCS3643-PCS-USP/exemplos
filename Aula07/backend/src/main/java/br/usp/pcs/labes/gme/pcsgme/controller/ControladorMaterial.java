package br.usp.pcs.labes.gme.pcsgme.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(produces = "application/json")
@CrossOrigin(origins={"http://localhost:3000", "http://pcs.usp.br"})
public class ControladorMaterial {
  private final GerenciadorDeMateriais gerenciador;  
  
  public ControladorMaterial(GerenciadorDeMateriais gerenciador) {
        this.gerenciador = gerenciador;
    }

    @GetMapping(path="/api/materiais")
    @Operation(summary = "Retorna todos os materiais cadastrados")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Material> getAll() {
        return gerenciador.getMateriais();
    }

    @PostMapping(path="/api/materiais")
    @Operation(summary = "Adiciona um material")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Material adicionado"),
        @ApiResponse(responseCode = "400", description = "Erro ao adicionar material")
    })
    public ResponseEntity<?> adicionar(@RequestBody Material m) {
        System.out.println(m);
        if (gerenciador.adicionar(m)) {
            return new ResponseEntity<>(m, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(m, HttpStatus.CONFLICT);
        }
    }

    @GetMapping(path="/api/materiais/{id}")
    @Operation(summary = "Obtém um material")
    public Material getMaterial(@PathVariable int id) {
        return gerenciador.getMaterial(id);
    }
}
