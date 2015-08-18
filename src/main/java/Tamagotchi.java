import java.lang.*;
import java.util.*;

public class Tamagotchi {
 public final int MAX_FULLNESS = 10;
 public final int MAX_HAPPINESS = 10;
 public final int MAX_ENERGY = 10;

 int mFullness = 5;
 int mHappiness = 5;
 int mEnergy = 5;

 public boolean isDead() {
   if( mFullness <= 0 || mHappiness <= 0 || mEnergy <= 0) {
     return true;
   } else {
     return false;
   }
 }

public String feed() {
  if(!isDead()) {
    mFullness = MAX_FULLNESS;
    mHappiness += 1;
    mEnergy -= 2;
    String output = String.format("Your Tamagotchi levels are: fullness %d, happiness %d, energy %d", mFullness, mHappiness, mEnergy);
    return output;
  } else {
  return "Oops, looks like your tamagotchi died....Maybe you should get a plant.";
  }
 }

 public String play() {
   if(!isDead()) {
     mFullness -= 2;
     mHappiness = MAX_HAPPINESS;
     mEnergy -= 2;
     String output = String.format("Your Tamagotchi levels are: fullness %d, happiness %d, energy %d", mFullness, mHappiness, mEnergy);
     return output;
   } else {
   return "Oops, looks like your tamagotchi died....Maybe you should get a plant.";
 }
 }

 public String rest() {
   if(!isDead()) {
     mFullness -=1;
     mHappiness +=2;
     mEnergy = MAX_ENERGY;
     String output = String.format("Your Tamagotchi levels are: fullness %d, happiness %d, energy %d", mFullness, mHappiness, mEnergy);
     return output;
   } else {
   return "Oops, looks like your tamagotchi died....Maybe you should get a plant.";
    }
  }
}
