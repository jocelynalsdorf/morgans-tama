import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.ArrayList;
import java.lang.*;
import java.util.*;

import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Let's Play");
  }

  @Test
  public void returnsUsernameAndTamagotchiName_true() {
    goTo("http://localhost:4567/");
    fill("#username").with("morgan");
    fill("#tamagotchiname").with("cutiepie");
    submit(".btn");
    assertThat(pageSource()).contains("Choose one!");
  }
  }
