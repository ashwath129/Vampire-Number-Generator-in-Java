package com.vampire;

import java.util.Arrays;

public class vn {

    final static long START = 10, END = 1000;

    
    private static int numDigits(long num){
        return Long.toString(Math.abs(num)).length();
    }
 
    
    public static void main(String[] args) {
    	long vstart = 100000,vend=200000
    			;
        for (long fangA = START; fangA < END; fangA++) {

            String sFangA = String.valueOf(fangA);
            boolean trailingZeros = sFangA.endsWith("0");           
            int max = (int) Math.min(END, Math.pow(10, sFangA.length()));
            
            for (long fangB = fangA; fangB < max; fangB++) {

            	if(((numDigits(vstart)%2)!=0) || ((numDigits(vend)%2)!=0))
               break;
                long candidate = fangA * fangB;
                if (candidate % 9 == (fangA + fangB) % 9) {  
                   
                    String sCandidate = String.valueOf(candidate);
                    String sFangB = String.valueOf(fangB);

                    if ((trailingZeros && sFangB.endsWith("0")) == false) {

                        char[] cVampire = sCandidate.toCharArray();
                        Arrays.sort(cVampire);

                        char[] cFangs = (sFangA + sFangB).toCharArray();
                        Arrays.sort(cFangs);
                        
                      //  System.out.println(cVampire);

                        if (Arrays.equals(cVampire, cFangs)) {
                        	if((candidate > vstart) && (candidate < vend))
                            System.out.println(sFangA + " * " + sFangB + " = " + sCandidate);
                        }
                    }
                }
            }
        }
    }
}