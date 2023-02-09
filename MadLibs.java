public class MadLibs {
  /*This program generates a mad libbed story.
  Author: Laura
  Date:2/19/2049
  */
  public static void main(String[] args) {
	  String name1 = "Tim";
	  String adjective1 = "good";
	  String adjective2 = "nice"; 
	  String adjective3 = "nervous";
	  String verb1 = "wave";
	  String noun1 = "customer";
	  String noun2 = "______";
	  String noun3 = "solgan";
	  String noun4 = "salesclerk";
	  String noun5 = "lack";
	  String noun6 = "______";
	  String name2 = "Jim";
	  int number = 2250;
	  String place1 = "park";
	  //The template for the story.
	  String story = "This morning" + name1 + "woke up feeling" +adjective1 +
	  ".'It is " + "going to be a " + adjective2 + " day!'Outside, a bunch of " 
	  + noun1 +	"s were protesting to keep " + noun2 + "in stores.They began to "
	  + "" + verb1 + " to the rhythm of the " + noun3 + ",which made all the " +
	  noun4 +"s very "+ adjective3 + ". Concerned, " + name1 + "texted " + name2 
	  + ", who flew " + name1 + "to " + place1 + " and dropped " + name1 +"in a puddle"
	  		+ " of frozen " + noun5 + "."+ name1 + "woke up in the year " +number + 
	  		",in a world where " +noun6 +"s ruled the world.";
	  System.out.println(story);
  }
}
  