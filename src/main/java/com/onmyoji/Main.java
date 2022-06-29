package com.onmyoji;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhutongtong
 * @date 2022/6/29 11:08
 */
public class Main {

    public static String identifyTextFromPicture(String tessPath, String sourceFileName, String savePath, String language,String dx) {

        ProcessBuilder pb = new ProcessBuilder();
        pb.directory(new File(tessPath));
        pb.environment().put("TESSDATA_PREFIX", tessPath + File.separatorChar + "tessdata");
        pb.redirectErrorStream(true);

        File sourceFile = new File(sourceFileName);
        List<String> cmd = new ArrayList<String>();
        String ocr_result_filename = sourceFile.getName().substring(0, sourceFile.getName().lastIndexOf("."));
        String path = savePath + File.separatorChar + ocr_result_filename;
        System.out.println("path="+path);
        cmd.add(pb.directory().getAbsolutePath() + File.separatorChar + "tesseract");
        cmd.add(sourceFile.getAbsolutePath());
        cmd.add(path);
        cmd.add("-l");
        cmd.add(language);
        cmd.add(dx);

        pb.command(cmd);
        try {
            Process process = pb.start();
            if (process.waitFor() == 0) {
                return savePath + File.separatorChar + ocr_result_filename + ".txt";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //tesseract C:\Users\EDY\Desktop\test\Snipaste_2022-06-28_17-20-47.png stdout -l chi_sim output makebox
    //识别命令
    public static void main(String[] arags) {
        String resultFile = Main.identifyTextFromPicture("C:/Program Files/Tesseract-OCR"
                , "C:\\Users\\EDY\\Desktop\\test\\Snipaste_2022-06-28_17-20-47.png", "C:\\Users\\EDY\\Desktop\\test", "chi_sim","makebox");
        System.out.println(resultFile);
    }
}
