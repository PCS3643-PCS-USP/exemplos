package br.usp.pcs.labes.gme.pcsgme.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class A {
  @Id
  @GeneratedValue
  long id;
  private String a;

  public A() {
  }

  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getA() {
    return a;
  }
  public void setA(String a) {
    this.a = a;
  }
}
