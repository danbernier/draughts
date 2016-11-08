package draughts;

import java.util.Random;
import processing.core.PApplet;

public class Maybe implements Draught {
  float p;
  Draught dc;
  private Random random = new Random();

  public Maybe(float p, Draught dc) {
    this.p = p;
    this.dc = dc;
  }

  public void draw(PApplet sketch) {
    if (random.nextFloat() < p) {
      dc.draw(sketch);
    }
  }
}
