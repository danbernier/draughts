package signals;

/*cheat
 * Basic [Low-pass filter](https://en.wikipedia.org/wiki/Low-pass_filter).
 * Emits a value if it's under the `threshold`; if it's over the threshold,
 * returns the threshold value.
 *
 * See HiPass.
 */

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
