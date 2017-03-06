package ua.ck.geekhub.task2;

/**
 * Created by grava on 13.11.16.
 */
public class InputUtils {

    static boolean checkNumb(int number) {
        if (number >= 1 && number <= 100) {
            return true;
        } else {
            return false;
        }
    }
}
