package signals;

import processing.core.PVector;

/*cheat
 * A Signal that ties two Signals together into a PVector.
 */

public class PVectorSignal implements Signal<PVector> {
  private Signal<Float> x;
  private Signal<Float> y;

  public PVectorSignal(Signal<Float> x, Signal<Float> y) {
    this.x = x;
    this.y = y;
  }

  public PVector current() {
    return new PVector(x.current(), y.current());
  }
}
