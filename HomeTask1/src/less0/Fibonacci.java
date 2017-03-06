package less0;

/**
 * Created by grava on 14.10.16.
 */
public class Fibonacci {
    private int number;

    public Fibonacci(int number){
        this.number = number;
    }

    public int calculate() {
        if (this.number <= 0){
            return 0;
        } else {
            int a = 1;
            int b = 1;
            int res;
            System.out.print(a + " " + b + " ");
            for (int i = 1; i <= this.number - 2; i++) {
                res = a + b;
                a = b;
                b = res;
                System.out.print(res + " ");
            }
        }
        return 0;
    }

}
