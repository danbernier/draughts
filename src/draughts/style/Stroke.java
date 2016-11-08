package draughts.style;

import draughts.Draught;
import signals.*;
import processing.core.PApplet;

public class Stroke implements Draught {
  Signal<Integer> colorSignal;
  public Stroke(Signal<Integer> colorSignal) {
    this.colorSignal = colorSignal;
  }
  public Stroke(int someColor) {
    this(new Constant<Integer>(someColor));
  }
  public void draw(PApplet sketch) {
    sketch.stroke(colorSignal.current());
  }
}
