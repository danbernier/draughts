package draughts.style;

import draughts.Draught;
import signals.*;
import processing.core.PApplet;

/*cheat
 * Set the current fill color for the sketch. Accepts either a constant color,
 * or a `Signal<Integer>`. Accepts integer types because [Processing stores
 * colors as 32-bit
 * integers](https://processing.org/reference/color_datatype.html).
 */

public class Fill implements Draught {
  private Signal<Integer> colorSignal;
  public Fill(Signal<Integer> colorSignal) {
    this.colorSignal = colorSignal;
  }
  public Fill(int constantColor) {
    this(new Constant<Integer>(constantColor));
  }
  public void draw(PApplet sketch) {
    sketch.fill(colorSignal.current());
  }
}
