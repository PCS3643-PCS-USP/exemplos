package br.usp.pcs.labes.gme.pcsgme.entity;

import java.util.ArrayList;
import java.util.Date;

public class Solicitacao {
  private enum Status {CRIADA, DENTRO_DA_QUOTA, APROVADA, RECUSADA;};
  private Status status;
  private Date data;
  private ArrayList<Item> itens;

  public Solicitacao() {
    status = Status.CRIADA;
    data = new Date();
    itens = new ArrayList<Item>();
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
      // Almoxarifado.INSTANCIA.avisa(this);
    } else {
      throw new IllegalStateException("Não é possível confirmar: " + status);
    }
  }

  public Date getData() {
    return data;
  }
}
