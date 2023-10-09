package com.woniuxy.p6;

import java.util.Random;

public class RandomVerificationCodeGenerator {
    public static void main(String[] args) {
        int codeLength = 6; // 指定验证码长度
        String verificationCode = generateVerificationCode(codeLength);
        System.out.println("生成的验证码：" + verificationCode);
    }

    public static String generateVerificationCode(int length) {
        StringBuilder code = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int codeType = random.nextInt(3); // 生成0、1、2，代表数字、大写字母、小写字母

            char randomChar;
            switch (codeType) {
                case 0:
                    randomChar = (char) (random.nextInt(10) + '0'); // 数字
                    break;
                case 1:
                    randomChar = (char) (random.nextInt(26) + 'A'); // 大写字母
                    break;
                case 2:
                    randomChar = (char) (random.nextInt(26) + 'a'); // 小写字母
                    break;
                default:
                    throw new IllegalStateException("Unexpected codeType: " + codeType);
            }

            code.append(randomChar);
        }

        return code.toString();
    }
}

