package br.usp.pcs.labes.gme.pcsgme.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {
  public interface Simples {};

  @Id
  @GeneratedValue
  @JsonView(Simples.class)
  private long id;
  
  @JsonView(Simples.class)
  private String nome;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name ="usuario_id")
  private List<Endereco> enderecos;

  public Usuario() {
    enderecos = new ArrayList<>();
  }

  public Usuario(String nome) {
    this.nome = nome;
    enderecos = new ArrayList<>();
  }

  public long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public List<Endereco> getEnderecos() {
    return enderecos;
  }

  public void add(Endereco e) {
    this.enderecos.add(e);
  }
}
