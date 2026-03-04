import java.util.ArrayList;
import java.util.Scanner;
import java.util.EmptyStackException;

public class ReversePolishNotation {

    static int evaluatePostfix(String in){
        Stack numbs = new Stack();
        String[] possible = {"+", "-", "*", "/"};
        String[] possible2 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9"};


        for (int i = 0; i < in.length(); i++) {
            boolean num = true;

            for (int o = 0; o < possible.length; o++) {

                if (in.substring(i, i + 1).equals(possible[o])) {
                    num = false;
                } else if (in.substring(i, i + 1).equals(possible[1])) {
                    for (int j = 0; o < possible2.length; o++) {

                        if (i < in.length()) {
                            if (in.substring(i + 1, i + 2).equals(possible2[j])) {
                                num = true;
                            }

                        }
                    }
                }

            }

            if (num) {
                boolean nums = true;
                boolean go = true;
                String bignum = "";
                while (go) {

                    nums = false;
                    for (int o = 0; o < possible2.length; o++) {

                        if (i < in.length()) {
                            if (in.substring(i, i + 1).equals(possible2[o])) {
                                nums = true;
                            }

                        }


                    }
                    if (nums) {

                        bignum += in.substring(i, i + 1);
                        i++;
                    } else {



                        go = false;
                    }

                }
                if (bignum.length()>0){
                    numbs.push(bignum);
                }
            }

            if (!num) {
                if (!numbs.isEmpty()) {
                    if (in.substring(i, i + 1).equals(possible[0])) {
                        String b = String.valueOf(numbs.pop());
                        String a = String.valueOf(numbs.pop());
                        numbs.push(Integer.parseInt(a) + Integer.parseInt(b));
                    }
                    if (in.substring(i, i + 1).equals(possible[1])) {
                        String b = String.valueOf(numbs.pop());
                        String a = String.valueOf(numbs.pop());
                        numbs.push(Integer.parseInt(a) - Integer.parseInt(b));
                    }
                    if (in.substring(i, i + 1).equals(possible[2])) {
                        String b = String.valueOf(numbs.pop());
                        String a = String.valueOf(numbs.pop());
                        numbs.push(Integer.parseInt(a) * Integer.parseInt(b));
                    }
                    if (in.substring(i, i + 1).equals(possible[3])) {
                        String b = String.valueOf(numbs.pop());
                        String a = String.valueOf(numbs.pop());
                        numbs.push(Integer.parseInt(a) / Integer.parseInt(b));
                    }
                }
            }
        }




        int pluh = 0;
        if (!numbs.isEmpty()){
            pluh += (int) numbs.pop();
        }


        return pluh;
    }


    static  String infixToPostfix (String in) {
        Stack polish = new Stack();

        String finaleq = "";

        String[] possible = {"+", "-", "*", "/"};
        String[] possible2 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};


        for (int i = 0; i < in.length(); i++) {
            boolean num = true;

            for (int o = 0; o < possible.length; o++) {

                if (in.substring(i, i + 1).equals(possible[o])) {
                    num = false;
                }

            }

            if (num) {
                boolean nums = true;
                boolean go = true;
                String bignum = "";
                while(go){


                    nums = false;
                    for (int o = 0; o < possible2.length; o++) {

                        if(i < in.length()) {
                            if (in.substring(i , i + 1 ).equals(possible2[o])) {
                                nums = true;
                            }

                        }


                    }
                    if(nums){

                        bignum += in.substring(i, i + 1);
                        i++;
                    } else {

                        i--;
                        go = false;
                    }



                }



                finaleq += bignum + " ";


            } else if (!num) {
                //code value system for oporaters

                String maybe = in.substring(i, i + 1);

                boolean week = true;
                if(!polish.isEmpty()){
                    if (maybe.equals("*") || maybe.equals("/")){
                        while(polish.peek().equals("*") || polish.peek().equals("/")){
                            finaleq += polish.pop() + " ";
                        }

                        polish.push(maybe);
                    }

                    if (maybe.equals("+") || maybe.equals("-")) {
                        while (!polish.isEmpty()) {
                            finaleq += polish.pop() + " ";
                        }

                        polish.push(maybe);
                    }
                } else {
                    polish.push(maybe);
                }
            }

        }

        while (!polish.isEmpty()) {
            finaleq += polish.pop() + " ";
        }

        return finaleq;


    }
}
