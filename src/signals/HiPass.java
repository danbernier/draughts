package signals;

public class HiPass extends Filter<Float> {
  private float threshold;
  public HiPass(float threshold, Signal<Float> src) {
    super(src);
    this.threshold = threshold;
  }
  public Float filter(Float value) {
    return Math.max(threshold, value);
  }
}
