package com.alexbeard.calculator;

import java.util.HashMap;

public class RomeNumber {

    public static final HashMap<String, String> RomeToArabNumbersHM = new HashMap<String, String>(){{
       put("I", "1");
       put("II", "2");
       put("III", "3");
       put("IV", "4");
       put("V", "5");
       put("VI", "6");
       put("VII", "7");
       put("VIII", "8");
       put("IX", "9");
       put("X", "10");
    }};

   public static final HashMap<Integer, String> ArabToRomeNumbersHM = new HashMap<Integer, String>(){{
      put(1,"I");
      put(2,"II");
      put(3,"III");
      put(4,"IV");
      put(5,"V");
      put(6,"VI");
      put(7,"VII");
      put(8, "VIII");
      put(9,"IX");
      put(10,"X");
      put(11,"XI");
      put(50,"L");
      put(40,"XL");
      put(100,"C");
   }};
}
