package draughts.style;

import draughts.Draught;
import signals.*;
import processing.core.PApplet;

/*cheat
 * Set the current stroke color for the sketch. Accepts either a constant
 * color, or a `Signal<Integer>`. Accepts integer types because [Processing
 * stores colors as 32-bit
 * integers](https://processing.org/reference/color_datatype.html).
 */

public class Stroke implements Draught {
  private Signal<Integer> colorSignal;
  public Stroke(Signal<Integer> colorSignal) {
    this.colorSignal = colorSignal;
  }
  public Stroke(int constantColor) {
    this(new Constant<Integer>(constantColor));
  }
  public void draw(PApplet sketch) {
    sketch.stroke(colorSignal.current());
  }
}
