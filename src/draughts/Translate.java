package draughts;

import signals.*;
import processing.core.PApplet;
import processing.core.PVector;

/*cheat
 * Translate the coordinate system to the given position. Just like
 * Processing's `translate` command.
 */

public class Translate implements Draught {
  Signal<PVector> position;
  public Translate(float x, float y) {
    this(new Constant<PVector>(new PVector(x, y)));
  }
  public Translate(Signal<Float> x, Signal<Float> y) {
    this(new PVectorSignal(x, y));
  }
  public Translate(Signal<PVector> position) {
    this.position = position;
  }
  public void draw(PApplet sketch) {
    PVector pos = position.current();
    sketch.translate(pos.x, pos.y);
  }
}

