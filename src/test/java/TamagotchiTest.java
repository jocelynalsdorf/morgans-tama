import org.junit.*;
import static org.junit.Assert.*;

public class TamagotchiTest {

@Test
public void Tamagotchi_instantiatesCorrectly_true() {
  Tamagotchi myTamagotchi = new Tamagotchi();
  assertEquals(true, myTamagotchi instanceof Tamagotchi);
}

// @Test
// public void Tamagotchi_isDead_false() {
//   Tamagotchi testIsDead = new Tamagotchi();
//   assertEquals(false, testIsDead.isDead());
// }
//
// @Test
// public void Tamagotchi_getCorrectLevel_true() {
//   Tamagotchi testFullness = new Tamagotchi();
//   assertEquals(5, testFullness.fullness());
// }

// @Test
// public void Tamagotchi_playLevelMAX_true() {
//   Tamagotchi testPlay = new Tamagotchi("ml");
//   assertEquals("Your Tamagotchi levels are: fullness 3, happiness 10, energy 3", testPlay.play());
// }
//
// @Test
// public void Tamagotchi_restLevelMAX_true() {
//   Tamagotchi testRest = new Tamagotchi("ml");
//   assertEquals("Your Tamagotchi levels are: fullness 4, happiness 7, energy 10", testRest.rest());
// }
//
// @Test
// public void Tamagotchi_isDead_true() {
//   Tamagotchi testIsDead = new Tamagotchi("ml");
//   assertEquals("Oops, looks like your tamagotchi died....Maybe you should get a plant.", testIsDead.play());
// }
}
