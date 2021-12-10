import java.util.*;
import java.io.*;

public class coding{
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //long a = scanner.nextLong(), b = scanner.nextLong(), c = scanner.nextLong();
        try{
            File in = new File("in.txt");
            Scanner scanner = new Scanner(in);
            int a = 0, b = 0, aim = 0, temp; String dir;
            while(scanner.hasNext()){
                dir = scanner.next();
                temp = scanner.nextInt();
                if(dir.equals("forward")) {
                    a += temp;
                    b += temp * aim;
                }
                else if(dir.equals("up")) aim -= temp;
                else if(dir.equals("down")) aim += temp;
            }
            System.out.println(a * b);
            scanner.close();
        } catch(FileNotFoundException e){
            return;  
        }
    }
}
