import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {

  public static Tamagotchi myTam;
  public static String username = "";

  public static void main(String[] args) {
  staticFileLocation("/public");
  String layout = "templates/layout.vtl";

  get("/", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/index.vtl");
    return new ModelAndView (model, layout);
  }, new VelocityTemplateEngine());


  get("/play", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    username = request.queryParams("username");
    String tamName = request.queryParams("tamagotchiname");

    //added class name here and then stored it in a session var and then then the model
    Tamagotchi myTam = new Tamagotchi(tamName);
    request.session().attribute("myTam", myTam);
    model.put("username", username);
    model.put("myTam", request.session().attribute("myTam"));
    model.put("template", "templates/play.vtl");

    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/play-game", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();

    boolean playClicked =  Boolean.parseBoolean(request.queryParams("playClicked"));
    boolean feedClicked =  Boolean.parseBoolean(request.queryParams("feedClicked"));
    boolean restClicked =  Boolean.parseBoolean(request.queryParams("restClicked"));


//added creation of instance of class here--need something to call the methods on!
    Tamagotchi myTam = request.session().attribute("myTam");
      if(playClicked) {
        myTam.play();
      } else if (restClicked) {
        myTam.rest();
      } else if (feedClicked) {
        myTam.feed();
      } else {
        myTam.isNotDead();
      }

    

   //stored the instance of the class here so it can keep track of the changes
    model.put("myTam", request.session().attribute("myTam"));

    //commented these methods out because you have the object now to call methods on so not needed
    //model.put("playClicked", playClicked);
    //model.put("restClicked", restClicked);
    //model.put("feedClicked", feedClicked);
    model.put("username", username);
    model.put("template", "templates/play.vtl");

    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());
 }
}
