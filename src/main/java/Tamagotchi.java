import java.lang.*;
import java.util.*;

public class Tamagotchi {
 public final int MAX_FULLNESS = 10;
 public final int MAX_HAPPINESS = 10;
 public final int MAX_ENERGY = 10;

 private String mName;
 private int mFullness;
 private int mHappiness;
 private int mEnergy;

 public Tamagotchi(String name) {
   mName = name;
   mFullness = 5;
   mHappiness = 5;
   mEnergy = 5;

 }

   public String getName() {
     return mName;
   }

   public int fullness() {
     return mFullness;
   }

   public int happiness() {
     return mHappiness;
   }

   public int energy() {
     return mEnergy;
   }

   public boolean isDead() {
     if( mFullness <= 0 || mHappiness <= 0 || mEnergy <= 0) {
       return true;
     } else {
       return false;
     }
   }

  public String myTamStatus () {
   return String.format("%s levels are: fullness %d, happiness %d, energy %d", getName(), fullness(), happiness(), energy());
   }

  public void feed() {
      mFullness = MAX_FULLNESS;
      mHappiness += 1;
      mEnergy -= 2;
   }

   public void play() {
       mFullness -= 2;
       mHappiness = MAX_HAPPINESS;
       mEnergy -= 2;
   }

   public void rest() {
       mFullness -=1;
       mHappiness +=2;
       mEnergy = MAX_ENERGY;
  }
 }
