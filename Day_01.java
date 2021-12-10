import java.util.*;
import java.io.*;

public class coding{
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //long a = scanner.nextLong(), b = scanner.nextLong(), c = scanner.nextLong();
        try{
            File in = new File("in.txt");
            Scanner scanner = new Scanner(in);
            int a, b, j = 0, counter = 0;
            int[] inputss = new int[2000];
            while(scanner.hasNextInt()){
                inputss[j++] = scanner.nextInt();
            }
            a = inputss[0] + inputss[1] + inputss[2];
            for(int i = 3; i < 2000; ++i){
                if(inputss[i] > inputss[i-3]) ++counter;
                a -= inputss[i-3];
                a += inputss[i];
            }
            System.out.println(counter);
            scanner.close();
        } catch(FileNotFoundException e){
            return;  
        }
    }
}

/*
part 1:
            while(scanner.hasNextInt()){
                b = scanner.nextInt();
                if(b > a) ++counter;
                a = b;
            }
            
        
*/
