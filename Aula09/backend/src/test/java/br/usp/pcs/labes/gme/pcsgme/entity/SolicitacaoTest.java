package br.usp.pcs.labes.gme.pcsgme.entity;

import static org.junit.jupiter.api.Assertions.
  assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import br.usp.pcs.labes.gme.pcsgme.entity.Solicitacao.Status;

import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
public class SolicitacaoTest {
  private static List<Material> materiais;
  
  @Mock
  private Almoxarifado a;

  @BeforeAll
  static void inicializa() {
    materiais = new ArrayList<>();
    materiais.add(new Material(123, "caneta azul", 5.5));
    materiais.add(new Material(234, "lapis", 7));
  }

  @Test
  void testConfirma() {
    Solicitacao s = new Solicitacao(a);
    s.confirma();

    verify(a, times(1)).avisa(s);
    assertEquals(s.status, Status.DENTRO_DA_QUOTA);
  }

  @Test
  void solicitacaoConfirmadaDuasVezes() {
    Solicitacao s = new Solicitacao(a);
    s.confirma();
    assertThrows(IllegalStateException.class, () -> s.confirma());
  }

  @Test
  void testGetValor() {
    Solicitacao s = new Solicitacao(a);
    s.adiciona(materiais.get(0), 1);
    s.adiciona(materiais.get(1), 2);
    assertEquals(s.getValor(), 19.5);
  }
}
