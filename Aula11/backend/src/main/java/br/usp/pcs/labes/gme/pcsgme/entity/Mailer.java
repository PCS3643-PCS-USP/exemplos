package br.usp.pcs.labes.gme.pcsgme.entity;

public class Mailer {
  public static void envia(Solicitacao s, String email) {
    System.out.println("Enviando: " + s.toString() + " para " + email);
  }
}
