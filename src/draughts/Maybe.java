package draughts;

import java.util.Random;
import processing.core.PApplet;

/*cheat
 * Draw a Draught, but only some percentage of the time.
 */

public class Maybe implements Draught {
  float probability;
  Draught draught;
  private Random random = new Random();

  public Maybe(float probability, Draught draught) {
    this.probability = probability;
    this.draught = draught;
  }

  public void draw(PApplet sketch) {
    if (random.nextFloat() < probability) {
      draught.draw(sketch);
    }
  }
}
