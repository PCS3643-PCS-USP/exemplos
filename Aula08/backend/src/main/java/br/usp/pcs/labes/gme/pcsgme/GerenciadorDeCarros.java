package br.usp.pcs.labes.gme.pcsgme;

import org.springframework.data.repository.CrudRepository;
import br.usp.pcs.labes.gme.pcsgme.entity.Carro;

public interface GerenciadorDeCarros extends CrudRepository<Carro, Integer>{
}

