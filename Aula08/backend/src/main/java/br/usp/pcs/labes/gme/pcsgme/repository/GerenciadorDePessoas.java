package br.usp.pcs.labes.gme.pcsgme.repository;

import org.springframework.data.repository.CrudRepository;
import br.usp.pcs.labes.gme.pcsgme.entity.Pessoa;
import java.util.List;

public interface GerenciadorDePessoas extends CrudRepository<Pessoa, Integer>{
  List<Pessoa> findByNome(String nome);
}

