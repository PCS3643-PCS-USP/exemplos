package br.usp.pcs.labes.gme.pcsgme.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Carro {
  @Id
  @GeneratedValue
  private long id;
  private String placa;
  // @ManyToOne(optional = false)
  // private Pessoa proprietario;

  public Carro() {
  }

  public Carro(long id, String placa, Pessoa proprietario) {
    this.id = id;
    this.placa = placa;
    // this.proprietario = proprietario;
  }

  public Carro(String placa, Pessoa proprietario) {
    this.placa = placa;
    // this.proprietario = proprietario;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  // public Pessoa getProprietario() {
  //   return proprietario;
  // }

  // public void setProprietario(Pessoa proprietario) {
  //   this.proprietario = proprietario;
  // }
}
