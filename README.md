# Lab 2

## Patterns used in code

### 1. Factory method

Each `PurchaseFlow` sublass has different logic for purchasing subscription.<br>
`Website` accepts input stream (possibly from console) with user data<br>
`MobileApp` requires user to "click" on a screen to select subscription type and make photo of student document for student subscription<br>
`ManagerCall` requires telling manager what subscription you want and specify student document id for student subscription<br>

<img src="Task1.png">

### 2. Abstract factory

Each `ManufacturerFactory` implementation can create all devices  <br>
Manufacturer created devices will have different features and specs depeding on manufacturer specific extension of `Laptop` `Phone` and `Tablet`<br>

<img src="Task2.png">

### 3. Singleton

Only one instance of `Authenticator` class can be created and used in all threads<br>
Constructor has private visibility ensure creation object can be only done in static methods of this class<br>
Constructor and `getInstance` method contain checks to ensure only one object can be created even in multithreaded environment<br>
Creation of `Authenticator` is deferred to first call of `getInstance` method<br>

### 4. Prototype

`Virus` implements method `duplicate` from `Prototype` interface<br>
`duplicated` method implementation copies all fields from original to new object, and recursively duplicates each child from childen list <br>

### 5. Builder

`Character` interface defines what any character can do<br>
`CharacterBuilder` interface defines how character is created<br>

`HeroBuilder` and `EnemyBuilder` implement `CharacterBuilder` with different way of passing data to result character;<br>
`Hero` and `Enemy` implement `Character` with different ways to store data;<br>

<img src="Task5.png">
