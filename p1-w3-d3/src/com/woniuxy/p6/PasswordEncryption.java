package com.woniuxy.p6;

public class PasswordEncryption {
    public static void main(String[] args) {
        int originalPassword = 1983; // 原始密码
        int encryptedPassword = encrypt(originalPassword);
        System.out.println("加密后的密码：" + encryptedPassword);

        int decryptedPassword = decrypt(encryptedPassword);
        System.out.println("解密后的密码：" + decryptedPassword);
    }

    // 加密方法
    public static int encrypt(int password) {
        int encryptedPassword = 0;
        for (int i = 0; i < 4; i++) {
            int digit = (password % 10 + 5) % 10;
            encryptedPassword = encryptedPassword * 10 + digit;
            password /= 10;
        }
        return encryptedPassword;
    }

    // 解密方法
    public static int decrypt(int encryptedPassword) {
        int decryptedPassword = 0;
        for (int i = 0; i < 4; i++) {
            int digit = (encryptedPassword % 10 + 10 - 5) % 10;
            decryptedPassword = decryptedPassword * 10 + digit;
            encryptedPassword /= 10;
        }
        return decryptedPassword;
    }
}

