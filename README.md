  Sita Amira Syarifah
  2206023023
  Adpro-C

Modul 3
Apply the SOLID principles you have learned. You are allowed to modify the source code according to the principles you want to implement. Please answer the following questions: 
1) Explain what principles you apply to your project!

Single Responsibility Principle (SRP): Yes, I apply SRP in my code by separating the responsibility to generate IDs and create products into two different methods. Also, I split the responsibility in the update car method where searching for a car with a specific ID and editing car attributes are placed in two separate methods, ensuring each focuses on one task only.

Open-Closed Principle: Yes, I've applied OCP in my code. I ensure that IDs for both products and cars (in the create method) can be extended in other ways without modifying existing code.

Liskov Substitution Principle: Yes, I've implemented LSP by ensuring that CarController doesn't extend ProductController and stands as its own class. This ensures that each controller focuses on its own responsibilities without mixing irrelevant logic.

Interface Segregation: Yes, I believe I've implemented ISP in my program. All interfaces in my program only have methods related to their focus, such as the ProductService interface having methods related to product services like edit, create, delete.

Dependency Inversion: Yes, I've refactored the program to implement DIP. I've created ProductRepositoryInterface and CarRepositoryInterface to abstract the necessary operations for products and cars, allowing me to separate high-level classes from repository implementation details, which adhere to DIP.

2) Explain the advantages of applying SOLID principles to your project with examples.
By applying SOLID principles, my program becomes more flexible and easier for other developers to modify. When rule changes occur, a SOLID-based design can adapt without affecting other parts of the system. For instance, by restructuring to use interfaces for repositories, other developers can add new repository implementations without worrying about impacting the existing system.


3) Explain the disadvantages of not applying SOLID principles to your project with examples.
Without applying SOLID principles, it would be challenging to develop the program to a higher complexity level because a system not following SOLID tends to be less flexible in accommodating changes. Additionally, lack of responsibility separation and unclear coding can lead to unexpected behavior and difficult-to-identify errors. For example, if another developer wants to use an option other than UUID for product IDs, but previously IDs were always set using UUID during product creation, it might hinder them from extending it.





Modul 2

1. During the exercise, I encountered several code quality issues that needed addressing. These included syntax errors that impeded the compilation process, unused or undefined variables causing unnecessary overhead, and instances of code duplication that warranted elimination to enhance clarity and mitigate the risk of desynchronized changes.

2. Upon reviewing the CI/CD workflows on GitHub/GitLab, I believe the current implementation has effectively met the definitions of Continuous Integration and Continuous Deployment. The CI process automatically executes upon each new code change, encompassing testing and code quality analysis. Subsequently, the CD process automatically deploys to the designated platform. Consequently, this facilitates a rapid and automated development cycle, enabling consistent and efficient testing and deployment practices.


Modul 1:
Reflection 1:
You already implemented two new features using Spring Boot. 
Check again your source code and evaluate the coding standards that you have learned in this module. 
Write clean code principles and secure coding practices that have been applied to your code. 
If you find any mistake in your source code, please explain how to improve your code.

In this initial tutorial, I've diligently put into practice the foundational tenets of "Clean Code" that have been instilled within the course curriculum. 
To begin with, meticulous attention has been given to naming variables with utmost clarity, ensuring that both myself and any other stakeholders perusing the code are met with no ambiguity or confusion. 
Furthermore, the functions meticulously crafted are not only distinctly delineated but also succinctly structured and highly efficient, thereby obviating the necessity for supplementary explanatory comments.


Reflection 2
After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors? 
Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables. 

After writing unit tests, I feel confident about the code's quality. The number of unit tests in a class depends on its complexity, but each important or complex function should have at least one test. To ensure our unit tests are sufficient, we can check code coverage, a metric indicating how much of our code is tested. However, achieving 100% code coverage doesn't guarantee bug-free code.

Creating another functional test suite for verifying the number of items in the product list is reasonable. However, duplicating setup procedures and instance variables in a new class may lead to code redundancy and reduced maintainability. It's crucial to maintain code cleanliness to avoid such issues. Refactoring the setup procedures into a common base class and utilizing inheritance can help reduce code duplication and enhance code quality. Additionally, employing reusable helper methods and organizing tests into logical groups can further improve code cleanliness and readability.
