package Archive.DataStructureStuff;

import java.util.Scanner;
import java.util.Stack;

public class PostFixCalculator {

    //checks whether c is an operator
    private static boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/'
                || c == '^' || c == '(' || c == ')') {
            return true;
        } else {
            return false;
        }
    }

    /*compares precedence of topmost operator in stack with operator at current position in infix-string
    * and assignees a numeric vale to determine its priority in math operations
    */
    private static boolean isLowerPrecedence(char operatorOldChar, char operatorNewChar) {
        boolean check = true; //true = new operator has higher precedence than old operator; false = contrary
        int operatorOld = 0, operatorNew = 0; //will compare precedence of operators; higher number = higher precedence(priority)

        //assign precedence to old operator (topmost in stack)
        if (operatorOldChar == '+' || operatorOldChar == '-') {
            operatorOld = 2;
        } else if (operatorOldChar == '*' || operatorOldChar == '/') {
            operatorOld = 3;
        } else if (operatorOldChar == '^') {
            operatorOld = 4;
        }

        //assign precedence to new operator (current character in infix)
        if (operatorNewChar == '+' || operatorNewChar == '-') {
            operatorNew = 2;
        } else if (operatorNewChar == '*' || operatorNewChar == '/') {
            operatorNew = 3;
        } else if (operatorNewChar == '^') {
            operatorNew = 4;
        }

        if (operatorNewChar == '(') {
            check = false;
        } else if (operatorNewChar == ')') {
            check = true;
        } else if (operatorOld < operatorNew) {
            check = false;
        } else if (operatorOld >= operatorNew) {
            check = true;
        }

        return check;
    }

    public static String convertToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        boolean isStillOneNumber = true; //will differentiate between outputs like 11 or 1 1

        for (int i = 0; i < infix.length(); i++) {

            if (!isOperator(infix.charAt(i)) & infix.charAt(i) != ' ') { //handles numbers and constants
                if (isStillOneNumber) {
                    postfix.append(infix.charAt(i));
                } else {
                    postfix.append(" ");
                    postfix.append(infix.charAt(i));
                }
                isStillOneNumber = true;
            } else if (isOperator(infix.charAt(i))) { //handles operators
                if (infix.charAt(i) == ')') {
                    while (!stack.isEmpty() & stack.peek() != '(') {
                        postfix.append(" ");
                        postfix.append(stack.pop());
                    }
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    if (!stack.isEmpty()) {
                        if (!isLowerPrecedence(stack.peek(), infix.charAt(i))) {
                            stack.push(infix.charAt(i));
                        } else {
                            while (!stack.isEmpty()) {
                                postfix.append(" ");
                                postfix.append(stack.pop());
                            }
                            stack.push(infix.charAt(i));
                        }
                    } else if (stack.isEmpty()) {
                        stack.push(infix.charAt(i));
                    }
                }
                isStillOneNumber = false;
            } else { //handles possible spaces in infix
                isStillOneNumber = false;
            }

        }
        while (!stack.isEmpty()) {
            postfix.append(" ");
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    public static String convertToInfix(String postfix) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (isOperator(c)) {
                String b = stack.pop();
                String a = stack.pop();
                stack.push("(" + a + c + b + ")");
            } else {
                stack.push("" + c);
            }
        }

        return stack.pop();
    }

    public static int postfixEvaluate(String postfixExpression) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < postfixExpression.length(); i++) {
            if(isOperator(postfixExpression.charAt(i))){
                int num2 = stack.pop();
                int num1 = stack.pop();

                switch (postfixExpression.charAt(i)) {
                    case '+':
                        stack.push(num1 + num2);
                        break;
                    case '-':
                        stack.push(num1 - num2);
                        break;
                    case '*':
                        stack.push(num1 * num2);
                        break;
                    case '/':
                        stack.push(num1 / num2);
                        break;
                }
            }else if(Character.isDigit(postfixExpression.charAt(i))){
                stack.push(Integer.parseInt(Character.toString(postfixExpression.charAt(i))));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println("Enter:-");
        System.out.println("1.To Calculate a PostFix Expression");
        System.out.println("2.To Calculate an infix Expression");
        System.out.println("3.Convert an infix Expression to PostFix Form");
        System.out.println("4.Convert a PostFix Expression to infix Form");
        System.out.println("0.Exit");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input){
            case "1" :
                System.out.println("Enter a PostFix Expression");
                String postfix = scanner.nextLine();
                System.out.print("Infix Form : ");
                System.out.println(convertToInfix(postfix));
                System.out.print("Solution : ");
                System.out.println(postfixEvaluate(postfix));
                break;
            case "2" :
                System.out.println("Enter an InFix Expression");
                String infix = scanner.nextLine();
                System.out.print("PostFix Form : ");
                System.out.println(convertToPostfix(infix));
                System.out.print("Solution : ");
                System.out.println(postfixEvaluate(convertToPostfix(infix)));
                break;
            case "3" :
                System.out.println("Enter an Infix Expression");
                String infixExpression = scanner.nextLine();
                System.out.print("Infix Form : ");
                System.out.println(convertToPostfix(infixExpression));
                break;
            case "4" :
                System.out.println("Enter a PostFix Expression");
                String postfixExpression = scanner.nextLine();
                System.out.print("PostFix Form : ");
                System.out.println(convertToInfix(postfixExpression));
                break;
            case "0" :
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }
}