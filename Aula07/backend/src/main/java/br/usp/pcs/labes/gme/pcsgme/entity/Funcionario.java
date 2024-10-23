package br.usp.pcs.labes.gme.pcsgme.entity;

import java.util.ArrayList;
import java.util.Collection;

public class Funcionario {
  private ArrayList<Solicitacao> solicitacoes;
  private Area area;

  public Funcionario(Area a) {
    solicitacoes = new ArrayList<Solicitacao>();
    this.area = a;
  }

  public Collection<Solicitacao> getSolicitacoesNoMes() {
    return solicitacoes;
  }
  
  public Solicitacao solicita(Material m, int quantidade) {
    Solicitacao atual = new Solicitacao();
    atual.adiciona(m, quantidade);
    this.solicitacoes.add(atual);

    double total = 0;
    for (Solicitacao s: getSolicitacoesNoMes())
      total += s.getValor();
    
    if (total > area.getQuota()) {
      return atual;
    } else {
      atual.confirma();
      return atual;
    }
  }
}
