package signals;

public class LoPass implements Signal<Float> {
  private Signal<Float> src;
  private float threshold;
  public LoPass(float threshold, Signal<Float> src) {
    this.src = src;
    this.threshold = threshold;
  }
  public Float current() {
    return Math.min(threshold, src.current());
  }
}
