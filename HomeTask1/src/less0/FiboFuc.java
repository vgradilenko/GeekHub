package less0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by grava on 13.10.16.
 */
public class FiboFuc {
    public static void main(String[] args) throws IOException {
        System.out.println("Please, choice: 1) Fibonacci, 2) Factorial");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            Integer choice = Integer.parseInt(reader.readLine());
            if (choice.equals(1)){
                System.out.println("enter number > 0");
                Integer numbFib = Integer.parseInt(reader.readLine());
                Fibonacci fibonacci = new Fibonacci(numbFib);
                fibonacci.calculate();
                break;
            } else if (choice.equals(2)){
                System.out.println("Ok, Enter number");
                BufferedReader readerFuc = new BufferedReader(new InputStreamReader(System.in));
                Integer numbFuc = Integer.parseInt(readerFuc.readLine());
                Factorial factorial = new Factorial(numbFuc);
                System.out.println(factorial.calculate());
                break;
            }
            System.out.println("Please, choice 1 or 2");
        }
    }
}
