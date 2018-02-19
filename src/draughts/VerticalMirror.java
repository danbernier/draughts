package draughts;

import signals.*;
import processing.core.PApplet;

/*cheat
 * Draw some draughts, then flip vertically, and draw it again, upside-down.
 * The repeated image is flipped vertically.
 *
 * NB: if the image falls below the "horizon", it won't be cut-off. This may be
 * surprising, but hey, it can produce some neat effects.
 *
 * See also: HorizontalMirror.
 */

public class VerticalMirror implements Draught {
  private Draught[] draughts;

  public VerticalMirror(Draught... draughts) {
    this.draughts = draughts;
  }

  public void draw(PApplet sketch) {
    sketch.pushMatrix();
    for (Draught d : draughts) {
      d.draw(sketch);
    }
    sketch.popMatrix();

    sketch.pushMatrix();
    sketch.scale(1, -1);
    for (Draught d : draughts) {
      d.draw(sketch);
    }
    sketch.popMatrix();
  }
}
