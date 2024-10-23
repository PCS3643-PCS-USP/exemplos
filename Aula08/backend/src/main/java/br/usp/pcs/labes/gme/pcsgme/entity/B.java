package br.usp.pcs.labes.gme.pcsgme.entity;

import jakarta.persistence.Entity;

@Entity
public class B extends A {
  private String b;

  public B() {
  }

  public String getB() {
    return b;
  }

  public void setB(String b) {
    this.b = b;
  }

}
