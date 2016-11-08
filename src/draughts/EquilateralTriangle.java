package draughts;

import signals.*;
import processing.core.PApplet;

public class EquilateralTriangle implements Draught {
  // height is sin(PI/3.0) * base width
  // Will be drawn w/ center at the middle of the baseline
  private Signal<Float> baseWidth;
  private float leftX;
  private float rightX;
  private float topY;

  public EquilateralTriangle(float baseWidth) {
    this(new Constant<Float>(baseWidth));
  }
  public EquilateralTriangle(Signal<Float> baseWidth) {
    this.baseWidth = baseWidth;
  }
  
  public void draw(PApplet p) {
    float bw = baseWidth.current();
    leftX = bw * -0.5f;
    rightX = bw * 0.5f;
    topY = (float)(Math.sin(Math.PI/3.0)) * -bw;
    
    p.triangle(leftX, 0, 0, topY, rightX, 0);
  }
}
