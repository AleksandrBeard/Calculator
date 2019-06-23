package com.alexbeard.calculator;

import java.sql.SQLOutput;

public class Printer {
    public static void printResult(int result){
        System.out.println(result);
    }

    public static void printRomeResult(int result){
        if(result == 0){
            System.out.println(0);
        }
        if(RomeNumber.ArabToRomeNumbersHM.containsKey(result)){
            System.out.println(RomeNumber.ArabToRomeNumbersHM.get(result));
        }else {
            StringBuilder sb = new StringBuilder();
            int count10, count1 = 0;
            if(result > 11 && result < 40){
                count10 = result/10;
                for (int i = 0; i < count10; i++) {
                    sb.append(getNumber(10));
                }
                count1 = result%10;
                if(count1 != 0)
                    sb.append(getNumber(count1));
            }else if(result/10 == 4){
                sb.append(getNumber(40));
                if(result%10!= 0)
                    sb.append(getNumber(result%10));
            }else if(result > 49 && result < 90 ){
                sb.append(getNumber(50));
                count10 = (result - 50)/10;
                if(count10 > 0){
                    for (int i = 0; i < count10; i++) {
                        sb.append(getNumber(10 ));
                    }
                }
                count1= (result - 50)%10;
                if(count1 != 0)
                    sb.append(getNumber(count1));
            }else if(result > 89){
                sb.append(getNumber(90));
                sb.append(getNumber(result-90));
            }
            System.out.println(sb.toString());
        }
    }

    private static String getNumber(int n){
        return RomeNumber.ArabToRomeNumbersHM.get(n);
    }
}
