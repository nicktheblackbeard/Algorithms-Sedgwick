//by nicktheblackbeard
import edu.princeton.cs.algs4.*;
//exercise 1.3.9

public class Main {
    public static void main(String[] args) {

        StringBuilder expression = new StringBuilder("1+2)*3-4)*5-6)))"); //result: ((1+2)*((3-4)*(5-6)))
        //StringBuilder expression = new StringBuilder("3+4)*5+7)/3-9))*9-2)))"); //result: ((3+4)*(((5+7)/(3-9))*(9-2)))
        Stack<String> lastN = new Stack<>(); //the previous values from operator
        Stack<Integer> pos = new Stack<>(); //positions of the previous values.

        for(int i = 0; i < expression.length(); i++){
            if(isOperator(expression.charAt(i))){ //if value is operator
                pos.push(i-1);
                lastN.push(String.valueOf(expression.charAt(i-1))); //previous position of operator
            }
            else if(String.valueOf(expression.charAt(i)).equals(")")){
                String pv = lastN.pop();
                int p = pos.pop();
                if(pv.equals(")")){
                    //if previous value is ')' it means that we have to find the position
                    //that this previous operand start, so to put there the bracket
                    expression.insert(findPosition(expression, p-1), '(');
                }
                else{
                    expression.insert(p, '('); //if the previous value from operator is number, put the left bracket there
                }
                i++; //next value
            }
        }
        System.out.println(expression); //result
    }

    private static int findPosition(StringBuilder expr, int p){
        //if rightbrackets are equal to leftbrackets, that means that we have an operand
        //so we return the position that this operand begins
        int rightBrackets = 1, leftBrackets = 0;
        for(int i = p; i >= 0; i--){
            if(String.valueOf(expr.charAt(i)).equals(")")){
                rightBrackets++;
            }
            else if (String.valueOf(expr.charAt(i)).equals("(")){
                leftBrackets++;
            }
            if(rightBrackets == leftBrackets)
                return i;
        }
        return -1; //error not handled
    }
    private static boolean isOperator(char c){
        String s = String.valueOf(c);
        switch (s){
            case "+": return true; case "-": return true; case "/": return true; case "*": return true;
            default: return false;
        }
    }
}
