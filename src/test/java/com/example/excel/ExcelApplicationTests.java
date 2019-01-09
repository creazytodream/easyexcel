package com.example.excel;

import com.example.excel.excel.QRCodeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void testQrCode() {
        String text = "hello world!"; // 随机生成验证码
        System.out.println("随机码： " + text);
        int width = 100; // 二维码图片的宽
        int height = 100; // 二维码图片的高
        String format = "png"; // 二维码图片的格式

        try {
            // 生成二维码图片，并返回图片路径
            String pathName = QRCodeUtil.generateQRCode(text, width, height, format, "/Users/yumingbin/Pictures/qrcode.png");
            System.out.println("生成二维码的图片路径： " + pathName);

            String content = QRCodeUtil.parseQRCode(pathName);
            System.out.println("解析出二维码的图片的内容为： " + content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

