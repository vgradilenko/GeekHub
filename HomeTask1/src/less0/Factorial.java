package less0;

/**
 * Created by grava on 14.10.16.
 */
public class Factorial {
    private int number;

    public Factorial(int numb) {
        this.number = numb;
    }

    public int calculate() {
        int result = 1;
        if (this.number < 0){
            return 0;
        } else {
            for (int i = 1; i <= this.number; i++) {
                result *= i;
            }
        }
        return result;
    }
}
