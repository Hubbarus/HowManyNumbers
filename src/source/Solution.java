package source;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(findAll(10, 3));
        System.out.println(findAll(27, 3));

    }

    public static List<Long> findAll(final int sumDigits, final int numDigits) {

        long digit = (long) Math.pow(10, (double) numDigits - 1);

        int count = 0;
        long firstDigit = 0;
        long lastDigit = 0;
        int sum = 0;
        while (digit != Math.pow(10, (double) numDigits)) {
            //validating digit
            if (validateDigit(digit)) {
                //counting sum of elements
                sum = getSum(digit);

                //checking sum == sumDigints
                if (sum == sumDigits) {
                    if (count == 0) {
                        firstDigit = digit;
                        count++;
                        if (count == 1) {
                            lastDigit = digit;
                        }
                    } else {
                        lastDigit = digit;
                        count++;
                    }
                }
            }
            digit = digIncr(digit);
        }

        List<Long> resultList = new ArrayList<>();
        if (count != 0) {
            resultList.add((long) count);
            resultList.add(firstDigit);
            resultList.add(lastDigit);
            return resultList;
        } else return Collections.EMPTY_LIST;
    }

    public static long digIncr(long dig) {
        if (validateDigit(dig)) {
            return ++dig;
        }

        //arrays implementation of digit
        long[] arr = new long[String.valueOf(dig).length()];
        int k = arr.length - 1;
        while (dig != 0) {
            arr[k] = dig % 10;
            dig /= 10;
            k--;
        }

        //main logic of method. validating and changing the digit array
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                for (int j = i; j < arr.length; j++) {
                    arr[j] = arr[i -1];
                }
                break;
            }
        }

        //collecting string from digit array
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        return Long.parseLong(sb.toString());
    }

    public static boolean validateDigit(long l) {
        while (l != 0) {
            if ((l % 10) < ((l / 10) % 10)) return false;
            l /= 10;
        }
        return true;
    }

    public static int getSum(long l) {
        int sum = 0;
        while (l != 0) {
            sum += (l % 10);
            l /= 10;
        }
        return sum;
    }
}