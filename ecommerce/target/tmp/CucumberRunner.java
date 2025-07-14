
import io.cucumber.core.cli.Main;

public class CucumberRunner {
  public static void main(String[] args) {
    System.out.println("Cucumber feature: src/test/resources/features/Login.feature:4");
    String[] cucumberArgs = new String[] {
      "src/test/resources/features/Login.feature:4",
      "--glue", "stepdefinations",
      "--plugin", "pretty"
    };
    Main.main(cucumberArgs);
  }
}