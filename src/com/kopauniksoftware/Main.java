package com.kopauniksoftware;

import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Input the number you want converted to binary: ");

        int number = in.nextInt();

        // Get and print results
        System.out.printf("The binary of %d is %s", number, getBinary(number));

    }

    private static String getBinary(int number){



        // finds the highest power of 2 that we need using
        // the equation 'log2(n) = numDigits'
        int numDigits = (int) (Math.log(number)/Math.log(2)) + 1;

        // Creates bitArray of the right size
        int bitArray[] = new int[numDigits];

        // Starts the recursion
        bitArray = getBinaryRecursive(number, numDigits, bitArray, 0);

        // Turns bitarray into a string
        String binary = "";
        for (int i : bitArray){
            //System.out.print(i);
            binary = binary + String.valueOf(i);
        }

        return binary;
    }

    private static int[] getBinaryRecursive(int number, int curDigit, int[] bitArray, int curIndex){

        // Base case
        if (curDigit <= 0){
            return bitArray;
        } else {

            int newNumber;

            // Checks if curDigit needs to be a 1
            // Math.pow uses curDigit - 1 to account
            // for binary starting at 2^0
            int thisPower = (int) Math.pow(2, curDigit - 1); // gets this power
            if (thisPower <= number){
                bitArray[curIndex] = 1;
                newNumber = number - thisPower;
            } else {
                bitArray[curIndex] = 0;
                newNumber = number;
            }

            // Recurses and returns
            return getBinaryRecursive(newNumber, curDigit - 1, bitArray, ++curIndex);

        }

    }
}
