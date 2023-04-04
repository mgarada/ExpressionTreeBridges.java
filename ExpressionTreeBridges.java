/**
 * ExpressionTreeBridges.java
 * This project is implements an arithmetic expression tree using bridges.base.BinTreeElement<E> as the node.
 * Mohammad Garada 
 */


package cmsc256;

import bridges.connect.Bridges;
import bridges.base.BinTreeElement;

import java.util.Stack;


public class ExpressionTreeBridges {


    public static void main(String[] args) {
        String ex1 = "( ( 7 + 3 ) * ( 5 - 2 ) )";
        BinTreeElement<String> parseTree1 = buildParseTree(ex1);
        double answer1 = evaluate(parseTree1);
        System.out.println(answer1);
        System.out.println(getEquation(parseTree1));

        String ex2 = "( ( 10 + 5 ) * 3 )";
        BinTreeElement<String> parseTree2 = buildParseTree(ex2);
        double answer2 = evaluate(parseTree2);
        System.out.println(answer2);
        System.out.println(getEquation(parseTree2));

        String ex3 = "( ( ( ( ( 2 * 12 ) / 6 ) + 3 ) - 17 ) + ( 2 * 0 ) )";
        BinTreeElement<String> parseTree3 = buildParseTree(ex3);
        double answer3 = evaluate(parseTree3);
        System.out.println(answer3);
        System.out.println(getEquation(parseTree3));

        String ex4 = "( 3 + ( 4 * 5 ) )";
        BinTreeElement<String> parseTree4 = buildParseTree(ex4);
        double answer4 = evaluate(parseTree4);
        System.out.println(answer4);
        System.out.println(getEquation(parseTree4));

        /* Initialize a Bridges connection */
        Bridges bridges = new Bridges(5, "moeg", "1635461342501");

        /* Set an assignment title */
        bridges.setTitle("Arithmetic Parse Tree Project - Debra Duke");
        bridges.setDescription("CMSC 256, Spring 2022");

        try {
            /* Tell BRIDGES which data structure to visualize */
            bridges.setDataStructure(parseTree1);
            /* Visualize the Array */
            bridges.visualize();

            /* Tell BRIDGES which data structure to visualize */
            bridges.setDataStructure(parseTree2);
            /* Visualize the Array */
            bridges.visualize();

            /* Tell BRIDGES which data structure to visualize */
            bridges.setDataStructure(parseTree3);
            /* Visualize the Array */
            bridges.visualize();

            /* Tell BRIDGES which data structure to visualize */
            bridges.setDataStructure(parseTree4);
            /* Visualize the Array */
            bridges.visualize();
        } catch (Exception ex) {
            System.out.println("Error connecting to Bridges server.");
        }
    }

    //The method accepts a mathematical expression as a string parameter and returns the root of the parse tree
    public static bridges.base.BinTreeElement<String> buildParseTree(String expression) {

        //Creating BinTreeElement
        //creating the root
        BinTreeElement<String> parseTree = new BinTreeElement<>("root", "");
        //creating the "current"
        BinTreeElement<String> current = parseTree;
        //Creating the stack for the tree
        Stack<BinTreeElement> treeElements = new Stack<>();
        //Creating a String array for tokens
        String[] tokens = expression.split(" ");


        //run through expression using for each loop
        for (String token : tokens) {
            token = token.trim();

            //if start of the expression
            if (token.equals("(")) {
                current.setLeft(new BinTreeElement<>("left", "left"));
                treeElements.push(current);
                current = current.getLeft();
            }
            //if operator +, -, /, *
            else if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {
                current.setValue(token);
                current.setRight(new BinTreeElement<>("right", "right"));
                treeElements.push(current);
                current = current.getRight();
            }
            //if the end of the expression
            else if (token.equals(")")) {
                if (!treeElements.empty()) {
                    current = treeElements.pop();
                }
            }
            //if character is a digit
            else if (isNumeric(token)) {
                current.setValue(token);
                if (!treeElements.empty()) {
                    current = treeElements.pop();
                }
            } else {
                //throw exception if a symbol that is not specified is inputted.
                throw new IllegalArgumentException("Expression cannot be parsed. Current token is " + token);
            }


        }
        //return the tree that is built
        return parseTree;
    }


    //method converts or does the procedure for the operators
    public static double symbolProcedure(String symbol, double left, double right) {

        //if any number is divided by 0, throw the exception
        if (symbol.equals("/") && right == 0) {
            throw new ArithmeticException();
        }


        //switch cases for each operation scenario
        switch (symbol) {
            case "+":
                //if +, return + operation
                return (left + right);
            case "-":
                //if -, return - operation
                return (left - right);
            case "*":
                //if *, return * operation
                return (left * right);
            case "/":
                //if /, return / operation
                return (left / right);

        }
        //needs a return
        return 5;
    }


    //This method evaluates a parse tree by recursively evaluating each subtree.
    public static double evaluate(bridges.base.BinTreeElement<String> tree) {


        //if the tree is null, return this constant
        if (tree.getValue() == null) {
            return Double.NaN;
        }

        //base case for the recursive method
        if (tree.getLeft() == null && tree.getRight() == null) {
            return Double.parseDouble(tree.getValue());
        }
        //evaluating the left subtree
        double left = evaluate(tree.getLeft());
        //evaluating the right subtree
        double right = evaluate(tree.getRight());

        return symbolProcedure(tree.getValue(), left, right);
    }


    //The method accepts the root of the parse tree parameter and returns a mathematical expression as a string.
    public static String getEquation(bridges.base.BinTreeElement<String> tree) {

        //Creating a left string
        String leftString = "";
        //Creating a right string
        String rightString = "";

        //if the left or the right are null return the root
        if (tree.getLeft() == null && tree.getRight() == null) {
            return tree.getValue();
        }


        //if they are not null, call evaluate on both the left and the right children of the current node.
        if (tree.getLeft() != null && tree.getRight() != null) {
            leftString = getEquation(tree.getLeft());
            rightString = getEquation(tree.getRight());
        }
        //return the left and right strings, along with root value (operator), with the appropriate parenthesis
        return "(" + " " + leftString + " " + tree.getValue() + " " + rightString + " " + ")";
    }

    //method in order to check for numeric values in a string
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


}
