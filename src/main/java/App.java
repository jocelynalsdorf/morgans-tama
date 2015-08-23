import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {

  public static void main(String[] args) {
  staticFileLocation("/public");
  String layout = "templates/layout.vtl";
  Tamagotchi myTam;

  // get("/", (request, response) -> {
  //   HashMap<String, Object> model = new HashMap<String, Object>();
  //
  //   model.put("username", request.session().attribute("username"));
  //   model.put("tamagotchiname", request.session().attribute("tamagotchiname"));
  //
  //   model.put("template", "templates/index.vtl");
  //   return new ModelAndView (model, layout);
  // }, new VelocityTemplateEngine());


  get("/index", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();

    String name = request.queryParams("username");
    request.session().attribute("username", name);
    model.put("username", name);

    String tamName = request.queryParams("tamagotchiname");
    request.session().attribute("tamagotchiname", tamName);
    model.put("tamagotchiname", tamName);

    model.put("template", "templates/welcome.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  // get("/index", (request, response) -> {
  //   HashMap<String, Object> model = new HashMap<String, Object>();
  //   userName = request.queryParams("username");
  //   String tamName = request.queryParams("tamagotchiname");
  //   myTam = new Tamagotchi(tamName);
  //
  //   model.put("userName", userName);
  //   model.put("myTam", myTam);
  //   model.put("template", "templates/.vtl");
  //   return new ModelAndView(model, layout);
  // }, new VelocityTemplateEngine());

  post("/play", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();

    String name = request.queryParams("username");
    request.session().attribute("username", name);
    model.put("username", name);

    String tamName = request.queryParams("tamagotchiname");
    request.session().attribute("tamagotchiname", tamName);
    model.put("tamagotchiname", tamName);

    boolean playClicked =  Boolean.parseBoolean(request.queryParams("playClicked"));
    boolean feedClicked =  Boolean.parseBoolean(request.queryParams("feedClicked"));
    boolean restClicked =  Boolean.parseBoolean(request.queryParams("restClicked"));

      if(playClicked) {
        myTam.play();
      } else if (restClicked) {
        myTam.rest();
      } else if (feedClicked) {
        myTam.feed();
      } else {
        myTam.isDead();
      }


    model.put("playClicked", playClicked);
    model.put("restClicked", restClicked);
    model.put("feedClicked", feedClicked);

    model.put("template", "templates/index.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());
 }
}
