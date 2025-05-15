# Lab 2

## Patterns used in code

### 1. Adapter

Class `OutpitLogger` adapts `OutputWriter` implementation to output using `Logger` interface. That allows to replace `ConsoleLogger` with `OutputLogger` to get logging to file functionality with reusing existing classes

### 2. Decorator

Each `GenericHero` subclass has different base stats and implements `Hero` interface. Items modify base stats of character by implementing `modifyXYZ` methods from `Equipment` abstract class that also implements `Hero` interface by wrapping existing `Hero` object and applying modifiers to it

### 3. Bridge

`Shape` subclasses take `Renderer` implementation as constructor parameter, and when `Shape.draw` method is called it "Draws" desired shape using `Renderer.render` method implementation

### 4. Proxy

`SmartTextReader` implement file opening, reading and closing trough `Reader` interface. `SmartTextChecker` wraps `Reader` implementation and logs all actions and errors. `SmartTextSecurity` also wraps `Reader` implementation to check what user accesses and throws an error when user reads system data

### 5. Composite

`LightNode` class defines `innerHTML` and `outerHTML` abstract methods. `LightTextNode` implements them as String, `LightElementNode` allows to store child `LightNode` objects in tags. When inner/outerHTML method implementation is called it returns recursively

### 6. Flyweight

`LightNodeFactory` stores all references to used tags, so when passed node has same content as existing it is replaced by existing reference to save memory
Note: create book.txt in 
