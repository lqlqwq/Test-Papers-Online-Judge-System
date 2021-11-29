package com.pro;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.waitKey;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgcodecs.Imgcodecs.imwrite;
import static org.opencv.imgproc.Imgproc.COLOR_RGB2GRAY;
import static org.opencv.imgproc.Imgproc.cvtColor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOpenCv {
    @Test
    public void testOpenCv() throws Exception{
        // 解决awt报错问题
        System.setProperty("java.awt.headless", "false");
        System.out.println(System.getProperty("java.library.path"));
        // 加载动态库
        URL url = ClassLoader.getSystemResource("lib/opencv/opencv_java3415.dll");
        String packagePath = url.getPath().replaceAll("%20","");//解决路径中含有空格的情况
        packagePath = java.net.URLDecoder.decode(packagePath,"utf-8"); //解决路径包含中文的情况
        System.out.println(packagePath);

        System.load(packagePath);
        // 读取图像
        Mat image = imread("D:\\CitrusLily\\Desktop\\SeTu\\Anmi1.jpg");
        if (image.empty()) {
            throw new Exception("image is empty");
        }
        imshow("Original Image", image);

        // 创建输出单通道图像
        Mat grayImage = new Mat(image.rows(), image.cols(), CvType.CV_8SC1);
        // 进行图像色彩空间转换
        cvtColor(image, grayImage, COLOR_RGB2GRAY);

        imshow("Processed Image", grayImage);
        imwrite("D://hello.jpg", grayImage);
        waitKey();
    }
}
