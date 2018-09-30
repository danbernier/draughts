package draughts;

import signals.*;
import processing.core.PApplet;
import processing.core.PVector;

/*cheat
 * Translate the coordinate system to the given position. Just like
 * Processing's `translate` command.
 */

public class Translate implements Draught {
  // FML, why isn't PVectorSignal coming through?
  // TODO find & fix this.
  //Signal<PVector> position;
  Signal<Float> x;
  Signal<Float> y;

  public Translate(float x, float y) {
    //this(new Constant<PVector>(new PVector(x, y)));
    this(new Constant<Float>(x), new Constant<Float>(y));
  }
  //public Translate(Signal<Float> x, Signal<Float> y) {
  //  this(new PVectorSignal(x, y));
  //}
  //public Translate(Signal<PVector> position) {
  //  this.position = position;
  //}
  public Translate(Signal<Float> x, Signal<Float> y) {
    this.x = x;
    this.y = y;
  }
  public void draw(PApplet sketch) {
    //PVector pos = position.current();
    sketch.translate(x.current(), y.current());
  }
}

