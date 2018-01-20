package signals;

/*cheat
 * Basic [High-pass filter](https://en.wikipedia.org/wiki/High-pass_filter).
 * Emits a value if it's over the `threshold`; if it's under the threshold,
 * returns the threshold value.
 *
 * See LoPass.
 */

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
