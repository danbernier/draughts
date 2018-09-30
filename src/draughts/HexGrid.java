package draughts;

import processing.core.PApplet;

/*cheat
 * Draw a Draught repeatedly on a hexagonal grid. You control the width and
 * height of the grid, and the size of each hexagon (picture it as the distance
 * between the center of two neighboring hexagons).
 */

public class HexGrid implements Draught {
  private Draught[] draughts;
  private double gridWidth;
  private double gridHeight;
  private double cellSize;  // size between 2 points

  public HexGrid(float gridWidth, float gridHeight, float cellSize, Draught... draughts) {
    this.gridWidth = (double)gridWidth;
    this.gridHeight = (double)gridHeight;
    this.cellSize = (double)cellSize;
    this.draughts = draughts;
  }

  public void draw(PApplet sketch) {
    double h = Math.sin(Math.PI / 3.0) * cellSize;  // vertical height between 2 rows
    double xOff = Math.cos(Math.PI / 3.0) * cellSize;
    int cols = (int)Math.ceil(gridWidth / cellSize);
    int rows = (int)Math.ceil(gridHeight / h);
    double y = 0;
    double x = 0;
    boolean offset;
    for (int i = 0; i < rows; i++) {
      x = 0;
      offset = i % 2 == 1;
      for (int j = 0; j < (offset ? cols - 1 : cols); j++) {
        sketch.pushMatrix();
        sketch.translate((float)((offset ? xOff : 0) + x), (float)y);
        for (Draught draught : draughts) {
          draught.draw(sketch);
        }
        sketch.popMatrix();
        x += cellSize;
      }
      y += h;
    }
  }
}
