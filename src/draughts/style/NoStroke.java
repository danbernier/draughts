package draughts.style;

import draughts.Draught;
import signals.*;
import processing.core.PApplet;

/*cheat
 * Turns off stroking for shapes. Processing's `noStroke`.
 */

public class NoStroke implements Draught {
  public NoStroke() {
  }
  public void draw(PApplet sketch) {
    sketch.noStroke();
  }
}
