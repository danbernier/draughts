package draughts;

import processing.core.PApplet;

public class Rotate implements Draught {
  float theta;
  public Rotate(float theta) {
    this.theta = theta;
  }
  public void draw(PApplet sketch) {
    sketch.rotate(theta);
  }
}
