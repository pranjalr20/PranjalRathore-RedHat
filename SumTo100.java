import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SumTo100 implements Runnable {

    public static void main(String[] args) {
        new SumTo100().run();
    }

    void print(int givenSum) {
        Expression expression = new Expression();
        for (int i = 0; i < Expression.NUMBER_OF_EXPRESSIONS; i++, expression.next()) {
            if (expression.toInt() == givenSum) {
                expression.print();
            }
        }
    }

    void comment(String commentString) {
        System.out.println();
        System.out.println(commentString);
        System.out.println();
    }

    final Stat stat = new Stat();
    public void run() {

        comment("Show all solutions that sum to 100");
        final int givenSum = 100;
        print(givenSum);

        
    }

    private static class Expression {

        private final static int NUMBER_OF_DIGITS = 9;
        private final static byte ADD = 0;
        private final static byte SUB = 1;
        private final static byte JOIN = 2;

        final byte[] code = new byte[NUMBER_OF_DIGITS];
        final static int NUMBER_OF_EXPRESSIONS = 2 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3;

        Expression next() {
            for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
                if (++code[i] > JOIN) {
                    code[i] = ADD;
                } else {
                    break;
                }
            }
            return this;
        }

        int toInt() {
            int value = 0;
            int number = 0;
            int sign = (+1);
            for (int digit = 1; digit <= 9; digit++) {
                switch (code[NUMBER_OF_DIGITS - digit]) {
                    case ADD:
                        value += sign * number;
                        number = digit;
                        sign = (+1);
                        break;
                    case SUB:
                        value += sign * number;
                        number = digit;
                        sign = (-1);
                        break;
                    case JOIN:
                        number = 10 * number + digit;
                        break;
                }
            }
            return value + sign * number;
        }

        
        public String toString() {
            StringBuilder s = new StringBuilder(2 * NUMBER_OF_DIGITS + 1);
            for (int digit = 1; digit <= NUMBER_OF_DIGITS; digit++) {
                switch (code[NUMBER_OF_DIGITS - digit]) {
                    case ADD:
                        if (digit > 1) {
                            s.append('+');
                        }
                        break;
                    case SUB:
                        s.append('-');
                        break;
                }
                s.append(digit);
            }
            return s.toString();
        }

        void print() {
            print(System.out);
        }

        void print(PrintStream printStream) {
            printStream.format("%9d", this.toInt());
            printStream.println(" = " + this);
        }
    }

    private static class Stat {

        final Map<Integer, Integer> countSum = new HashMap<>();
        final Map<Integer, Set<Integer>> sumCount = new HashMap<>();

        Stat() {
            Expression expression = new Expression();
            for (int i = 0; i < Expression.NUMBER_OF_EXPRESSIONS; i++, expression.next()) {
                int sum = expression.toInt();
                countSum.put(sum, countSum.getOrDefault(sum, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : countSum.entrySet()) {
                Set<Integer> set;
                if (sumCount.containsKey(entry.getValue())) {
                    set = sumCount.get(entry.getValue());
                } else {
                    set = new HashSet<>();
                }
                set.add(entry.getKey());
                sumCount.put(entry.getValue(), set);
            }
        }
    }
}
