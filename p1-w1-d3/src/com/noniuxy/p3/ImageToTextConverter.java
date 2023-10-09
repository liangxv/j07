package com.noniuxy.p3;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ImageToTextConverter {
    public static void main(String[] args) {
        try {
            // 读取图像文件
            BufferedImage image = ImageIO.read(new File("E:\\Users\\kotori\\Downloads\\2.jpg"));

            // 定义字符集合，包含更多字符
            String charset = " `.^,:~\"<!ct+{i7?u30pw4A8DX%#HW"; // 减小字符集合以降低精度

            // 图像的宽度和高度
            int width = image.getWidth();
            int height = image.getHeight();

            // 定义字符图像的宽度和高度，保持与原始图像的宽高比一致
            int charWidth = 2; // 每个字符代表4个像素宽度
            int charHeight = 5; // 每个字符代表8个像素高度

            // 创建一个输出文本文件
            FileWriter fileWriter = new FileWriter("E:\\Users\\kotori\\Downloads\\out.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // 计算需要循环的行数和列数
            int numRows = height / charHeight;
            int numCols = width / charWidth;

            // 循环遍历图像像素并生成字符图像
            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numCols; col++) {
                    int totalGray = 0;
                    int count = 0;
                    for (int y = row * charHeight; y < (row + 1) * charHeight; y++) {
                        for (int x = col * charWidth; x < (col + 1) * charWidth; x++) {
                            int pixel = image.getRGB(x, y);
                            int gray = (int) (0.299 * ((pixel >> 16) & 0xFF) + 0.587 * ((pixel >> 8) & 0xFF) + 0.114 * (pixel & 0xFF));
                            totalGray += gray;
                            count++;
                        }
                    }
                    int averageGray = totalGray / count;
                    int index = (int) (averageGray / 255.0 * (charset.length() - 1));
                    printWriter.print(charset.charAt(index));
                }
                printWriter.println(); // 在每行结束后换行
            }

            // 关闭输出文件
            printWriter.close();
            fileWriter.close();

            System.out.println("字符图像已保存到out.txt文件。");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
