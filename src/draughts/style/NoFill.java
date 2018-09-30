package draughts.style;

import draughts.Draught;
import signals.*;
import processing.core.PApplet;

/*cheat
 * Turns off filling for shapes. Processing's `noFill`.
 */

public class NoFill implements Draught {
  public NoFill() {
  }
  public void draw(PApplet sketch) {
    sketch.noFill();
  }
}
