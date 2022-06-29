package com.onmyoji;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author zhutongtong
 * @date 2022/6/29 11:11
 */
public class Mouse {

    public static void main(String[] args) {
//        fileReader();
        mouse();
    }

    public static void mouse(){
        try {
            int i = 0;
            String basePath = "C:\\Users\\EDY\\Desktop\\";
            while (i < 100000) {
                Robot robot = new Robot();
                robot.delay(1000);
//                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.delay(1000);
                captureScreen(String.format("C:\\Users\\EDY\\Desktop\\test\\%s.png",i));
                //测 4 119 36 134 0
                robot.mouseMove(62, 67);
//                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                ++i;
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }


    //left, top, right, bottom;
    public static void fileReader()  {
        try {
            BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\EDY\\Desktop\\test\\Snipaste_2022-06-28_17-20-47.box"));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
            System.out.println(str);
        } catch (IOException e) {
        }
    }



    public static void captureScreen(String fileName)  {
        try {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle screenRectangle = new Rectangle(screenSize);
            Robot robot = new Robot();
            BufferedImage image = robot.createScreenCapture(screenRectangle);
            File file = new File(fileName);
            ImageIO.write(image, "png", file);
            System.out.println("A screenshot is captured to: " + file.getPath());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
