package br.usp.pcs.labes.gme.pcsgme.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

@Entity
public class Material {
  @Id
  @GeneratedValue
  private long codigo;

  @NotEmpty(message="Nome não pode ser vazio")
  private String nome;
  
  @Positive
  private double preco;

  public Material() {
  }
  
  public Material(String nome, double preco) {
    this.nome = nome;
    this.preco = preco;
  }

  public Material(long codigo, String nome, double preco) {
    this.codigo = codigo;
    this.nome = nome;
    this.preco = preco;
  }

  public long getCodigo() {
    return codigo;
  }

  public String getNome() {
    return nome;
  }

  public double getPreco() {
    return preco;
  }
}