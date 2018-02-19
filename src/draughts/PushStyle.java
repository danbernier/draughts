package draughts;

import processing.core.PApplet;

/*cheat
 * Push a new style onto the style stack, draw the draughts, then pop the
 * style stack.
 */

public class PushStyle implements Draught {
  private Draught[] draughts;
  public PushStyle(Draught... draughts) {
    this.draughts = draughts;
  }
  public void draw(PApplet sketch) {
    sketch.pushStyle();
    for (Draught c : draughts) {
      c.draw(sketch);
    }
    sketch.popStyle();
  }
}
