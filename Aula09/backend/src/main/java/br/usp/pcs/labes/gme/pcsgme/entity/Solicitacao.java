package br.usp.pcs.labes.gme.pcsgme.entity;

import java.util.ArrayList;
import java.util.Date;

public class Solicitacao {
  protected enum Status {CRIADA, DENTRO_DA_QUOTA, APROVADA, RECUSADA};
  protected Status status;
  private Date data;
  private ArrayList<Item> itens;
  private Almoxarifado a;

  public Solicitacao(Almoxarifado a) {
    status = Status.CRIADA;
    data = new Date();
    itens = new ArrayList<Item>();
    this.a = a;
  }

  public double getValor() {
    double total = 0;
    for (Item i: itens)
      total += i.getValor();

    return total;
  }

  public void adiciona(Material m, int quantidade) {
    itens.add(new Item(m, quantidade));
  }

  public void confirma() {
    if (status == Status.CRIADA) {
      this.status = Status.DENTRO_DA_QUOTA;
      a.avisa(this);
    } else {
      throw new IllegalStateException("Não é possível confirmar: " + status);
    }
  }

  public Date getData() {
    return data;
  }
}
