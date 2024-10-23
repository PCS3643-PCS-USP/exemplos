package br.usp.pcs.labes.gme.pcsgme.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pessoa {
  @Id
  @GeneratedValue
  private long id;
  private String nome;

  @OneToMany(mappedBy = "proprietario") // quem é o proprietário da relação
  private List<Carro> carros;

  public Pessoa() {
    carros = new ArrayList<>();
  }

  public Pessoa(String nome) {
    this.nome = nome;
    carros = new ArrayList<>();
  }

  public long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void add(Carro c) {
    carros.add(c);
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCarros(List<Carro> carros) {
    this.carros = carros;
  }
}
