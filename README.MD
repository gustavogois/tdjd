# Test-Driven Java Development

Based on the book [Test-Driven Java Development](https://www.amazon.com/Test-Driven-Java-Development-end-end/dp/1788836111/ref=dp_ob_title_bk).

## Branches

### 1 - Red-Green-Refactor

- The Red-Green-Refactor process
- Tic-Tac-Toe's requirements
- Developing Tic-Tac-Toe
- Code coverage

### 2 - Unit-Tests

In the previous Chapter 3, Red-Green-Refactor – From Failure Through Success until Perfection, we practiced the Red-Green-Refactor procedure. We used unit tests without going deeper into how unit testing works in the context of TDD. We'll build on the knowledge from the last chapter and go into more detail by trying to explain what unit tests really are and how they fit into the TDD approach to building software.

The goal of this chapter is to learn how to focus on the unit we're currently working on and how to ignore or isolate those that were done before.

The following topics will be covered in this chapter:

- Unit testing
- Unit testing with TDD
- Remote-controlled ship requirements
- Developing the remote-controlled ship

#### Unit Testing

Frequent manual testing is too impractical for any but the smallest systems. The only way around this is the use of 
automated tests. They are the only effective method to reduce the time and cost of building, deploying, and 
maintaining applications. In order to effectively manage applications, it is of the utmost importance that both the 
implementation and test codes are as simple as possible. Simplicity is one of the core extreme programming (XP) 
values (http://www.extremeprogramming.org/rules/simple.html) and the key to TDD and programming in general. It is 
most often accomplished through division into small units. In Java, units are methods. Being the smallest, the 
feedback loop they provide is the fastest so we spend most of our time thinking and working on them. As a counterpart 
to implementation methods, unit tests should constitute by far the biggest percentage of all tests.

#### What is unit testing?

Unit testing is a practice that forces us to test small, individual, and isolated units of code. They are usually 
methods, even though in some cases classes or even whole applications can be considered to be units, as well. In order 
to write unit tests, code under tests needs to be isolated from the rest of the application. Preferably, that 
isolation is already ingrained in the code or it can be accomplished with the use of mocks (more on mocks will be 
covered in Chapter 6, Mocking – Removing External Dependencies). If unit tests of a particular method cross the 
boundaries of that unit, then they become integration tests. As such, it becomes less clear what is under the tests. 
In case of a failure, the scope of a problem suddenly increases and finding the cause becomes more tedious.

#### Why unit testing?

A common question, especially within organizations that rely heavily on manual testing, is Why should we use unit 
instead of functional and integration testing? This question in itself is flawed. Unit testing does not replace other 
types of testing. Instead, unit testing reduces the scope of other types of tests. By its nature, unit testing is 
easier and faster to write than any other type of tests, thus reducing the cost and time to market (TTM). Due to the 
reduced time to write and run them, they tend to detect problems much sooner. The faster we detect problems, the 
cheaper it is to fix them. A bug that was detected minutes after it was created is much easier to fix than if that 
same bug was found days, weeks, or even months after it was made.

#### Code Refactoring

Typically, we approach refactoring by applying a set of small changes without modifying intended behavior. Reducing 
the scope of refactoring changes allows us continuously to confirm that those changes did not break any existing 
functionality. The only way to effectively obtain this confirmation is through the use of automated tests.

One of the great benefits of unit tests is that they are the best refactoring enablers. Refactoring is too risky when 
there are no automated tests to confirm that the application still behaves as expected. While any type of test can be 
used to provide the code coverage required for refactoring, in most cases only unit tests can provide the required 
level of details.

#### Why not use unit tests exclusively?

At this moment, you might be wondering whether unit testing could provide a solution for all your testing needs. 
Unfortunately, that is not the case. While unit tests usually cover the biggest percentage of your testing needs, 
functional and integration tests should be an integral part of your testing toolbox.

We'll cover other types of tests in more detail in later chapters. For now, a few important distinctions between them 
are as follows:

- Unit tests try to verify small units of functionality. In the Java world, those units are methods. All external 
dependencies, such as invocations of other classes and methods or database calls, should be done in memory with the 
use of mocks, stubs, spies, fakes, and dummies.

- Functional and acceptance tests have a job to verify that the application we're building works as expected, as a 
whole. While those two differ in their purpose, both share a similar goal. Unlike unit tests that are verifying the 
internal quality of the code, functional and acceptance tests are trying to ensure that the system is working correctly 
from the customer's or user's point of view. Those tests are usually smaller in number when compared with unit tests 
due to the cost and effort needed to both write and run them.

- Integration tests intend to verify that separate units, modules, applications, or even whole systems are properly 
integrated with each other. You might have a frontend application that uses backend APIs that, in turn, communicate 
with a database. The job of integration tests would be to verify that all three of those separate components of the 
system are indeed integrated and can communicate with each other. Since we already know that all the units are working 
and all functional and acceptance tests are passed, integration tests are usually the smallest of all three as their 
job is only to confirm that all the pieces are working well together:

<< Test Pyramid >>

The testing pyramid states that you should have many more unit tests than higher-level tests (UI tests, integration 
tests, and so on). Why is that? Unit tests are much cheaper to write, faster to run, and, at the same time, provide 
much bigger coverage. Take, for example, registration functionality. We should test what happens when a username is 
empty, when a password is empty, when a username or password is not in the correct format, when the user already 
exists, and so on. Only for this single functionality there can be tens, if not hundreds of tests. Writing and running 
all those tests from the UI can be very expensive (time-consuming to write and slow to run). On the other hand, unit 
testing a method that does this validation is easy, fast to write, and fast to run. If all those cases are covered 
with unit tests, we could be satisfied with a single integration test that checks whether our UI is calling the 
correct method on the backend. If it is, details are irrelevant from an integration point of view since we know that 
all cases are already covered on the unit level.

#### Unit testing with TDD

What is the difference in the way we write unit tests in the context of TDD? The major differentiator is in when. While 
traditionally unit tests are written after the implementation code is done, in TDD we write tests before—the order of 
things is inverted. Without TDD, the purpose of unit tests is to validate an existing code. TDD teaches us that unit 
tests should drive our development and design. They should define the behavior of the smallest possible unit. They are 
micro-requirements pending development. A test tells you what to do next and when you're done doing it. Depending on 
the type of tests (unit, functional, integration, and so on), the scope of what should be done next differs. In the 
case of TDD with unit tests, this scope is the smallest possible, meaning a method or, more often, a part of it. 
Moreover, with TDD driven by unit tests, we are forced to comply to some design principles, such as keep it simple, 
stupid (KISS). By writing simple tests with a very small scope, the implementation of those tests tends to be simple 
as well. By forcing tests not to use external dependencies, we are forcing the implementation code to have a separation 
of concerns that is well-designed. There are many other examples of how TDD helps us to write better code. Those same 
benefits cannot be accomplished with unit testing alone. Without TDD, unit tests are forced to work with an existing 
code and have no influence on the design.

To summarize, the main goal of unit testing without TDD is the validation of the existing code. Unit testing written 
in advance using the TDD procedure has the main objective specification and design, with validation being a side 
product. This side product is often of a higher quality than when tests are written after the implementation.

TDD forces us to think through our requirements and design, write clean code that works, create executable 
requirements, and refactor safely and often. On top of all that, we end up with high test code coverage that is used 
to regression-test all our code whenever some change is introduced. Unit testing without TDD gives us only tests and, 
often, with doubtful quality.