package draughts.style;

import draughts.Draught;
import signals.*;
import processing.core.PApplet;

public class Fill implements Draught {
  Signal<Integer> colorSignal;
  public Fill(Signal<Integer> colorSignal) {
    this.colorSignal = colorSignal;
  }
  public Fill(int someColor) {
    this(new Constant<Integer>(someColor));
  }
  public void draw(PApplet sketch) {
    sketch.fill(colorSignal.current());
  }
}
