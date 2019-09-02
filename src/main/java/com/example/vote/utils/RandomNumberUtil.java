package com.example.vote.utils;


import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

/**
 * 生成UUID的工具类
 * Created by wyk on 2018/05/31
 */
public class RandomNumberUtil {

    /**
     * 创建32位的UUID
     *
     * @return
     */
    public static String creatUUID32() {
        String uuid = UUID.randomUUID().toString();
        //因为UUID本身为32位只是生成时多了“-”，所以将它们去点就可
        uuid = uuid.replace("-", "");
        return uuid;
    }

    /**
     * 生成随机的N位数
     *
     * @param n
     * @return
     */
    public static Long generateRandomNumber(int n) {

        Assert.isTrue(n >= 1, "随机数位数必须大于0");
        return (long) (Math.random() * 9 * Math.pow(10, n - 1)) + (long) Math.pow(10, n - 1);
    }

    /**
     * 密码类型枚举
     * @author ASUS
     */
    public enum TYPE {
        /**
         * 字符型
         */
        LETTER,
        /**
         * 大写字符型
         */
        CAPITAL,
        /**
         * 数字型
         */
        NUMBER,
        /**
         * 符号型
         */
        SIGN,
        /**
         * 大+小字符 型
         */
        LETTER_CAPITAL,
        /**
         * 小字符+数字 型
         */
        LETTER_NUMBER,
        /**
         * 大+小字符+数字 型
         */
        LETTER_CAPITAL_NUMBER,
        /**
         * 大+小字符+数字+符号 型
         */
        LETTER_CAPITAL_NUMBER_SIGN
    }

    private static String[] lowercase = {
            "a","b","c","d","e","f","g","h","i","j","k",
            "l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    private static String[] capital = {
            "A","B","C","D","E","F","G","H","I","J","K",
            "L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    private static String[] number = {
            "1","2","3","4","5","6","7","8","9","0"};

    private static String[] sign = {
            "~","!","@","#","$","%","^","&","*","(",")","_","+","`","-","=",
            "{","}","|",":","\"","<",">","?",
            "[","]","\\",";","'",",",".","/"};

    /**
     * 静态随机数
     */
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println(RandomNumberUtil.getRandom(24, RandomNumberUtil.TYPE.LETTER_CAPITAL_NUMBER));
    }

    /**
     * 获取随机组合码
     * @param num 位数
     * @param type 类型
     * @type
     * <br>字符型 LETTER,
     * <br>大写字符型 CAPITAL,
     * <br>数字型 NUMBER,
     * <br>符号型 SIGN,
     * <br>大+小字符型 LETTER_CAPITAL,
     * <br>小字符+数字 型 LETTER_NUMBER,
     * <br>大+小字符+数字 型 LETTER_CAPITAL_NUMBER,
     * <br>大+小字符+数字+符号 型 LETTER_CAPITAL_NUMBER_SIGN
     */
    public static String getRandom(int num,TYPE type) {
        ArrayList<String> temp = new ArrayList<String>();
        StringBuilder code = new StringBuilder();
        if (type == TYPE.LETTER) {
            temp.addAll(Arrays.asList(lowercase));
        } else if (type == TYPE.CAPITAL) {
            temp.addAll(Arrays.asList(capital));
        } else if (type == TYPE.NUMBER) {
            temp.addAll(Arrays.asList(number));
        } else if (type == TYPE.SIGN) {
            temp.addAll(Arrays.asList(sign));
        } else if (type == TYPE.LETTER_CAPITAL) {
            temp.addAll(Arrays.asList(lowercase));
            temp.addAll(Arrays.asList(capital));
        } else if (type == TYPE.LETTER_NUMBER) {
            temp.addAll(Arrays.asList(lowercase));
            temp.addAll(Arrays.asList(number));
        } else if (type == TYPE.LETTER_CAPITAL_NUMBER) {
            temp.addAll(Arrays.asList(lowercase));
            temp.addAll(Arrays.asList(capital));
            temp.addAll(Arrays.asList(number));
        } else if (type == TYPE.LETTER_CAPITAL_NUMBER_SIGN) {
            temp.addAll(Arrays.asList(lowercase));
            temp.addAll(Arrays.asList(capital));
            temp.addAll(Arrays.asList(number));
            temp.addAll(Arrays.asList(sign));
        }
        for (int i = 0; i < num; i++) {
            code.append(temp.get(random.nextInt(temp.size())));
        }
        return code.toString();


    }
}
