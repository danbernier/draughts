package draughts;

import processing.core.PApplet;

/*cheat
 * A combination of PushMatrix and PushStyle. Hat-tip to p5js.
 *
 * Push a new matrix onto the matrix stack and a new style onto the style
 * stack, draw the draughts, then pop the matrix stack and style stack.
 */

public class Push implements Draught {
  private Draught[] draughts;
  public Push(Draught... draughts) {
    this.draughts = draughts;
  }
  public void draw(PApplet sketch) {
    sketch.pushMatrix();
    sketch.pushStyle();
    for (Draught c : draughts) {
      c.draw(sketch);
    }
    sketch.popStyle();
    sketch.popMatrix();
  }
}
