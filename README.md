# CS 320 – Software Testing and Automation Portfolio Artifact

This repository contains selected artifacts from my CS 320 course, which focused on software testing, automation, and quality assurance practices in Java. The included files demonstrate my ability to design back-end services, create structured unit tests using JUnit, and analyze testing strategies based on software requirements.

---

## Included Artifacts

### Project One
- `Contact.java`
- `ContactService.java`
- `ContactTest.java`
- `ContactServiceTest.java`

These files demonstrate:
- Requirement-driven development  
- Object-oriented design  
- Input validation and defensive programming  
- Automated unit testing using JUnit  
- Boundary value analysis and negative testing  

### Project Two
- `Summary_and_Reflections_Report.docx`

This report demonstrates:
- Analysis of testing approaches based on requirements  
- Evaluation of test coverage and effectiveness  
- Reflection on automation, bias, and disciplined engineering practices  

---

## Reflection

### How can I ensure that my code, program, or software is functional and secure?

To ensure functionality, I rely on requirement-driven unit testing. Every requirement should map to at least one positive and one negative test case. In this project, I validated null constraints, length restrictions, duplicate prevention, and date validation to ensure correct system behavior. Automated testing allows me to verify functionality consistently through repeatable execution in CI/CD environments.

Security begins with defensive programming. Validating inputs, rejecting invalid states, and preventing duplicate identifiers protects system integrity. Writing negative test cases helps expose edge cases and potential failure points early in development.

---

### How do I interpret user needs and incorporate them into a program?

I begin by carefully analyzing stated requirements and translating them into enforceable constraints within the code. For example, if a requirement specifies that an appointment cannot be scheduled in the past, I implement validation logic directly in the constructor and create unit tests that enforce that rule.

Interpreting user needs requires converting high-level expectations into measurable behaviors. If a requirement cannot be tested, it is often not clearly defined. This mindset ensures traceability between requirements and implementation.

---

### How do I approach designing software?

I approach design by first modeling core entities and defining constraints before implementation. In this project, I defined object invariants within constructors and reinforced them through service-level validation logic. I selected appropriate data structures, such as `HashMap`, to ensure efficient lookup and scalability.

Testing influences design decisions. Writing unit tests alongside implementation encourages modular code, clear interfaces, and single-responsibility classes. I prioritize clarity, validation, and maintainability over shortcuts, as disciplined design reduces technical debt and improves long-term reliability.

---

## Skills Demonstrated

- Java object-oriented programming  
- JUnit test development  
- Boundary value analysis  
- Negative testing  
- Requirement traceability  
- Code coverage evaluation  
- Defensive programming  
- Reflection on testing methodologies  

---

This repository reflects my ability to apply structured testing strategies, automate validation, and approach software engineering with discipline and attention to quality.
