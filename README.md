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
