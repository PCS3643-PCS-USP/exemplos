package br.usp.pcs.labes.gme.pcsgme;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.usp.pcs.labes.gme.pcsgme.entity.Carro;
import br.usp.pcs.labes.gme.pcsgme.entity.Material;
import br.usp.pcs.labes.gme.pcsgme.entity.Pessoa;
import br.usp.pcs.labes.gme.pcsgme.repository.GerenciadorDeMateriais;
import br.usp.pcs.labes.gme.pcsgme.repository.GerenciadorDePessoas;

@Configuration public class DataLoader {
  private GerenciadorDeMateriais materiais;
  private GerenciadorDeCarros carros;
  private GerenciadorDePessoas pessoas;

  DataLoader(GerenciadorDeMateriais materiais, GerenciadorDeCarros carros, GerenciadorDePessoas pessoas) {
    this.materiais = materiais;
    this.carros = carros;
    this.pessoas = pessoas;
  }

  @Bean public ApplicationRunner carregaMateriais() {
    return args-> {
      materiais.save(new Material(1, "papel A4", 15));
      materiais.save(new Material(2, "caneta azul", 6));
      materiais.save(new Material(3, "lapis", 3));
      materiais.save(new Material(4, "borracha", 4));
    };
  }

  @Bean public ApplicationRunner carregaPessoas() {
    return args-> {
      Pessoa p1 = new Pessoa("Fabio");
      Pessoa p2 = new Pessoa("Ana");
      Pessoa p3 = new Pessoa("Joao");

      p1 = pessoas.save(p1);
      p2 = pessoas.save(p2);
      p3 = pessoas.save(p3);

      Carro c1 = new Carro("ABC", p1);
      Carro c2 = new Carro("ABD", p1);
      p1.add(c1);
      p1.add(c2);
      Carro c3 = new Carro("XYZ", p2);
      p2.add(c3);

      carros.save(c1);
      carros.save(c2);
      carros.save(c3);
    };
  }
}
