package draughts.style;

import draughts.Draught;
import signals.*;
import processing.core.PApplet;

public class StrokeWeight implements Draught {
  Signal<Float> weightsSignal;
  public StrokeWeight(Signal<Float> weightsSignal) {
    this.weightsSignal = weightsSignal;
  }
  public StrokeWeight(float someWeight) {
    this(new Constant<Float>(someWeight));
  }
  public void draw(PApplet sketch) {
    sketch.strokeWeight(weightsSignal.current());
  }
}
