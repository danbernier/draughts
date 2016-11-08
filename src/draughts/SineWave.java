package draughts;

import signals.*;
import processing.core.PApplet;

public class SineWave implements Draught {
  private Draught drawCommand;
  private float amp = 1;
  private float step = 10;
  private Signal<Float> phase = new signals.Constant<Float>(0.0f);
  private int n;

  public SineWave(int n, float amp, float phase, float w, Draught dc) {
    this(n, dc);
    amp(amp);
    phase(phase);
    width(w);
  }
  public SineWave(int n, Draught command) {
    this.n = n;
    this.drawCommand = command;
  }
  public SineWave amp(float amp) {
    this.amp = amp;
    return this;
  }
  public SineWave step(float step) {
    this.step = step;
    return this;
  }
  public SineWave width(float width) {
    return step(width / n);
  }
  public SineWave phase(Signal<Float> ph) {
    this.phase = ph;
    return this;
  }
  public SineWave phase(float v) {
    return phase(new Constant<Float>(v));
  }
  public void draw(PApplet sketch) {
    for (int i = 0; i < n; i++) {
      sketch.pushMatrix();
      float theta = this.phase.current() + sketch.map(i, 0, n-1, 0, (float)(2*Math.PI));
      float y = (float)Math.sin(theta) * amp;
      sketch.translate(step * i, y);
      drawCommand.draw(sketch);
      sketch.popMatrix();
    }
  }
}
