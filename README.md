Here is the formatted description of the principles used in your Zoo Management System project, matching your example:

---

# Zoo Management System

## Principles Followed in the Code

### 1. DRY (Don't Repeat Yourself)

**Example:**

* The `GenericAnimal` class centralizes shared animal behavior (`eat`, `getName`, etc.), preventing repetitive logic in subclasses like `Lion`, `Dolphin`, and `Parrot`.
* The `Feeder` interface provides a shared `FeedAnimal` method, avoiding duplicated feeding logic in both `ZooKeeper` and `ZooVisitor`.

### 2. KISS (Keep It Simple, Stupid)

**Example:**

* Responsibilities are clearly split across classes: `ZooKeeper` feeds animals, `Director` orders food, `Warehouse` manages inventory.
* The animal feeding process is straightforward: check diet > take food > log result.

### 3. SOLID Principles

#### **S - Single Responsibility Principle (SRP)**

**Example:**

* `ZooKeeper` handles only zoo staff feeding logic.
* `GenericWarehouse` manages only food storage and retrieval.
* `Animal` classes focus only on animal-related behavior (like eating, sound).

#### **O - Open/Closed Principle (OCP)**

**Example:**

* New animal types can be introduced by extending abstract animal classes `WaterAnimal`, `GroundAnimal`, `GenericAnimal` without altering existing classes.
* `Enclosure` implementations (`Cage`, `Aquarium`) extend `GenericEnclosure` and override behavior as needed.

#### **L - Liskov Substitution Principle (LSP)**

**Example:**

* `GroundAnimal` and `WaterAnimal` subclasses (like `Lion` or `Dolphin`) can be used wherever their respective parent types are expected without breaking functionality.
* `ZooKeeper` and `ZooVisitor` both fulfill the `Feeder` contract properly.

#### **I - Interface Segregation Principle (ISP)**

**Example:**

* `Animal` interface defines only animal-relevant methods (`getName`, `getDiet`, etc.).
* `FoodProvider` abstracts only food distribution; it doesn’t burden implementers with unrelated methods.

#### **D - Dependency Inversion Principle (DIP)**

**Example:**

* `Feeder` implementations depend on `FoodProvider` abstraction, not on concrete implementations like `GenericWarehouse` or `VisitorFoodShop`.
* `Zoo` references `Warehouse` and `FoodProvider` interfaces for flexibility.

### 4. YAGNI (You Ain't Gonna Need It)

**Example:**

* The `SmallFish` class leaves `makeSound()` empty rather than overengineering a placeholder behavior for soundless animals.
* No extra behavior or systems are added unless directly required.

### 5. Composition Over Inheritance

**Example:**

* `VisitorFoodShop` uses composition by containing a `FoodProvider` rather than extending one, allowing flexible delegation.
* `Zoo` composes its systems (list of `Enclosure`, `Warehouse`, others) rather than extending these classes.

### 6. Program to Interfaces, Not Implementations

**Example:**

* `Zoo`, `ZooKeeper`, and `Feeder` depend on `Animal`, `FoodProvider`, and `Warehouse` interfaces rather than concrete classes.
* Allows easy creation of new implementations that may have different behaviour

### 7. Fail Fast Principle

**Example:**

* `Warehouse` and `Enclosure` implementations throw `InsufficientResourcesException` immediately when constraints (e.g., volume, food amount) are violated.
* Issues are reported as early as possible, making debugging easier and avoiding cascading failures.

---

Would you like this exported as a Markdown file?
