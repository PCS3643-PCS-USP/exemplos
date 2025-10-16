package br.usp.pcs.labes.gme.pcsgme.repository;

import org.springframework.data.repository.CrudRepository;

import br.usp.pcs.labes.gme.pcsgme.entity.Usuario;

public interface GerenciadorDeUsuarios extends CrudRepository<Usuario, Integer>{
}
