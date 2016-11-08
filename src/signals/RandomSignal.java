package signals;

import java.util.Random;

public class RandomSignal implements Signal<Float> {
  private float min;
  private float max;
  private Random random = new Random();

  public RandomSignal(float max) {
    this(0, max);
  }
  public RandomSignal(float min, float max) {
    this.min = min;
    this.max = max;
  }
  public Float current() {
    return min + (random.nextFloat() * (max-min));
  }
}
