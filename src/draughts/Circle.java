package draughts;

import signals.*;
import processing.core.PApplet;

/*cheat
 * Draw a Draught around the edge of a circle, a given number of times. Radius
 * defaults to 1, Phase defaults to 0.
 */

public class Circle implements Draught {
  private Draught drawCommand;
  private Signal<Float> radius = new Constant<Float>(1.0f);
  private Signal<Float> phase = new Constant<Float>(0.0f);
  private int n;

  public Circle(int times, float radius, float phase, Draught draught) {
    this(times, draught);
    radius(radius);
    phase(phase);
  }
  public Circle(int times, Draught draught) {
    this.n = times;
    this.drawCommand = draught;
  }
  public Circle radius(Signal<Float> r) {
    this.radius = r;
    return this;
  }
  public Circle radius(float r) {
    return radius(new Constant<Float>(r));
  }
  public Circle phase(Signal<Float> s) {
    this.phase = s;
    return this;
  }
  public Circle phase(float ph) {
    return phase(new Constant<Float>(ph));
  }
  public void draw(PApplet sketch) {
    sketch.pushMatrix();
    sketch.rotate(this.phase.current());
    float rad = radius.current();
    double theta = Math.PI * 2 / n;
    for (int i = 0; i < n; i++) {
      sketch.rotate((float)theta);
      sketch.pushMatrix();
      sketch.translate(rad, 0);
      drawCommand.draw(sketch);
      sketch.popMatrix();
    }
    sketch.popMatrix();
  }
}
