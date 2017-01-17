What is refactoring:
A change made to the internal structure of software to make it easier to understand and cheaper to modify without changing its observable behavior… It is a disciplined way to clean up code that minimizes the chances of introducing bugs.
- MartinFowler and Kent Beck, Refactoring (https://www.amazon.com/Refactoring-Improving-Design-Existing-Code/dp/0201485672)

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