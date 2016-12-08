package signals;

public class HiPass implements Signal<Float> {
  private Signal<Float> src;
  private float threshold;
  public HiPass(float threshold, Signal<Float> src) {
    this.src = src;
    this.threshold = threshold;
  }
  public Float current() {
    return Math.max(threshold, src.current());
  }
}
