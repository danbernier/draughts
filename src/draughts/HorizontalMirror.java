package draughts;

import signals.*;
import processing.core.PApplet;

/*cheat
 * Draw some draughts, then flip horizontally, and draw it again, reversed
 * left-to-right. The repeated image is flipped horizontally.
 *
 * NB: if the image moves beyond the reflection point, it won't be cut-off.
 * This may be surprising, but hey, it can produce some neat effects.
 *
 * See also: VerticalMirror.
 */

public class HorizontalMirror implements Draught {
  private Draught[] draughts;

  public HorizontalMirror(Draught... draughts) {
    this.draughts = draughts;
  }

  public void draw(PApplet sketch) {
    sketch.pushMatrix();
    for (Draught d : draughts) {
      d.draw(sketch);
    }
    sketch.popMatrix();

    sketch.pushMatrix();
    sketch.scale(-1, 1);
    for (Draught d : draughts) {
      d.draw(sketch);
    }
    sketch.popMatrix();
  }
}
