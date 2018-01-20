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


<p>Basic <a href="https://en.wikipedia.org/wiki/High-pass_filter">High-pass filter</a>.
Emits a value if it’s over the <code>threshold</code>; if it’s under the threshold,
returns the threshold value.</p>

<p>See LoPass.</p>



* `new HiPass(float threshold, Signal<Float> src)`


## LoPass


<p>Basic <a href="https://en.wikipedia.org/wiki/Low-pass_filter">Low-pass filter</a>.
Emits a value if it’s under the <code>threshold</code>; if it’s over the threshold,
returns the threshold value.</p>

<p>See HiPass.</p>



* `new LoPass(float threshold, Signal<Float> src)`


## Mouse


<p>A signal that emits PVectors pointing to the mouse’s current position.
Based on Processing’s <code>mouseX</code> and <code>mouseY</code> values.</p>

<p>See MouseX and MouseY.</p>



* `new Mouse(PApplet sketch)`


## MouseX


<p>A signal that emits float values pointing to the mouse’s current horizontal
position.  Based on Processing’s <code>mouseX</code> value.</p>

<p>See Mouse and MouseY.</p>



* `new MouseX(PApplet sketch)`


## MouseY


<p>A signal that emits float values pointing to the mouse’s current vertical
position.  Based on Processing’s <code>mouseY</code> value.</p>

<p>See Mouse and MouseX.</p>



* `new MouseY(PApplet sketch)`


## Osc


<p>An oscillator signal.</p>

<p>It’s constructed with a <code>period</code>, and supports a <a href="https://stackoverflow.com/questions/17937755/what-is-the-difference-between-a-fluent-interface-and-the-builder-pattern">fluent builder
interface</a>
for specifying amplitude, phase, and offset (basically, translating the
signal up or down - it’s the last thing added to the signal value).</p>



* `new Osc(float period)`


## PVectorSignal


<p>A Signal that ties two Signals together into a PVector.</p>



* `new PVectorSignal(Signal<Float> x, Signal<Float> y)`


## RandomSignal


<p>Returns a stream of random values between 0 and 1. Implemented via Java’s
<code>Random#nextFloat</code>.</p>



* `new RandomSignal(float max)`

* `new RandomSignal(float min, float max)`


## Ring


<p>AKA Cycle. The term “Ring” comes from SonicPi. You give it items, and it
cycles through them.</p>

<p><code>new Ring(1, 2)</code> would emit: 1, 2, 1, 2, 1, 2…
<code>new Ring(7, 8, 9)</code> would emit: 7, 8, 9, 7, 8, 9…</p>



* `new Ring(T... items)`


## Shift


<p>Shift a signal, additively, by the given <code>amount</code>. Or, add <code>amount</code> to
each value from the source signal.</p>



* `new Shift(float amount, Signal<Float> src)`


## SignalLock


<p>A Signal Adapter that can “lock” the source signal to a certain value; it’ll
return the first value it gets from the source signal, regardless of what
the underlying signal returns (in fact, it won’t even call the underlying
signal).</p>

<p>You can <code>unlock</code> the SignalLock, and it’ll call the source signal again, and
then auto-lock to that new value.</p>

<p>This is most useful if you’re using a source signal in (say) a Repeat
draught, and want to use the same value for each iteration, but on the next
frame, advance the source signal.</p>



* `new SignalLock(Signal<T> src)`


## Speed


<p>Start at zero, and increment the value at the given rate-per-second. A
<code>Speed</code> at 2 would, after one second, return 0.5, and after two seconds,
return 1, etc.</p>



* `new Speed(float ratePerSecond)`


## Threshold


<p>Turn an <code>Osc</code> into a stream of booleans, based on whether the oscillator’s
value is greater than zero.</p>

<p>(This one is, admittedly, kind of odd, kind of specific.)</p>



* `new Threshold(Osc osc)`



---------------

Generated 2018-01-20 17:56:48 -05:00
