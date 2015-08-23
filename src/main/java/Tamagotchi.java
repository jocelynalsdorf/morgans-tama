import java.lang.*;
import java.util.*;

public class Tamagotchi {
 public final int MAX_LEVEL = 10;

 private String mName;
 private int mFullness;
 private int mHappiness;
 private int mEnergy;
 private int mLevel;

   public Tamagotchi(String name) {
     mName = name;
     mFullness = 5;
     mHappiness = 5;
     mEnergy = 5;
     mLevel = 1;
   }

   public String getName() {
     return mName;
   }

   public int getFullness() {
     return mFullness;
   }

   public int getHappiness() {
     return mHappiness;
   }

   public int getEnergy() {
     return mEnergy;
   }

   public int getLevel() {
     return mLevel;
   }

   public boolean isDead() {
     if( mFullness <= 0 || mHappiness <= 0 || mEnergy <= 0) {
       return true;
     } else {
       return false;
     }
   }

  public String getStatus () {
   return String.format("level %d, fullness %d, happiness %d, energy %d", getLevel(), getFullness(), getHappiness(), getEnergy());
   }

  public void feed() {
      if (mFullness < 10) {
        mFullness++;
      }
      if (mHappiness <= 10) {
        mHappiness -= 1;
      }
      if (mEnergy <= 10) {
        mEnergy -= 2;
      }
   }

   public void play() {
     if (mFullness <= 10) {
       mFullness -= 1;
     }
     if (mHappiness < 10) {
       mHappiness++;
     }
     if (mEnergy <= 10) {
       mEnergy -= 2;
     }
  }

   public void rest() {
     if (mFullness <= 10) {
       mFullness -= 2;
     }
     if (mHappiness < 10) {
       mHappiness++;
     }
     if (mEnergy < 10) {
       mEnergy++;
     }
  }
}
