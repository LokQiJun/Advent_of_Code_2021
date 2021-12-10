/* Practice java codingss */

import java.util.*;
import java.io.*;

public class coding{
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //long a = scanner.nextLong(), b = scanner.nextLong(), c = scanner.nextLong();
        try{
            File in = new File("in.txt");
            Scanner scanner = new Scanner(in).useDelimiter(",");
            String input =  " "; int total = 0; int[] num_0 = new int[100]; 
            Arrays.fill(num_0, 0);
            while(scanner.hasNext()){
                input = scanner.nextLine();
                ++total;
                for(int i = 0; i < input.length(); ++i){
                    if(input.charAt(i) == '0') ++num_0[i];
                }
            }
            for(int i = 0; i < input.length(); ++i){
                if(num_0[i] > (total/2) ) System.out.print(0);
                else System.out.print(1);
            }
            scanner.close();
        } catch(FileNotFoundException e){
            System.out.println("sORT ME oUt");  
        }
    }
}
