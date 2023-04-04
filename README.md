# ExpressionTreeBridges.java
## Description 
This project is an implementation of an arithmetic expression tree using the 'bridges.base.BinTreeElement<E>' class as the node. The program accepts a mathematical expression as a string parameter and returns the root of the parse tree. It can also evaluate the expression and visualize the parse tree using the Bridges API.
  
## Requirements 
To run this program, you will need to have the Bridges API installed.
  
## Usage 
  The main class of the program is 'ExpressionTreeBridges.java,' which contains the 'buildParseTree()' and 'evaluate()' methods for constructing and evaluating the expression tree, as well as code for visualizing the tree using the Bridges API.

To use the program, simply create a new instance of the 'ExpressionTreeBridges' class and call the 'buildParseTree()' and 'evaluate()' methods with your mathematical expression as a parameter. You can also customize the Bridges visualization by changing the title and description of the visualization.
 
  Here are some examples:
```String ex1 = "( ( 7 + 3 ) * ( 5 - 2 ) )";
BinTreeElement<String> parseTree1 = buildParseTree(ex1);
double answer1 = evaluate(parseTree1);
System.out.println(answer1);
System.out.println(getEquation(parseTree1));
```
  
  ```
  String ex2 = "( ( 10 + 5 ) * 3 )";
BinTreeElement<String> parseTree2 = buildParseTree(ex2);
double answer2 = evaluate(parseTree2);
System.out.println(answer2);
System.out.println(getEquation(parseTree2));
```
  
  ```
  String ex3 = "( ( ( ( ( 2 * 12 ) / 6 ) + 3 ) - 17 ) + ( 2 * 0 ) )";
BinTreeElement<String> parseTree3 = buildParseTree(ex3);
double answer3 = evaluate(parseTree3);
System.out.println(answer3);
System.out.println(getEquation(parseTree3));
```
  
  ```
  String ex4 = "( 3 + ( 4 * 5 ) )";
BinTreeElement<String> parseTree4 = buildParseTree(ex4);
double answer4 = evaluate(parseTree4);
System.out.println(answer4);
System.out.println(getEquation(parseTree4));
```
