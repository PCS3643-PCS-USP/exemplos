package br.usp.pcs.labes.gme.pcsgme.entity;

public class Area {
  // Como lidar com o 1 : 1? setResponsavel
  private Gerente responsavel;
  private double quota;

  public Area(double quota) {
    this.quota = quota;
  }

  public void setResponsavel(Gerente responsavel) {
    this.responsavel = responsavel;
  }

  public Gerente getResponsavel() {
    return responsavel;
  }

  public double getQuota() {
    return quota;
  }
}
