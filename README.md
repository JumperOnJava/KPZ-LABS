# Lab 4

## Patterns used in code

### 1. Chain of responsibility

`ChainHandler` interface has `handle` method to handle current element and `setNext` method to set next handler if current fails

### 2. Mediator

Moved all logic that accessed other side from `Aircraft` and `Runway` classes to `CommandCentre`. `Aircraft` and `Runway` now have only fields and logic related to themselves and CommandCentre handles interactions between them

### 3. Observer

https://github.com/JumperOnJava/KPZ-LABS/pull/2<br>
`Event` implements `Publisher` interface and allows to `Subscriber` implementations to subscribe to publisher. When event happens (`Publisher.publish(context)` is called) every subsribers' `run` method is executed.

### 4. Strategy

https://github.com/JumperOnJava/KPZ-LABS/pull/3<br>
Image resolving is happening trough ImageResolvingStrategy interface and implementation changes based on internet connection: if internet is available `ImageServerStrategy` implementation is used for image resolving in image context. If internet is unavailable then `CacheResolvingStrategy` implementation is used for getting previously cached images from local cache folder

### 5. Memento

Before making any changes to `TextDocument` content `TextEditor` backs up its current state (`Snapshot`) to stack. When undo is requested previous state is taken from stack, and restored using `Snapshot.restore` method



