package br.usp.pcs.labes.gme.pcsgme.entity;

public class Item {
  private int quantidade;
  private Material m;

  public Item(Material m, int quantidade) {
    this.m = m;
    this.quantidade = quantidade;
  }

  public Item(Material m) {
    this(m, 1);
  }
  
  public int getQuantidade() {
    return quantidade;
  }

  public Material getMaterial() {
    return m;
  }

  public double getValor() {
    return quantidade * m.getPreco();
  }
}
