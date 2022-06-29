package com.onmyoji;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author zhutongtong
 * @date 2022/6/29 11:11
 */
public class Mouse {

    public static void main(String[] args) {
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
//                robot.mouseMove(100, 200);
//                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                ++i;
            }
        } catch (AWTException e) {
            e.printStackTrace();
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
