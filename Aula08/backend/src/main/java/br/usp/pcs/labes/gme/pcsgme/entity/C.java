package br.usp.pcs.labes.gme.pcsgme.entity;

import jakarta.persistence.Entity;

@Entity
public class C extends A {
  private String c;

  public C() {
  }

  public String getC() {
    return c;
  }

  public void setC(String c) {
    this.c = c;
  }
  
}
