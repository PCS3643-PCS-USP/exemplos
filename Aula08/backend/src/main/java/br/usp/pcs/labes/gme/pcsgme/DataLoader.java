package br.usp.pcs.labes.gme.pcsgme;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.usp.pcs.labes.gme.pcsgme.entity.Carro;
import br.usp.pcs.labes.gme.pcsgme.entity.Endereco;
import br.usp.pcs.labes.gme.pcsgme.entity.Material;
import br.usp.pcs.labes.gme.pcsgme.entity.Pessoa;
import br.usp.pcs.labes.gme.pcsgme.entity.Usuario;
import br.usp.pcs.labes.gme.pcsgme.repository.GerenciadorDeCarros;
import br.usp.pcs.labes.gme.pcsgme.repository.GerenciadorDeMateriais;
import br.usp.pcs.labes.gme.pcsgme.repository.GerenciadorDePessoas;
import br.usp.pcs.labes.gme.pcsgme.repository.GerenciadorDeUsuarios;

@Configuration public class DataLoader {
    @Bean
    ApplicationRunner carregaMateriais(GerenciadorDeMateriais materiais) {
    return args-> {
      if (materiais.count() == 0) {
        materiais.save(new Material("papel A4", 15));
        materiais.save(new Material("caneta azul", 6));
        materiais.save(new Material("lapis", 3));
        materiais.save(new Material("borracha", 4));
      }
    };
  }

    @Bean
    ApplicationRunner carregaPessoas(GerenciadorDeCarros carros, GerenciadorDePessoas pessoas) {
    return args-> {
        if (pessoas.count() == 0) {
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

        // carros.save(c1);
        // carros.save(c2);
        // carros.save(c3);

        pessoas.save(p1);
        pessoas.save(p2);
        pessoas.save(p3);
      }
    };
  }

  @Bean
  ApplicationRunner carregaUsuarios(GerenciadorDeUsuarios usuarios) {
    return args-> {
      if (usuarios.count() == 0) {
        Usuario u1 = new Usuario("Fabio");
        Usuario u2 = new Usuario("Ana");
        Usuario u3 = new Usuario("Joao");

        u1 = usuarios.save(u1);
        usuarios.save(u2);
        usuarios.save(u3);

        Endereco e1 = new Endereco("Rua A", "10", "", "Cidade X", "Estado Y", "12345-678");
        Endereco e2 = new Endereco("Rua B", "12", "apto 123", "Cidade Y", "Estado Z", "23456-789");
        u1.add(e1);
        u1.add(e2);

        usuarios.save(u1);
      }
    };
  }
}
