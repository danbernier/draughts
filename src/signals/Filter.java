package signals;

/*
 * Interesting idea. Could you have a plug-filter? a filter
 * than accepts any Signal, and a FilterPlug, and acts as
 * a Signal, that passes its Signal value through the FilterPlug?
 * What would be the benefits?
 * - the Plug would be (should be) swappable. 
 *   - (Is that valuable? maybe?)
 * - It would be easier to make a FilterPlug. Ex: Amp:
 *     pubic class AmpPlug implements FilterPlug<Float> {
 *       private float amount;
 *       public Amp(float amount) { this.amount = amount; }
 *       public Float filter(Float value) {
 *         return amount + value;
 *       }
 *     }
 * - OTOH, using them would be a PITA:
 *   Signal s = new FilterPlugSignal(src, new AmpPlug(4));
 *   ...ok, maybe not that bad.
 *   ...But you'd still have to make all these Plugs.
 *   How about a custom one?
 *   new FilterPlugSignal(src, new FilterPlug<Float>() {
 *     public Float filter(float value) {
 *       return value + 4;
 *     }
 *   });
 *   That ^ is probably as nice as it'll get in Java.
 */

public abstract class Filter<T> implements Signal<T> {
  private Signal<T> src;
  public Filter(Signal<T> src) {
    this.src = src;
  }
  public abstract T filter(T value);
  public T current() {
    return filter(src.current());
  }
}
