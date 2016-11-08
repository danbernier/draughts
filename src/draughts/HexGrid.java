package draughts;

import processing.core.PApplet;

public class HexGrid implements Draught {
  private Draught dc;
  private double gw; // overall grid width
  private double gh; // overall grid height
  private double s;  // size between 2 points

  public HexGrid(float gw, float gh, float s, Draught dc) {
    this.gw = (double)gw;
    this.gh = (double)gh;
    this.s = (double)s;
    this.dc = dc;
  }

  public void draw(PApplet sketch) {
    double h = Math.sin(Math.PI / 3.0) * s;  // vertical height between 2 rows
    double xOff = Math.cos(Math.PI / 3.0) * s;
    int cols = (int)Math.ceil(gw / s);
    int rows = (int)Math.ceil(gh / h);
    double y = 0;
    double x = 0;
    boolean offset;
    for (int i = 0; i < rows; i++) {
      x = 0;
      offset = i % 2 == 1;
      for (int j = 0; j < (offset ? cols - 1 : cols); j++) {
        sketch.pushMatrix();
        sketch.translate((float)((offset ? xOff : 0) + x), (float)y);
        dc.draw(sketch);
        sketch.popMatrix();
        x += s;
      }
      y += h;
    }
  }
}
