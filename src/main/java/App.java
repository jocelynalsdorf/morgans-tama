import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {

  public static void main(String[] args) {
  staticFileLocation("/public");
  String layout = "templates/layout.vtl";

  get("/", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();

    String userName = request.queryParams("username");
    request.session().attribute("username", userName);
    model.put("username", userName);

    String tamName = request.queryParams("tamagotchiname");
    request.session().attribute("tamagotchiname", tamName);
    model.put("tamagotchiname", tamName);

    model.put("template", "templates/index.vtl");
    return new ModelAndView (model, layout);
  }, new VelocityTemplateEngine());

  // get("/success", (request, response) -> {
  //   HashMap<String, Object> model = new HashMap<String, Object>();
  //   userName = request.queryParams("username");
  //   String tamName = request.queryParams("tamagotchiname");
  //   myTam = new Tamagotchi(tamName);
  //
  //   model.put("userName", userName);
  //   model.put("myTam", myTam);
  //   model.put("template", "templates/success.vtl");
  //   return new ModelAndView(model, layout);
  // }, new VelocityTemplateEngine());

  post("/success", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();

    boolean playClicked =  Boolean.parseBoolean(request.queryParams("playClicked"));
    boolean feedClicked =  Boolean.parseBoolean(request.queryParams("feedClicked"));
    boolean restClicked =  Boolean.parseBoolean(request.queryParams("restClicked"));
    String error = "Sorry, try again!";

      if(playClicked) {
        tamName.play();
      } else if (restClicked) {
        tamName.rest();
      } else if (feedClicked) {
        tamName.feed();
      } else {
        tamName.isDead();
      }


    model.put("playClicked", playClicked);
    model.put("restClicked", restClicked);
    model.put("feedClicked", feedClicked);
    model.put("userName", userName);
    model.put("tamName", tamName);

    model.put("template", "templates/success.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());
 }
}
