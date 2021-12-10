
/* Practice java codingss */
// shift + alt + f for auto indent
import java.util.*;
import java.io.*;

public class coding {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // long a = scanner.nextLong(), b = scanner.nextLong(), c = scanner.nextLong();
        try {
            // Scanner scanner = new Scanner(System.in); // uncomment when submitting
            // scanner.useDelimiter("[,\\s+]");
            // * comment this whole section when submitting
            File in = new File("in.txt");
            Scanner scanner = new Scanner(in);
            PrintStream out = new PrintStream("out.txt");
            PrintStream err = new PrintStream("err.txt");
            System.setOut(out);
            System.setErr(err);
            // */
            Long counter = (long)0;
            String inputs;
            ArrayList<Stack<Character>> incomplete_lines = new ArrayList<>();
            ArrayList<Long> line_scores = new ArrayList<>();
            //Stack<Character> brackets = new Stack<>();
            while(scanner.hasNext()){
                inputs = scanner.nextLine();
                Stack<Character> brackets = new Stack<>();
                for(int i = 0; i < inputs.length(); ++i){
                    if(inputs.charAt(i) == '(' || inputs.charAt(i) == '<' || inputs.charAt(i) == '{' || inputs.charAt(i) == '['){
                        brackets.add(inputs.charAt(i));
                    }
                    else if(inputs.charAt(i) == ')'){
                        if(brackets.peek() == '(') brackets.pop();
                        else {
                            counter += 3; break;
                        }
                    }
                    else if(inputs.charAt(i) == '>'){
                        if(brackets.peek() == '<') brackets.pop();
                        else {
                            counter += 25137; break;
                        }
                    }
                    else if(inputs.charAt(i) == ']'){
                        if(brackets.peek() == '[') brackets.pop();
                        else {
                            counter += 57; break;
                        }
                    }
                    else if(inputs.charAt(i) == '}'){
                        if(brackets.peek() == '{') brackets.pop();
                        else {
                            counter += 1197; break;
                        }
                    }
                    if(i == inputs.length() - 1){
                        incomplete_lines.add(brackets);
                        //print_stack(brackets);
                    }
                }
                //brackets.clear();
            }
            System.out.println(counter); // part 1 ans
            for(int i = 0; i < incomplete_lines.size(); ++i){
                counter = (long)0;
                Stack<Character> brackets = incomplete_lines.get(i);
                //print_stack(brackets);
                while(!brackets.empty()){
                    //System.out.println("Entered here :0");
                    if(brackets.peek() == '('){
                        counter *= 5;
                        counter += 1;
                    }
                    else if(brackets.peek() == '['){
                        counter *= 5;
                        counter += 2;
                    }
                    else if(brackets.peek() == '{'){
                        counter *= 5;
                        counter += 3;
                    }
                    else if(brackets.peek() == '<'){
                        counter *= 5;
                        counter += 4;
                    }
                    brackets.pop();
                }
                line_scores.add(counter);
            }
            print_array(line_scores);
            Collections.sort(line_scores);
            //System.out.println(incomplete_lines.size());
            System.out.println(line_scores.get( line_scores.size()/2)); //part 2 ans
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("sORT ME oUt");
        }
    }

    public static void print_stack(Stack<Character> inputs){
        while(!inputs.empty()){
            System.out.print(inputs.pop());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void print_array(String[] inputs) {
        for (int i = 0; i < inputs.length; ++i)
            System.out.print(inputs[i] + ' ');
    }

    public static <T> void print_array(ArrayList<T> inputs) {
        for (int i = 0; i < inputs.size(); ++i) {
            System.out.print(inputs.get(i));
            System.out.print(' ');
        }
        System.out.println();
    }

}
