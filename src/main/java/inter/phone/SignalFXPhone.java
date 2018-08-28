package inter.phone;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SignalFXPhone {
    /**
     * inputs:
     *  (1) window size: w
     *  (2) infinite stream of numbers
     * ouputs:
     *  (1) minimum over the window size
     *  (2) maximum over the window size
     *
     * example:
     *  w = 3
     * input:      1   5   12   13  8  3  -5
     * max     .   1   5   12   13  13 ...  
     * min     .   1   1   1    5   8 ....
     */
     
     // (1, t0)
     // (5, t1)
     // (12, t2)
     // add (13, t3), remove(1, t0)
    
    int windowSize;
    int[] store;
    int currentPosition;
    
    SignalFXPhone(int ws) {
        windowSize = ws;
        store = new int[windowSize];
        currentPosition = 0;
    }
      
    public void input(int value) {
        store[currentPosition] = value;
        currentPosition=(currentPosition + 1) % windowSize;
    }
    
    public int getMaximum() {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < windowSize; i++) {
            if(store[i] > max) {
                max = store[i];
            }
        }
        return max;
    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    }
}