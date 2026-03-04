import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("for infix to post fix put 1 for post fix evalulation 2: ");
        int in = scanner.nextInt();

        if(in == 1){

            System.out.println("Enter equastion to be made infix: ");
            scanner.nextLine();
            String in1 = scanner.nextLine();

            System.out.println(ReversePolishNotation.infixToPostfix(in1));

        } else if (in == 2) {

            System.out.println("Enter postfix equastion to solve: ");
            scanner.nextLine();
            String in2 = scanner.nextLine();

            System.out.println(ReversePolishNotation.evaluatePostfix(in2));

        }


    }
}
