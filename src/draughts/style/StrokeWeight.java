package draughts.style;

import draughts.Draught;
import signals.*;
import processing.core.PApplet;

/*cheat
 * Set the current stroke-weight for the sketch. Accepts either a constant
 * weight, or a `Signal<Float>` to vary the weight.
 */

public class StrokeWeight implements Draught {
  private Signal<Float> weightSignal;
  public StrokeWeight(Signal<Float> weightSignal) {
    this.weightSignal = weightSignal;
  }
  public StrokeWeight(float constantWeight) {
    this(new Constant<Float>(constantWeight));
  }
  public void draw(PApplet sketch) {
    sketch.strokeWeight(weightSignal.current());
  }
}
