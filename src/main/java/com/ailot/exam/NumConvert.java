/*
 * LY.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */

package com.ailot.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ailot
 * @version NumConvert.java, 2019年04月21日 下午8:20
 */
public class NumConvert {

    //罗马字符对应的十进制数字
    private static Map<String, Integer> romanMap = new HashMap<>();

    //罗马数字集合
    private static final String ROMAN_NUM = "IVXLCDM";
    //可重复三次的字符
    private static final String REPEATED_THREE = "IXCM";
    //不能重复的字符串
    private static final String NEVER_REPEATED = "DLV";
    //重复4次
    private static final String REPEAT_FOUR_NUM = "(\\w)\\1{3,}";
    //重复两次以上
    private static final String REPEAT_TWO_NUM = "(\\w)\\1{2,}";
    //解析罗马字符别名
    private static final String ALIAS_REGEX = "([a-zA-Z]+)\\s+is\\s+([IVXLCDM]+)\\s*";

    private static Map<String, String> aliasMap = new HashMap<>();
    //解析价格
    private static final String CREDIT_REGEX = "((.*)\\s)+is\\s+([0-9]+)\\s+Credits\\s*";
    //解析how many
    private static final String HOW_MANY_REGEX = "how\\s+many\\s+Credits\\s+is\\s+(.*)\\?$";
    //解析how much
    private static final String HOW_MUCH_REGEX = "how\\s+much\\s+is\\s+(.*)\\s*\\?$";

    static {
        romanMap.put("I", 1);
        romanMap.put("IV", 4);
        romanMap.put("V", 5);
        romanMap.put("IX", 9);
        romanMap.put("X", 10);
        romanMap.put("XL", 40);
        romanMap.put("L", 50);
        romanMap.put("XC", 90);
        romanMap.put("C", 100);
        romanMap.put("CD", 400);
        romanMap.put("D", 500);
        romanMap.put("DM", 900);
        romanMap.put("M", 1000);

    }

    //判断输入的字符串是否是罗马字符
    private static boolean checkRoman(String str) {
        if (isBank(str)) {
            return false;
        }

        char[] roman = str.toCharArray();
        for (char c : roman) {
            if (!ROMAN_NUM.contains(String.valueOf(c))) {
                System.out.println("字符" + c + "不属于罗马字符");
                return false;
            }
        }

        Pattern pattern1 = Pattern.compile("(.)\\1+");
        Matcher matcher1 = pattern1.matcher(str);
        while (matcher1.find()){
            System.out.println(123);
        }

        if (str.matches(REPEAT_FOUR_NUM)) {
            System.out.println("存在重复出现四次的字符串");
            return false;
        }
        Pattern pattern = Pattern.compile(REPEAT_TWO_NUM);
        Matcher matcher = pattern.matcher(str);
        matcher.find();
        if (matcher.matches() && NEVER_REPEATED.contains(matcher.group(1))) {
            System.out.println(matcher.group(1) + "不允许重复出现");
        }

        return true;

    }

    /**
     * 解析赋值
     */
    private static String aliasMethod(String word) {

        Pattern pattern = Pattern.compile(ALIAS_REGEX);
        Matcher matcher = pattern.matcher(word);
        matcher.find();
        aliasMap.put(matcher.group(1), matcher.group(2));
        return "";
    }

    /**
     * 解析价格
     * @param word
     * @return
     */
    /*public static String creditMethod(String word) {
        try {
            Pattern pattern = Pattern.compile(CREDIT_REGEX);
            Matcher matcher = pattern.matcher(word);
            matcher.find();
            String left = matcher.group(1);
            String romanLeft = alias2Roman(left);

            // 检验是否罗马文
            boolean checkRoman = checkRoman(romanLeft);
            if (checkRoman) {
                int num = roman2Int(romanLeft);
                String priceAlias = matcher.group(2);
                String total = matcher.group(3);
                priceMap.put(priceAlias, new BigDecimal(Integer.parseInt(total)).divide(new BigDecimal(num)).setScale(2,
                        RoundingMode.HALF_UP));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }*/

    /**
     * 别名转罗马数字
     */
    private static String alias2Roman(String word) {
        String[] words = word.split("\\s");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : words) {
            String aliasVal = aliasMap.get(str);
            stringBuilder.append(isBank(aliasVal) ? "" : aliasVal);
        }
        return stringBuilder.toString();
    }

    /**
     * 罗马数字转十进制
     */
    private static int roman2Int(String word) {
        if (isBank(word)) {
            return 0;
        }
        char[] words = word.toCharArray();
        //获取最高位的值
        int lastVal = romanMap.get(String.valueOf(words[0]));
        for (int i = 1; i < words.length; i++) {
            int val = romanMap.get(String.valueOf(words[i]));
            if (val == lastVal) {
                lastVal += val;
            }
        }
        return lastVal;
    }

    //判断字符串是否为空
    private static boolean isBank(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        checkRoman("CCCCIC");
        /*String pathname = "input.txt";
        URL resource = NumConvert.class.getResource(pathname);
        try {
            FileReader reader = new FileReader(resource.getPath());
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
