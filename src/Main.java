import ibadts.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split(" ");
        System.out.println(balancedBrackets(input));
    }

    public static boolean balancedBrackets(String [] input){
        Stack<String> stack = new Stack<>();

        for (String x : input) {
            if (x.equals("(") || x.equals("{") || x.equals("[")) {
                stack.push(x);
                continue;
            }

            if (stack.isEmpty())
                return false;

            String checker;
            switch (x) {
                case ")" -> {
                    checker = stack.pop();
                    if (checker.equals("{") || checker.equals("["))
                        return false;
                }
                case "}" -> {
                    checker = stack.pop();
                    if (checker.equals("(") || checker.equals("["))
                        return false;
                }
                case "]" -> {
                    checker = stack.pop();
                    if (checker.equals("(") || checker.equals("{"))
                        return false;
                }
            }
        }
        return (stack.isEmpty());
    }
}