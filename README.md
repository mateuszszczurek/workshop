Tell Don't Ask - https://martinfowler.com/bliki/TellDontAsk.html

When to do:
* we see a lot of getters usage
* object seem to be a data structure only, it doesn't contain any behavior
* how veil what

Why to do:
* achieve encapsulation
* make the object API cleaner
* increase object cohesion
* make object usage more readable - hide the internals from the 'outside world'
* make the object more loosely coupled, with well defined contract
* and so on and so forth...

When to consider not to:
* layering concerns (you might be better off with services objects)
* complex/heavyweight object dependencies

Keep in mind:
* Use common sense
* Never blindly follow one principle, many of them might be in conflict depending on the context
* If it helps you, expose getter - there's no harm in doing that!