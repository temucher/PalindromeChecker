import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PalindromeChecker extends PApplet {

public void setup()
{
  String lines[] = loadStrings("palindromes.txt");
  println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      println(lines[i] + " IS a palidrome.");
    }
    else
    {
      println(lines[i] + " is NOT a palidrome.");
    }
  }
}
public boolean palindrome(String word)
{//bug: ALL words return true 
  String newWord = "";
  for(int z = 0; z<=word.length()-1;z++) {
    if(word.charAt(z) != ' ') {
      newWord = newWord + word.charAt(z);
    }
  }
  String finalWord = "";
  for(int y = 0; y<=newWord.length()-1;y++) {
    if(Character.isLetter(newWord.charAt(y))==true) {
      finalWord = finalWord + newWord.charAt(y);
    }
  }
  finalWord = finalWord.toLowerCase();
  int i = 0;
  while(i<finalWord.length()) {
    if(finalWord.charAt(i)==finalWord.charAt(finalWord.length()-1-i)) {
      i++;
    }
    else {return false;}
  }
  return true;
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PalindromeChecker" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
