A cheatsheet.
[Get all the details.](https://github.com/danbernier/draughts)

[draughts](draughts) | [signals](signals)

# Package: signals


## Amp


<p>Amplify a signal by some <code>amount</code>.</p>



* `new Amp(float amount, Signal<Float> src)`


## Color


<p>A signal of Colors, made by combining three Signals - one for red, one for
green, one for blue - into a Processing color.</p>

<p>The signals don’t have to actually be RGB; if the Processing sketch is in
HSB, that’s how to think of these. The signals should return values in the
range that’s acceptable to Processing’s <code>color</code> function. If you’ve set
<code>colorMode(HSB, 360, 100, 100)</code>, then the first signal should return 0..360,
and the others should return 0..100.</p>



* `new Color(PApplet sketch, Signal<Float> r, Signal<Float> g, Signal<Float> b)`


## Constant


<p>Always return a constant value. Mostly useful for places where a method
expects a Signal, and you really only want to give it a number.</p>



* `new Constant(T val)`


## HiPass





* `new HiPass(float threshold, Signal<Float> src)`


## LoPass





* `new LoPass(float threshold, Signal<Float> src)`


## Mouse





* `new Mouse(PApplet sketch)`


## MouseX





* `new MouseX(PApplet sketch)`


## MouseY





* `new MouseY(PApplet sketch)`


## Osc





* `new Osc(float period)`


## PVectorSignal





* `new PVectorSignal(Signal<Float> x, Signal<Float> y)`


## RandomSignal





* `new RandomSignal(float max)`

* `new RandomSignal(float min, float max)`


## Ring





* `new Ring(T... items)`


## Shift





* `new Shift(float amount, Signal<Float> src)`


## SignalLock





* `new SignalLock(Signal<T> src)`


## Speed





* `new Speed(float ratePerSecond)`


## Threshold





* `new Threshold(Osc osc)`



---------------

Generated 2018-01-20 17:32:46 -05:00
