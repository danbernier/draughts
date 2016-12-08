package draughts;

import signals.*;
import processing.core.PApplet;

public class DrawRect implements Draught {
  private Signal<Float> w;
  private Signal<Float> h;
  public DrawRect(float w, float h) {
    this(new Constant<Float>(w), new Constant<Float>(h));
  }
  public DrawRect(Signal<Float> w, Signal<Float> h) {
    this.w = w;
    this.h = h;
  }
  public void draw(PApplet sketch) {
    sketch.rect(0, 0, w.current(), h.current());
  }
}
