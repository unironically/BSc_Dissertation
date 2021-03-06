
 CS3821 Full Unit Project
 ==========
## BNF Pretty Printer
### Brief
Program to take BNF specifications passed by file and print them in readable format. ANTLR4 parser generator used to create lexing and parsing classes based on EBNF grammar defined in [BNF.g4](https://github.com/RHUL-CS-Projects/FullUnit_1920_LukeBessant/blob/master/BNF%20Pretty%20Printer/src/antlr4/BNF.g4). No credit taken for the creation of any files within the [src/antlr4](https://github.com/RHUL-CS-Projects/FullUnit_1920_LukeBessant/tree/master/BNF%20Pretty%20Printer/src/antlr4) directory other than [BNF.g4](https://github.com/RHUL-CS-Projects/FullUnit_1920_LukeBessant/blob/master/BNF%20Pretty%20Printer/src/antlr4/BNF.g4) - all credits to [ANTLR4](https://www.antlr.org/).
### Specifications
BNF specifications must be supplied as a ```.bnf``` file to the program argument. Specifications supported follow the pattern described in section 3.6 of the [CS3480 Software Engineering with Metamodels](http://www.cs.rhul.ac.uk/courses/CS3480/partialbook.pdf) book written by [Adrian Johnstone](https://github.com/AJohnstone2007) with the exception of RDP syntax:
```
nonterminal ::= nonterminal 'terminal' ('this'|'that').
```
Syntax also including optional, kleene closure and positive closure clauses:
```
optional ::= ['optional'] | ('optional')?.
kleene_closure ::= {'kleene closure'} | ('Kleene closure')*.
positive_closure ::= ('positive closure')+.
```
A sample ```.bnf``` file can be found at [sample.bnf](https://github.com/RHUL-CS-Projects/FullUnit_1920_LukeBessant/blob/master/BNF%20Pretty%20Printer/sample/sample.bnf).
BNF syntax supported by this program at [SYNTAX.md](https://github.com/RHUL-CS-Projects/FullUnit_1920_LukeBessant/blob/dev/BNF%20Pretty%20Printer/SYNTAX.md).
### Running
Steps to download and run the BNF pretty printer on Linux systems:
```
git clone https://github.com/RHUL-CS-Projects/FullUnit_1920_LukeBessant
cd FullUnit_1920_LukeBessant/BNF\ Pretty\ Printer/bin
java -jar BNF\ Pretty\ Printer.jar /path/to/grammar.bnf
```
### Built With
- [ANTLR](https://www.antlr.org/) - The parser generator used

## Calculator Interpreter
### Brief
Program to provide a console allowing users to calculate expressions involving the four basic arithmetic operations; expressions are converted to a simple stack code and then interpreted to calculate the result. The user can also assign the results of calculations to variables and use these in later expressions.
### Syntax
- Expressions: ```$ (10 + 5) / 2 * 2.5```
- Use of variables: 
	- ```$ r1 = (12 - 2) / 5``` 
	- ```$ r1 * 2```
- Exit: ```Ctrl+D``` or ```Ctrl+C```
### Stack code
Upon entering an expression in infix notation, the expression is then converted to postfix notation using a reduced implementation of the syntax tree generated by ANTLR4. From postfix notation we can simply create stack code by traversing the postfix string. An example of stack code generated by ```(10 + 5) / 2 * 2.5``` with result ```18.75```:
```
PUSH 10.0;
PUSH 5.0;
ADD;
PUSH 2.0;
DIV;
PUSH 2.5;
MUL;
```
### Running
Steps to download and run the calculator interpreter on Linux systems:
Using JAR file:
```
git clone https://github.com/RHUL-CS-Projects/FullUnit_1920_LukeBessant
cd FullUnit_1920_LukeBessant/Calculator\ Interpreter/bin
java -jar Calculator\ Interpreter.jar
```
Otherwise:
```
git clone https://github.com/RHUL-CS-Projects/FullUnit_1920_LukeBessant
cd FullUnit_1920_LukeBessant/Calculator\ Interpreter/src
antlr4 antlr4/*.g4 -package antlr4
javac main/Main.java
java main.Main
```
Use the flag ```-v``` or ```--verbose``` when running to invoke the 'verbose' mode with which the user is shown the stack code generated by their expressions and assignments.
### Built with
- [ANTLR](https://www.antlr.org/) - The parser generator used
- [MismatchInputListener solution](https://stackoverflow.com/questions/18132078/handling-errors-in-antlr4) - For catching grammar input mismatch errors

## Lexer Generator
### Brief
Program to allow the user to provide a regular expression, for which a minimal deterministic finite-state automaton is constructed using Thompson's construction to build an NFA, subset construction to convert this NFA to a DFA and Hopcroft's algorothm to convert this to the minimum possible DFA.
### Syntax
- Alternation: ```a|a```
- Kleene closure: ```a*```
- Positive closure ```a+```
- Optional closure ```a?```
- Character range: ```e.g. [a-zA-Z0-9_.~!]```
- Quantifier: ```a{2,}``` ('a' twice or more)

Where ```a``` is any expression.
Example, identifier names beginning with a lower case letter or underscore, allowing lower and upper case characters, numbers and underscores:
```[a-z_][a-zA-Z0-9_]*```
### Automata
For the expression ```[a-c]``` the following automata are generated by the program.

Initial NFA generated by using Thompson's construction, converting each sub-NFA to a DFA using subset construction and Hopcroft's algorithm:
```
Start state: 0
 - State 0: (ε, 2) (ε, 4) 
 - State 1: ACCEPTING
 - State 2: (a, 3) 
 - State 3: (ε, 1) 
 - State 4: (b, 5) (c, 5) 
 - State 5: (ε, 1) 
 ```
 
DFA generated by subset construction:
```
Start state: 0
 - State 0: (a, 1) (b, 2) (c, 2) 
 - State 1: ACCEPTING
 - State 2: ACCEPTING
```
Minimal DFA derived by Hopcroft's algorithm:
```
Start state: 0
 - State 0: (a, 1) (b, 1) (c, 1) 
 - State 1: ACCEPTING
 ```
### Running
Steps to download and run the calculator interpreter on Linux systems:
Using JAR file:
```
git clone https://github.com/RHUL-CS-Projects/FullUnit_1920_LukeBessant
cd FullUnit_1920_LukeBessant/Lexer\ Generator/bin
java -jar Lexer\ Generator.jar "[a-c]+"
```
Otherwise:
```
git clone https://github.com/RHUL-CS-Projects/FullUnit_1920_LukeBessant
cd FullUnit_1920_LukeBessant/Lexer\ Generator/src
javac main/Main.java
java main.Main "[a-c]+"
```

## Java Compiler
This is the final deliverable program of the project, being a compiler supporting the compilation of a subset of Java (detailed below) down to Java byte code which can then be passed to the Java Virtual Machine. 

### Syntax
The language supported by the compiler contains the following major language features:
- Class/field/constructor/method declarations; only public and static modifiers supported currently
- Primitive (int and boolean), existing class (String) and user-defined types
- Variables with block scope
- If statements
- Expressions:
	- Class/field/method/variable identifiers
	- String/int literals
	- Binary operations
	- Assignment
	- Field references
	- Method calls

Two working sample programs can be found [here](https://github.com/RHUL-CS-Projects/FullUnit_1920_LukeBessant/tree/master/Java%20Compiler/sample).
### Running
Steps to download and run the calculator interpreter on Linux systems:  
```
git clone https://github.com/RHUL-CS-Projects/FullUnit_1920_LukeBessant
cd FullUnit_1920_LukeBessant/Java\ Compiler/bin
java -jar Java\ Compiler.jar /path/to/file.java
cd /path/to
java file.java
```
### Built with
- [ANTLR](https://www.antlr.org/) - The parser generator used
- [MismatchInputListener solution](https://stackoverflow.com/questions/18132078/handling-errors-in-antlr4) - For catching grammar input mismatch errors.

## Reports

All of the reports written for this project can be found [here](https://github.com/RHUL-CS-Projects/FullUnit_1920_LukeBessant/tree/master/Project%20Reports).
