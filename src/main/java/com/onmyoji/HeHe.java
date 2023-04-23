package com.onmyoji;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;


/**
 * @author zhutongtong
 * @date 2023/4/4 16:04
 */
public class HeHe {

    public static void main(String[] args) throws Exception {
        // 通用文字识别
        String url = "https://api.textin.com/ai/service/v2/recognize";
        // 请登录后前往 “工作台-账号设置-开发者信息” 查看 x-ti-app-id
        // 示例代码中 x-ti-app-id 非真实数据
        String appId = "84b2f12175c34a405c3e316aa2e0226d";
        // 请登录后前往 “工作台-账号设置-开发者信息” 查看 x-ti-secret-code
        // 示例代码中 x-ti-secret-code 非真实数据
        String secretCode = "f6177cfa5104343e2db161f01aae1db1";
        BufferedReader in = null;
        DataOutputStream out = null;
        String result = "";
        try {
            byte[] imgData = readfile("C:\\Users\\EDY\\Desktop\\test\\1.png"); // image
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection)realUrl.openConnection();
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "application/octet-stream");
            conn.setRequestProperty("x-ti-app-id", appId);
            conn.setRequestProperty("x-ti-secret-code", secretCode);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST"); // 设置请求方式
            out = new DataOutputStream(conn.getOutputStream());
            out.write(imgData);
            out.flush();
            out.close();
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //{"code":200,"message":"success","duration":451,"result":{"angle":0,"width":2560,"lines":[{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.814,"position":[122,187,162,187,162,199,122,199],"text":"main"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.9,"position":[487,192,509,192,509,212,487,212],"text":"13"},{"angle":180,"type":"text","direction":0,"handwritten":0,"score":0.75,"position":[584,209,569,209,569,197,584,197],"text":"*"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.826,"position":[147,212,177,212,177,224,147,224],"text":"java"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.963,"position":[487,219,509,219,509,239,487,239],"text":"14"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.918,"position":[122,230,269,234,269,255,122,253],"text":"com.onmyoji"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.935,"position":[487,247,509,247,509,267,487,267],"text":"15"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.847,"position":[559,247,767,247,767,269,559,269],"text":"public class Mouse {"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.933,"position":[167,257,232,257,232,277,167,277],"text":"Main"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.951,"position":[169,282,247,282,247,302,169,302],"text":"Mouse"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.94,"position":[484,274,509,274,509,294,484,294],"text":"16"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.918,"position":[122,307,222,307,222,329,122,329],"text":"resources"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.976,"position":[487,302,537,302,537,322,487,322],"text":"17"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.99,"position":[597,302,922,302,922,324,597,324],"text":"public static void main(String[]"},{"angle":180,"type":"text","direction":0,"handwritten":0,"score":0.843,"position":[567,324,542,324,542,302,567,302],"text":"白"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.811,"position":[77,332,157,332,157,352,77,352],"text":">test"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.988,"position":[484,329,509,329,509,349,484,349],"text":"18"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.578,"position":[559,327,584,327,584,352,559,352],"text":"11"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.984,"position":[657,327,794,327,794,352,657,352],"text":"fileReader();"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.856,"position":[54,357,152,357,152,377,54,377],"text":">target"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.976,"position":[484,357,509,357,509,377,484,377],"text":"19"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.995,"position":[637,357,724,357,724,379,637,379],"text":"mouse();"},{"angle":0,"type":"text","direction":2,"handwritten":1,"score":0.607,"position":[1449,327,1509,327,1509,444,1449,444],"text":"巫女大"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.859,"position":[79,382,179,382,179,407,79,407],"text":"fo.gitignore"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.979,"position":[484,382,512,382,512,404,484,404],"text":"20"},{"angle":0,"type":"text","direction":0,"handwritten":0,"score":0.843,"position":[544,382,567,382,567,407,544,407],"text":"白"},{"angle":0,"type":"text","direction":0,"handwritten":0,"score":0.978,"position":[597,382,617,382,617,407,597,407],"text":"}"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.978,"position":[1254,382,1312,382,1312,407,1254,407],"text":"玖层"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.947,"position":[78,409,172,407,172,428,77,430],"text":"m pom.xml"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.986,"position":[484,412,512,412,512,432,484,432],"text":"21"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.982,"position":[77,432,197,432,197,454,77,454],"text":"MREADME.md"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.99,"position":[484,439,512,439,512,459,484,459],"text":"22"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.997,"position":[597,437,877,437,877,462,597,462],"text":"public static void mouse(){"},{"angle":180,"type":"text","direction":0,"handwritten":0,"score":0.793,"position":[567,462,544,462,544,439,567,439],"text":"白"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.932,"position":[32,457,209,457,209,479,32,479],"text":">Illi External Libraries"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.981,"position":[484,464,512,464,512,487,484,487],"text":"23"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.963,"position":[637,467,697,467,697,489,637,489],"text":"try {"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.911,"position":[1254,464,1312,464,1312,489,1254,489],"text":"拾层"},{"angle":180,"type":"text","direction":0,"handwritten":0,"score":0.734,"position":[564,489,544,489,544,467,564,467],"text":"白"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.967,"position":[32,482,257,482,257,504,32,504],"text":">Scratches and Consoles"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.991,"position":[484,492,512,492,512,514,484,514],"text":"24"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.957,"position":[679,494,782,494,782,517,679,517],"text":"int i=0;"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.989,"position":[484,522,512,522,512,542,484,542],"text":"25"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.991,"position":[677,522,837,522,837,544,677,544],"text":"String basePath"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.865,"position":[834,519,922,519,922,544,834,544],"text":"=\"C:\\\\U"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.994,"position":[484,547,509,547,509,569,484,569],"text":"26"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.961,"position":[677,547,887,547,887,572,677,572],"text":"while(i<100000) {"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.947,"position":[1257,544,1312,544,1312,572,1257,572],"text":"悲鸣"},{"angle":180,"type":"text","direction":0,"handwritten":0,"score":0.754,"position":[567,572,544,572,544,549,567,549],"text":"白"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.987,"position":[484,577,509,577,509,597,484,597],"text":"27"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.978,"position":[717,577,924,577,924,599,717,599],"text":"Robot robot = new Ro"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.992,"position":[484,602,509,602,509,624,484,624],"text":"28"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.974,"position":[717,604,927,602,927,625,717,628],"text":"robot.delay( ms:1000"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.988,"position":[484,632,509,632,509,652,484,652],"text":"29"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.682,"position":[559,629,584,629,584,654,559,654],"text":"11"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.99,"position":[737,632,927,632,927,654,737,654],"text":"robot.mousePress(I"},{"angle":0,"type":"text","direction":0,"handwritten":0,"score":0.934,"position":[1092,629,1114,629,1114,649,1092,649],"text":"永"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.948,"position":[1254,627,1312,627,1312,654,1254,654],"text":"神罚"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.986,"position":[1457,629,1647,629,1647,657,1457,657],"text":"阵容自动挑战"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.984,"position":[484,657,509,657,509,679,484,679],"text":"30"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.994,"position":[717,657,927,657,927,679,717,679],"text":"robot.delay( ms:1000"},{"angle":0,"type":"text","direction":0,"handwritten":0,"score":0.358,"position":[1089,658,1102,645,1114,658,1102,670],"text":"*"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.991,"position":[1882,667,1937,667,1937,694,1882,694],"text":"挑战"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.801,"position":[1754,677,1807,677,1807,699,1754,699],"text":"组队"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.992,"position":[484,687,509,687,509,707,484,707],"text":"31"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.996,"position":[717,687,927,687,927,709,717,709],"text":"captureScreen(String"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.807,"position":[1889,692,1934,692,1934,714,1889,714],"text":"12"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.993,"position":[484,712,512,711,512,734,484,734],"text":"32"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.964,"position":[719,712,912,712,912,737,719,737],"text":"／／测 4 119 36 134 0"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.987,"position":[484,739,512,739,512,762,484,762],"text":"33"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.979,"position":[719,742,944,742,944,764,719,764],"text":"robot.mouseMove( x: 62,"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.895,"position":[954,744,1024,744,1024,764,954,764],"text":"y:67);"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.993,"position":[484,767,512,767,512,788,484,789],"text":"34"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.633,"position":[559,767,584,767,584,792,559,792],"text":"11"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.897,"position":[737,769,1179,765,1179,790,737,793],"text":"robot.mouseRelease(InputEvent.BUTT0N1_MASK);"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.993,"position":[484,794,512,793,512,816,484,817],"text":"35"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.967,"position":[719,797,764,797,764,819,719,819],"text":"++1;"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.992,"position":[484,822,509,822,509,844,484,844],"text":"36"},{"angle":0,"type":"text","direction":0,"handwritten":0,"score":0.88,"position":[544,822,567,822,567,844,544,844],"text":"白"},{"angle":0,"type":"text","direction":0,"handwritten":0,"score":0.925,"position":[679,824,692,824,692,844,679,844],"text":"}"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.979,"position":[484,849,512,848,512,872,484,872],"text":"37"},{"angle":0,"type":"text","direction":0,"handwritten":0,"score":0.833,"position":[637,849,657,849,657,874,637,874],"text":"}"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.969,"position":[654,849,907,849,907,874,654,874],"text":"catch (AWTException e) {"},{"angle":180,"type":"text","direction":0,"handwritten":0,"score":0.735,"position":[564,874,544,874,544,852,564,852],"text":"白"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.871,"position":[87,884,189,887,189,909,87,905],"text":".Mouse x"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.991,"position":[109,914,634,914,634,939,109,939],"text":"\"C:\\Program Files\\Java\\jdk1.8.0_40\\bin\\java.exe\" ..."},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.993,"position":[107,942,714,942,714,967,107,967],"text":"A screenshot is captured to: C:\\Users\\EDY\\Desktop\\test\\0.png"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.899,"position":[2102,1242,2222,1242,2222,1267,2102,1267],"text":"M IntelliJ IDEA"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.993,"position":[2194,1282,2402,1282,2402,1309,2194,1309],"text":"Compilation Finished"},{"angle":0,"type":"text","direction":1,"handwritten":0,"score":0.953,"position":[2194,1307,2384,1309,2385,1337,2194,1333],"text":"O Errors, 0Warnings"},{"angle":0,"type":"text","direction":2,"handwritten":0,"score":0.845,"position":[1093,435,1115,435,1115,498,1093,498],"text":"业原火"},{"angle":0,"type":"text","direction":2,"handwritten":0,"score":0.928,"position":[1093,538,1115,538,1115,603,1093,603],"text":"卑弥呼"},{"angle":270,"type":"text","direction":1,"handwritten":0,"score":0.829,"position":[10,350,10,268,23,268,23,350],"text":"Pull Requests"}],"height":1440},"version":"v2.0.0"}
        System.out.println(result);
    }

    public static byte[] readfile(String path)
    {
        String imgFile = path;
        InputStream in = null;
        byte[] data = null;
        try
        {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
