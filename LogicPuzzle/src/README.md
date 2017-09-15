# Logic Puzzle README

##  Purpose

The purpose of this project was to demonstrate polymorphism and the principle of class inheritance through the use of proposition constants and logical sentences. It also tested our problem 
solving skills by tasking us with the task of making truth tables based on the amount of constants given. 

## Explanation of what in the world is going on...

Based on the main class given, we were supposed to figure out what the program did, and what each class was supposed to do. 

In the first block of code in the main class, the main function of the objects is to contain a proposition constant string that is placed into the parameter. This proposition constant object 
is later passed into the parameter of the logical sentence. The logical sentence class is the parent class of negation, disjunction, conjunction, Nand, Biconditional, and Conditional, which are 
types of Logical Sentences that modify the logical sentences that are passed into them. 

Next, there is the truth assignment class. This class has a method .put() which takes in two parameters, aString constant and a boolean value. Inside the function, the string constant is set to a 
key of a hash map, while the boolean value is set to the value of that key. Therefore, for each constant, there is a corresponding boolean value (b is true, a is false). The purpose of this truth 
assignment object is to use it to evaluate if a certain logical sentence is true or not, which ties back into the operators. 
For example, the l5 conjunction evaluates itself by using the truth values that were assigned for a and b. l3 negates l1, which was the proposition constant a. Since a is set to false, then 
the negation is true. Also, in the parameter, a new negation of l4 is passed.l4 was a negation of l3, which was a negation of l1, which was a. This means that a was originally false, but was negated
4 times to leave it still at false. This means that the conjunction (&&) is still false, because it needed two trues to make it true. 

After that, the rest of the functions do not really tie in to the previous functions. legal() simply checks to see if the string "a&" is true, which it is not, because there is a hanging & symbol.
And findMatch() essentially finds the last character before the closing parenthesis. Both legal and findmatch do this by iterating through the parsed characters.

Finally, the truth table makes a table based on how many constants is given. It iterates through the rows, and then the columns to print 0s and 1s. Where 0 is false and 1 is true. 

## Challenges

I personally had a hard time with the polymorphism, because it is a new concept to me, and I didn't really understand how to structure the flow of the methods. My peers helped me understand the 
structure in which the functions and objects are passed to each other and use each others functions. This project was a great learning experience and every part of it tested my critical thinking skills.