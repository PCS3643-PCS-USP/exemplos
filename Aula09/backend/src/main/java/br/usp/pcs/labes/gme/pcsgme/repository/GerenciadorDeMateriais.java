package br.usp.pcs.labes.gme.pcsgme.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import br.usp.pcs.labes.gme.pcsgme.entity.Material;

public interface GerenciadorDeMateriais extends CrudRepository<Material, Integer>{
  public Optional<Material> findByCodigo(int codigo);
  public List<Material> findByNome(String nome);
  public List<Material> findMaterialByPrecoLessThan(double valor);


  @Query("from Material m where m.preco < :valor")
  public List<Material> getMateriaisComPrecosAte(double valor);
}
