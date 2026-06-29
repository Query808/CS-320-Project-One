# CS-320-Project-One

Reflection

How can you make sure your program is working okay and is secure?
The discipline to ensure that the code written is functional and secure is the same. I never trust input, and I do not assume code is working until it has been proven to work. That means I validate data at the boundaries, fail hard if anything is wrong, and try to ensure that the objects in my code cannot be placed into an incorrect state. That can then be verified by a large set of tests which cover the normal case and a number of cases where things go wrong.

How do I interpret user needs and incorporate them into a program?
I interpret user needs for a program by treating the requirements as a contract between what the user needs and what the software does. In translating user needs to rules for the program I try to write test cases before I write the program to ensure that I have interpreted the needs correctly, and that there is no ambiguity in the requirements. I also try to understand the requirements from the user's perspective so I can catch the implications that aren't spelled out in the specification.

How do I approach designing software?
To design software, I try to create a system of independent modules where each component can easily be extended by another component. The components should have one clear responsibility, and by doing so, it makes it easier to follow and understand the system of components. In addition, by trying to reduce the amount of duplication and complexity in the system as much as possible, it becomes easier to extend the system as well. For me, designing software is an iterative process. First, a minimal solution is created to test it. After that, the solution can be refactored as needed to make it better.
