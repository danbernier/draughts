package signals;

public class LoPass extends Filter<Float> {
  private float threshold;
  public LoPass(float threshold, Signal<Float> src) {
    super(src);
    this.threshold = threshold;
  }
  public Float filter(Float val) {
    return Math.min(threshold, val);
  }
}
