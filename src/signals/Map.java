package signals;

/*cheat
 * Map (by linear interpolation) a value from one range to another. This is
 * stolen shamelessly, with love, from Processing's incredibly versatile `map`
 * function.
 */

public class Map extends Filter<Float> {
  private float srcMin;
  private float srcMax;
  private float outMin;
  private float outMax;

  public Map(Signal src, float srcMin, float srcMax, float outMin, float outMax) {
    super(src);
    this.srcMin = srcMin;
    this.srcMax = srcMax;
    this.outMin = outMin;
    this.outMax = outMax;
  }

  public Float filter(Float value) {
    return outMin + (outMax - outMin) * ((value - srcMin) / (srcMax - srcMin));
  }
}
