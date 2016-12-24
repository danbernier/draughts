package draughts;

import processing.core.PApplet;

/*cheat
 * Push a new matrix onto the stack, draw the draughts, then pop the matrix
 * stack.
 */

public class PushMatrix implements Draught {
  private Draught[] draughts;
  public PushMatrix(Draught... draughts) {
    this.draughts = draughts;
  }
  public void draw(PApplet sketch) {
    sketch.pushMatrix();
    for (Draught c : draughts) {
      c.draw(sketch);
    }
    sketch.popMatrix();
  }
}
