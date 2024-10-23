package br.usp.pcs.labes.gme.pcsgme.repository;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import br.usp.pcs.labes.gme.pcsgme.entity.Material;

@Repository
public class GerenciadorDeMateriais {
  private HashMap<Integer, Material> materiais;
  
  public GerenciadorDeMateriais() {
    materiais = new HashMap<Integer, Material>();
    materiais.put(1, new Material(1, "papel A4", 15));
    materiais.put(2, new Material(2, "caneta azul", 6));
    materiais.put(3, new Material(3, "lapis", 3));
    materiais.put(4, new Material(4, "borracha", 4));
  }

  public boolean adicionar(Material m) {
    if (materiais.containsKey(m.getCodigo()))
      return false;
    
    materiais.put(m.getCodigo(), m);
    return true;
  }

  public Collection<Material> getMateriais() {
    return materiais.values();
  }

  public Material getMaterial (int id) {
    return materiais.get(id);
  }
}
