package br.usp.pcs.labes.gme.pcsgme.functional;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.usp.pcs.labes.gme.pcsgme.repository.GerenciadorDeMateriais;

// Para usar 8080
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
// Para não alterar o BD
@AutoConfigureTestDatabase
public class CadastroDeMaterialTestTest {
  private WebDriver driver;

  @Autowired
  private GerenciadorDeMateriais gerenciador;

  @BeforeEach
  public void setUp() {
    FirefoxOptions options = new FirefoxOptions();
    options.addArguments("-headless");
    driver = new FirefoxDriver(options);
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void cadastroDeMaterialTest() {
    driver.get("http://localhost:3000/");
    driver.findElement(By.id("cadastro")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("XYZWZ");
    driver.findElement(By.id("preco")).click();
    driver.findElement(By.id("preco")).sendKeys("56");
    driver.findElement(By.id("adicionar")).click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    // Até aparecer uma nova linha
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("MuiDataGrid-row")));
    // Outra opção mais simples (mas pode demorar mais ou menos que o necessário)
    // Thread.sleep(1000); // para dar tempo para o POST

    assertEquals(gerenciador.findByNome("XYZWZ").size(), 1);
  }
}
