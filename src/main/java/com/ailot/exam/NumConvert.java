package com.ailot.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.net.URL;
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
    //不能重复的字符串
    private static final String NEVER_REPEATED = "DLV";
    //重复4次
    private static final Pattern REPEAT_FOUR_NUM = Pattern.compile("(\\w)\\1{3,}");

    //重复两次以上
    private static final Pattern REPEAT_TWO_NUM = Pattern.compile("(\\w)\\1+");
    //解析罗马字符别名
    private static final Pattern ALIAS_REGEX = Pattern.compile("([a-zA-Z]+)\\s+is\\s+([IVXLCDM]+)\\s*");

    private static Map<String, String> aliasMap = new HashMap<>();

    private static Map<String, BigDecimal> priceMap = new HashMap<>();

    //解析价格
    private static final Pattern CREDIT_REGEX = Pattern.compile("(.*)\\s+([^\\s]+)\\s+?is\\s+([0-9]+)\\s+Credits\\s*");
    //解析how many
    private static final Pattern HOW_MANY_REGEX = Pattern.compile("how\\s+many\\sCredits\\s+is\\s+(.*)\\s+([^\\s]+?)\\s*\\?\\s*");
    //解析how much
    private static final Pattern HOW_MUCH_REGEX = Pattern.compile("how\\s+much\\s+is\\s+(.*?)\\s*\\?\\s*");

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
        //判断IXCM是否重复超过三次
        Matcher matcherFour = REPEAT_FOUR_NUM.matcher(str);
        while (matcherFour.find()) {
            System.out.println(matcherFour.group(1) + "重复出现四次");
            return false;
        }

        //判断DLV是否重复
        Matcher matcherTwo = REPEAT_TWO_NUM.matcher(str);
        while (matcherTwo.find()) {
            if (NEVER_REPEATED.contains(matcherTwo.group(1))) {
                System.out.println(matcherTwo.group(1) + "不允许重复出现");
                return false;
            }
        }
        return true;

    }

    /**
     * 解析赋值
     */
    private static boolean aliasMethod(String word) {

        Matcher matcher = ALIAS_REGEX.matcher(word);
        if (matcher.find()) {
            aliasMap.put(matcher.group(1), matcher.group(2));
            return true;
        }
        return false;
    }

    /**
     * 解析价格
     *
     * @param word
     * @return
     */
    public static boolean creditMethod(String word) {

        Matcher matcherCredit = CREDIT_REGEX.matcher(word);
        if (matcherCredit.find()) {
            String left = matcherCredit.group(1);
            String romanLeft = alias2Roman(left);
            // 检验是否罗马文
            boolean checkRoman = checkRoman(romanLeft);
            if (checkRoman) {
                int num = roman2Int(romanLeft);
                String priceAlias = matcherCredit.group(2);
                String total = matcherCredit.group(3);
                //计算单价并存入map
                priceMap.put(priceAlias, new BigDecimal(Float.valueOf(total) / num).setScale(2, BigDecimal.ROUND_UP));
                return true;
            }
        }
        return false;
    }

    /**
     * how many解析
     *
     * @param word
     * @return
     */
    public static boolean howManyMethod(String word) {

        Matcher matcher = HOW_MANY_REGEX.matcher(word);
        if (matcher.find()) {
            String left = matcher.group(1);
            String right = matcher.group(2);
            String romanLeft = alias2Roman(left);
            // 检验是否罗马文
            boolean checkRoman = checkRoman(romanLeft);
            if (checkRoman) {
                int num = roman2Int(romanLeft);
                BigDecimal priceVal = priceMap.get(right);
                if (priceVal != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(left).append(" ").append(right).append(" ").append("is ")
                            .append(new BigDecimal(num).multiply(priceVal).setScale(0).toString()).append(" Credits");
                    System.out.println(sb.toString());
                    return true;
                } else {
                    System.out.println("I have no idea what you are talking about");
                }
            }
        }
        return false;
    }


    /**
     * 解析how much
     */
    public static boolean howMuchMethod(String word) {
        Matcher matcher = HOW_MUCH_REGEX.matcher(word);
        if (matcher.find()) {
            String left = matcher.group(1);
            String romanLeft = alias2Roman(left);
            // 检验是否罗马文
            int num;
            boolean checkRoman = checkRoman(romanLeft);
            if (checkRoman && (num = roman2Int(romanLeft)) != 0) {
                System.out.println(left + " is " + num);
                return true;
            }
        } else {
            System.out.println("I have no idea what you are talking about");
        }

        return false;
    }


    /**
     * 别名转罗马数字
     */
    private static String alias2Roman(String word) {
        String[] words = word.split("\\s");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : words) {
            String aliasVal = aliasMap.get(str);
            stringBuilder.append(isBank(aliasVal) ? str : aliasVal);

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
        //每两位判断一次取值
        int len = words.length;
        int total = 0;
        for (int i = 0; i < len; i += 2) {
            StringBuilder sb = new StringBuilder();
            int one = 0;
            int two = 0;
            if (i < len) {
                one = romanMap.get(String.valueOf(words[i]));
                sb.append(String.valueOf(words[i]));
            }
            if (i + 1 < len) {
                two = romanMap.get(String.valueOf(words[i + 1]));
                sb.append(String.valueOf(words[i + 1]));
            }
            String rom = sb.toString();
            Integer num = romanMap.get(rom);
            //不存在则相加
            if (num == null) {
                num = one + two;
            }
            total += num;
        }
        return total;
    }

    //判断字符串是否为空
    private static boolean isBank(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String pathname = "input.txt";
        URL resource = NumConvert.class.getResource(pathname);
        try {
            FileReader reader = new FileReader(resource.getPath());
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                //System.out.println(line);
                if (aliasMethod(line)) {
                    continue;
                }
                if (creditMethod(line)) {
                    continue;
                }
                if (howManyMethod(line)) {
                    continue;
                }
                if (howMuchMethod(line)) {
                    continue;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
