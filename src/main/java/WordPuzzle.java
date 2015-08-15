
import java.util.Map;
import java.util.HashMap;
import java.io.Console;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class WordPuzzle {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/WordPuzzle", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/WordPuzzle.vtl");

      // Create a string and store userInput
      String s = request.queryParams("userInput");

      // put replaced string to webpage
      model.put("WordPuzzle", replacedAEIOU(s));

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
  
  // Create a method to replace the vowels in a string
  public static String replacedAEIOU(String s){ 
    String newString = ""; 
    String vowels = "aeiouAEIOU";
  	for (String letter : s.split("")) {
  	  if (vowels.contains(letter)) {
  		letter = "-";
  	  }
  	  newString += letter;
  	}
    return newString;
  }
  
  // Create a method to replace the vowels in a string
  // public static String replacedAEIOU(String s){
  //   s = s.replace('a', '-');
  //   s = s.replace('A', '-');
  //   s = s.replace('e', '-');
  //   s = s.replace('E', '-');
  //   s = s.replace('i', '-');
  //   s = s.replace('I', '-');
  //   s = s.replace('o', '-');
  //   s = s.replace('O', '-');
  //   s = s.replace('u', '-');
  //   s = s.replace('U', '-');
  //   return s;
  // }

}
