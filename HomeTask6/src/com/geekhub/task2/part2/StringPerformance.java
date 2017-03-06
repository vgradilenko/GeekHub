package com.geekhub.task2.part2;

public class StringPerformance {
    private static final int CONCATENATION_CYCLES = 100000;

    public static void main(String[] args) {
        testStringPerformance();
        testStringBuilderPerformance();
        testStringBufferPerformance();
    }

    private static void testStringPerformance() {
        long beginTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i <= CONCATENATION_CYCLES; i++) {
            str = str + i;
        }
        long timePastMs = System.currentTimeMillis() - beginTime;
        System.out.println("String concatenation took " + timePastMs + "ms");
    }

    private static void testStringBuilderPerformance() {
        StringBuilder sb = new StringBuilder();
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < CONCATENATION_CYCLES; i++) {
            sb.append(i);
        }
        long timePastMs = System.currentTimeMillis() - beginTime;
        System.out.println("String concatenation took " + timePastMs + "ms");
    }

    private static void testStringBufferPerformance() {
        StringBuffer sbuff = new StringBuffer();
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < CONCATENATION_CYCLES; i++) {
            sbuff.append(i);
        }
        long timePastMs = System.currentTimeMillis() - beginTime;
        System.out.println("String concatenation took " + timePastMs + "ms");
    }
}
