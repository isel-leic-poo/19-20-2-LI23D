# Outline and resources

## Week 1
### 26/02/2020 - Course introduction
* Syllabus, teaching methodology and bibliography.

## Week 2
### 02/03/2020 - Past subjects review
* Java's type system: types, variables, values and objects
* Mutability and immutability
* Imperative language's execution model: execution state
* Resource: [Java Language Basics](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/index.html)

### 04/03/2020 - Past subjects review, continued
* Classes: objects, instance members and access modifiers
* Execution control:
  * Function activation
  * Parameter passing
* Exercices
* Resources: 
  * [Classes]((https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html))
  * [Objects](https://docs.oracle.com/javase/tutorial/java/javaOO/objects.html)

## Week 3
### 09/03/2020 - Introduction to the development of interactive applications (using a top-down approach in Android)
* Android's programming model: introduction
  * Inversion of Control (IOC): motivation and consequences
  * The Activity as the UI's host
    * onCreate method: its purpose and execution constraints
* Introduction to the development of applications with Graphical User Interface (a.k.a. GUI applications)
  * Controls (a.k.a. Views): concept and motivation
  * Types of controls: simple and composite (layouts)
  * The event driven programming model: introduction

### 12/03/2020 - Live coding session
* Principles behind code organization in GUI applications
  * The Model-View-Controller pattern: [introduction](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller)
* Live coding session to demonstrate the presented subjects
  * [The counting application](https://github.com/isel-leic-poo/19-20-2-LI23D/tree/master/Counting)   
 
## Week 4
### 16/03/2020 - Inheritance, introduction
* Principles behind code organization in GUI applications
  * The Model-View-Controller pattern, revisited
* Inheritance
  * Concept and motivation
    * [As a way to capture commonalities](https://docs.oracle.com/javase/tutorial/java/concepts/inheritance.html)
    * As a framework extension mechanism
  * Relation `extends` between two classes
* Interfaces
  * Concept and motivation 
  * Relation `implements` between a class and an interface
* Live coding session to demonstrate the presented subjects
  * [The drawing application](https://github.com/isel-leic-poo/19-20-2-LI23D/tree/master/Draw)   

### 18/03/2020 - Inheritance and Polimorphism, continued
* The Java type system, revisited
  * Interface, as a contract specification
  * Polimorfism through inheritance, revisited
* The Iterator pattern
  * Concept and motivation
  * Materialization on the Java platform
    * On the Collection API
    * On the foreach construction
* Live coding session to demonstrate the presented subjects
  * [The drawing application](https://github.com/isel-leic-poo/19-20-2-LI23D/tree/master/Draw)   

## Week 5
### 23/03/2020 - Nested classes
* The Java type system, revisited
  * [Nested classes, concept and motivation](https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html)
    * Inner classes
    * Local classes
    * Anonymous classes
* Polimorfism through inheritance, continued
* Live coding session to demonstrate the presented subjects
  * [The drawing application](https://github.com/isel-leic-poo/19-20-2-LI23D/tree/master/Draw)   

### 25/03/2020 - Nested classes, continuation
* [Nested classes, continued](https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html)
* Live coding session to demonstrate the presented subjects
  * [The drawing application](https://github.com/isel-leic-poo/19-20-2-LI23D/tree/master/Draw)   

## Week 6
### 30/03/2020 - Design and implementation of interactive applications
* Goal: Implementing the [Snake Game](https://www.google.com/search?q=play+snake)
  * Considerations on the solution's design
  * Basic animation principles: location, velocity and reflection
  * Live coding session to demonstrate the subjects presented thus far

### 01/04/2020 - Design and implementation of interactive applications, continued
* Goal: Implementing the [Snake Game](https://www.google.com/search?q=play+snake)
  * The POO support library: classes Tile and TilePanel
  * Live coding session
* The Java type system, revisited
  * [Enum Types](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)

## Week 7
Easter break

## Week 8
### 15/04/2020 - Design and implementation of interactive applications, continued
* Goal: Implementing the [Snake Game](https://www.google.com/search?q=play+snake), continued
* Considerations on the design of interactive applications
  * The Model-View-Controller pattern, revisited
  * Comparison between imperative and functional programming styles
* Exception based error handling
  * Concept and motivation
  * [Exceptions in Java](https://docs.oracle.com/javase/tutorial/essential/exceptions/)
    * Checked and unchecked exceptions
* Live coding session to demonstrate the subjects presented thus far
  * [Snake](https://github.com/isel-leic-poo/19-20-2-LI23D/tree/master/Snake)   

## Week 9
### 20/04/2020 - Design and implementation of interactive applications, continued
* Goal: Implementing the [Snake Game](https://www.google.com/search?q=play+snake), continued
* Considerations on the design of interactive applications
  * The Model-View-Controller pattern, revisited
  * Design anomaly: [circular dependencies](https://en.wikipedia.org/wiki/Circular_dependency)
    * Causes and solutions
    * Dependency inversion
    * The observer pattern, revisited
* Live coding session to demonstrate the subjects presented thus far
  * [Snake](https://github.com/isel-leic-poo/19-20-2-LI23D/tree/master/Snake)   

### 22/04/2020 - Practical class
* Goal: [Work assignment 1](https://1920moodle.isel.pt/mod/assign/view.php?id=109594)

## Week 10
### 27/04/2020 - Design and implementation of interactive applications, continued
* Goal: Implementing the [Snake Game](https://www.google.com/search?q=play+snake), continued
* The [Java Collections framework](https://docs.oracle.com/javase/tutorial/collections/index.html): introduction
  * Sequential and associative containers
* Live coding session to demonstrate the subjects presented thus far
  * [Snake](https://github.com/isel-leic-poo/19-20-2-LI23D/tree/master/Snake)   

### 29/04/2020 - Practical class
* Goal: [Work assignment 1](https://1920moodle.isel.pt/mod/assign/view.php?id=109594)

## Week 11
### 04/05/2020 - Java I/O, overview
* Goal: Implementing persistent storage of drawings on the Draw application
  * [Java I/O using streams](https://docs.oracle.com/javase/tutorial/essential/io/streams.html)
  * Revisiting fundamental Object-Oriented concepts
    * Variables, values and objects
    * Classes and interfaces
    * Encapsulation, inheritance and polymorphism
  * The Model-View-Controller pattern, revisited
  * The Observer pattern, revisited
* Live coding session to demonstrate the subjects presented thus far
  * [Draw](https://github.com/isel-leic-poo/19-20-2-LI23D/tree/master/Draw)   

### 06/05/2020 - Practical class
* Goal: [Work assignment 1](https://1920moodle.isel.pt/mod/assign/view.php?id=109594)

## Week 12
### 11/05/2020 - Revisions
* Goal: Revision of the subjects presented thus far
* Live coding session

### 13/05/2020 - Revisions
* Goal: Revision of the subjects presented thus far
* Live coding session to solve [Work assignment 1](https://1920moodle.isel.pt/mod/assign/view.php?id=109594)

## Week 13
### 18/05/2020 - Revisions
* Goal 1: Revision of the subjects presented thus far
* Goal 2: Reflection (introduction)
* Java canonical methods: introduction
* Java Reflection, introduction
  * Reflection API: class Class
* Live coding session to solve [Work assignment 1](https://1920moodle.isel.pt/mod/assign/view.php?id=109594)

### 20/05/2020 - Reflection and Introspection
* Java Reflection API, [overview](https://docs.oracle.com/javase/tutorial/reflect/index.html)
  * Concept and motivation
  * Consequences of its use (trade-offs)
* Java type system, revisited
  * Object and its canonical methods
* Live coding session to solve [Work assignment 1](https://1920moodle.isel.pt/mod/assign/view.php?id=109594)
  * Applying introspection techniques in the solution
  
## Week 14
### 25/05/2020 - Exercises
* Goal: Consolidation of the subjects addressed in the course
* Live coding session to demonstrate the presented subjects
  * [Snake](https://github.com/isel-leic-poo/19-20-2-LI23D/tree/master/Snake)   

### 27/05/2020 - Practical class
* Goal: [Work assignment 2](https://1920moodle.isel.pt/mod/assign/view.php?id=113816)

## Week 15
### 01/06/2020 - Exercises
* Goal: Consolidation of the subjects addressed in the course
* Live coding session to demonstrate the presented subjects
  * [Snake](https://github.com/isel-leic-poo/19-20-2-LI23D/tree/master/Snake)   

### 03/06/2020 - Practical class
* Goal: [Work assignment 2](https://1920moodle.isel.pt/mod/assign/view.php?id=113816)

## Week 16
No classes during this week

## Week 17
### 15/06/2020 - Conclusion
* Final considerations regarding the course and the addressed subjects
* Presentation of the final implementation of the Snake game, developped during the semester
  * [Snake](https://github.com/isel-leic-poo/19-20-2-LI23D/tree/master/Snake)   

### 17/06/2020 - Practical class
* Goal: [Work assignment 2](https://1920moodle.isel.pt/mod/assign/view.php?id=113816)
