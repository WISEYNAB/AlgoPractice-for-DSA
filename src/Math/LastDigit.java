import java.util.*;
import java.math.BigInteger;

public class LastDigitPower {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.next();
        String K = sc.next();

        if (K.equals("0")) {
            System.out.println(1);
            return;
        }

        int lastDigit = N.charAt(N.length() - 1) - '0';

        int[][] cycles = {{0},{1},{2,4,8,6},{3,9,7,1},{4,6},{5},{6},{7,9,3,1},{8,4,2,6},{9,1}};

        int[] cycle = cycles[lastDigit];
        int pos = new BigInteger(K).subtract(BigInteger.ONE).mod(BigInteger.valueOf(cycle.length)).intValue();

        System.out.println(cycle[pos]);

        sc.close();
    }
}