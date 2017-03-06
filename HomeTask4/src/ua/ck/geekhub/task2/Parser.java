package ua.ck.geekhub.task2;

import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    public static void main(String[] args) {
        System.out.println("Enter number in the range (1 ≤ number ≤ 100)");

        Scanner in = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();

        System.out.println("Input");

        int validNumber = 0;

        for (int i = 0; i < 3; i++) {
            int number = Integer.parseInt(in.nextLine());

            if (InputUtils.checkNumb(number)) {
                validNumber = number;
                break;
            } else {
                System.out.println("enter another number");
            }
        }

        for (int i = 0; i < validNumber; i++) {
            words.add(in.nextLine());
        }

        System.out.println("Output");

        for (String word : words) {
            System.out.println(WordUtils.getAbbr(word));
        }
    }
}
