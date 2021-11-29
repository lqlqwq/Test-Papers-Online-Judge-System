package com.pro.opencv;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.*;

import static org.opencv.core.CvType.CV_8U;
import static org.opencv.imgproc.Imgproc.MORPH_RECT;

public class OpenCV {
    static {
        try {
            InputStream in = null;
            File fileOut = null;
            in = new FileInputStream("C:\\BisheIMG\\opencv_java3415.dll");
            fileOut = File.createTempFile("lib", ".dll");
            OutputStream out = FileUtils.openOutputStream(fileOut);
            IOUtils.copy(in, out);
            in.close();
            out.close();
            System.load(fileOut.toString());
            //System.out.println("--------------0-----------------");
        }catch (Exception e){
            System.out.println("OpenCV的dll导入出现问题");
        }
    }

    public static Map openCV(String url) {
        //String sheet = "C://BisheIMG//A4.jpg";
        //System.out.println("--------------1-----------------");
        //String msg = rowsAndCols(sheet, results);
        Map map=Canny(url,50);
        //System.out.println(map.get(1));
        return map;
    }

    public static Map Canny(String oriImg,int threshold) {
        //装载图片
        //System.out.println("--------------2-----------------");
        Mat img = Imgcodecs.imread(oriImg);          //Mat是OpenCV存储对象单元 Mat类由两部分数据组成：矩阵头(包含矩阵尺寸、存储方法、存储地址等)和一个指向存储所有像素值的矩阵(根据所选存储方法的不同，
        Mat srcImage2 = new Mat();                  //矩阵可以是不同的维数)的指针。Mat在进行赋值和拷贝时，只复制矩阵头，而不复制矩阵，提高效率。如果矩阵属于多个Mat对象，则通过引用计数来判断，当最后一个使用它的对象，则负责释放矩阵。
        Mat srcImage3 = new Mat();
        Mat srcImage4 = new Mat();
        Mat srcImage5 = new Mat();

        //图片变成灰度图片
        Imgproc.cvtColor(img, srcImage2, Imgproc.COLOR_RGB2GRAY);
        //Imgcodecs.imwrite("D://huidu.jpg", srcImage2);
        //图片二值化
        Imgproc.adaptiveThreshold(srcImage2, srcImage3, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY_INV, 255, 1);  //指定一个阈值量即像素的灰度值，遍历图像中像素值，大于这个阈值的像素均设置为0
        //Imgcodecs.imwrite("D://erzhihua.jpg", srcImage3);
        //确定腐蚀和膨胀核的大小
        Mat element = Imgproc.getStructuringElement(MORPH_RECT, new Size(1, 6));
        //腐蚀操作 腐蚀用来处理毛刺问题 把毛刺给腐蚀掉了 求局部最小值
        Imgproc.erode(srcImage3, srcImage4, element);
        //Imgcodecs.imwrite("D://fushi.jpg", srcImage4);
        //膨胀操作 膨胀用来处理缺陷问题 把缺陷给填补了 求局部最大值
        Imgproc.dilate(srcImage4, srcImage5, element);
        //Imgcodecs.imwrite("D://pengzhang.jpg", srcImage5);

        //确定每张答题卡的ROI区域
        Mat imag_ch1 = srcImage5.submat(new Rect(200, 1065, 1930, 2210));   //标准A4纸大小对应的答题区域大小

        //识别所有轮廓
        Vector<MatOfPoint> chapter1 = new Vector<>();
        Imgproc.findContours(imag_ch1, chapter1, new Mat(), 2, 3);     //其中像素点的非0灰度值被当成1(转化后即为255)，0值保持0，所以输入图像被当成一个二值图像对待
        //Imgcodecs.imwrite("D://result1.jpg", imag_ch1);
        Mat result = new Mat(imag_ch1.size(), CV_8U, new Scalar(255));    //8U代表无符号字符型，0~255，默认205
        Imgproc.drawContours(result, chapter1, -1, new Scalar(0), 2);

        //Imgcodecs.imwrite("D://result2.jpg", result);

//        String msg = "";
//        msg += "\n行数:" + result.rows();
//        msg += "\n列数:" + result.cols();
//        msg += "\nheight:" + result.height();
//        msg += "\nwidth:" + result.width();
//        msg += "\nelemSide:" + result.elemSize();
//        System.out.println(msg);



        //new一个 矩形集合 用来装 轮廓
        List<RectComp> RectCompList = new ArrayList<>();
        for (int i = 0; i < chapter1.size(); i++) {
            Rect rm = Imgproc.boundingRect(chapter1.get(i));
            RectComp ti = new RectComp(rm);
            //把轮廓宽度区间在 60 - 85 范围内的轮廓装进矩形集合
            if (ti.rm.width > 60 && ti.rm.width < 85) {
                RectCompList.add(ti);
            }
        }

        //new一个 map 用来存储答题卡上填的答案 (A\B\C\D)
        TreeMap<Integer, String> listenAnswer = new TreeMap<>();     //treemap是集合不是数组
        //按 X轴 对listenAnswer进行排序
        RectCompList.sort((o1, o2) -> {
            if (o1.rm.x > o2.rm.x) {
                return 1;
            }
            if (o1.rm.x == o2.rm.x) {
                return 0;
            }
            if (o1.rm.x < o2.rm.x) {
                return -1;
            }
            return -1;
        });

            /*
            如果精度高，可以通过像素计算
          for (RectComp rc : RectCompList) {
            int x = RectCompList.get(t).getRm().x - 16;
            int y = RectCompList.get(t).getRm().y - 94;
            //计算x轴上的分割 如果超过5题，那么还会有一个大分割
            int xSplit = x/85 /5;
            //因为第一题 x=21 计算机中题目从0开始算，现实是从1开始 所以+1
            int xTitleNum = x/85 + 1;
            //由于精度问题  x轴会慢慢递减  递减到上一个答案去 如果不跨过两个答案以上，都没问题  如果答题卡x轴40题左右 会出问题
            if(x%85>20){
                System.out.println("x轴递减程度" + x%85);
                xTitleNum++;
            }
            xTitleNum = xTitleNum - xSplit;
            System.out.println(xTitleNum);
            }
            */


        //根据 Y轴 确定被选择答案 (A\B\C\D)
        for (RectComp rc : RectCompList) {

            for (int h = 0; h < 7; h++) {
                if ((rc.rm.contains(new Point(rc.rm.x + 20, 115 + (320 * h))))) {
                    for (int w = 0; w < 4; w++) {
                        if (rc.rm.contains(new Point(55 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(1 + (20 * h) + (5 * w), "A");
                        } else if (rc.rm.contains(new Point(135 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(2 + (20 * h) + (5 * w), "A");
                        } else if (rc.rm.contains(new Point(215 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(3 + (20 * h) + (5 * w), "A");
                        } else if (rc.rm.contains(new Point(300 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(4 + (20 * h) + (5 * w), "A");
                        } else if (rc.rm.contains(new Point(380 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(5 + (20 * h) + (5 * w), "A");
                        }
                    }
                }
                else if ((rc.rm.contains(new Point(rc.rm.x + 20, 165 + (320 * h))))) {
                    for (int w = 0; w < 4; w++) {
                        if (rc.rm.contains(new Point(55 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(1 + (20 * h) + (5 * w), "B");
                        } else if (rc.rm.contains(new Point(135 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(2 + (20 * h) + (5 * w), "B");
                        } else if (rc.rm.contains(new Point(215 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(3 + (20 * h) + (5 * w), "B");
                        } else if (rc.rm.contains(new Point(300 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(4 + (20 * h) + (5 * w), "B");
                        } else if (rc.rm.contains(new Point(380 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(5 + (20 * h) + (5 * w), "B");
                        }
                    }
                }
                else if ((rc.rm.contains(new Point(rc.rm.x + 20, 220 + (320 * h))))) {
                    for (int w = 0; w < 4; w++) {
                        if (rc.rm.contains(new Point(55 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(1 + (20 * h) + (5 * w), "C");
                        } else if (rc.rm.contains(new Point(135 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(2 + (20 * h) + (5 * w), "C");
                        } else if (rc.rm.contains(new Point(215 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(3 + (20 * h) + (5 * w), "C");
                        } else if (rc.rm.contains(new Point(300 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(4 + (20 * h) + (5 * w), "C");
                        } else if (rc.rm.contains(new Point(380 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(5 + (20 * h) + (5 * w), "C");
                        }
                    }
                }
                else if ((rc.rm.contains(new Point(rc.rm.x + 20, 275 + (320 * h))))) {
                    for (int w = 0; w < 4; w++) {
                        if (rc.rm.contains(new Point(55 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(1 + (20 * h) + (5 * w), "D");
                        } else if (rc.rm.contains(new Point(135 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(2 + (20 * h) + (5 * w), "D");
                        } else if (rc.rm.contains(new Point(215 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(3 + (20 * h) + (5 * w), "D");
                        } else if (rc.rm.contains(new Point(300 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(4 + (20 * h) + (5 * w), "D");
                        } else if (rc.rm.contains(new Point(380 + (500 * w), rc.rm.y))) {
                            listenAnswer.put(5 + (20 * h) + (5 * w), "D");
                        }
                    }
                }
            }
        }

        Iterator iter = listenAnswer.entrySet().iterator();
        Map map=new HashMap();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            map.put(key,val);
            //System.out.println("第" + key + "题,分数:" + val);
        }
        return map;
    }
//    private static void loadLibrary() {
//        try {
//            InputStream in = null;
//            File fileOut = null;
//            String osName = System.getProperty("os.name");
//            Utils.out.println(Main.class, osName);
//            if(osName.startsWith("Windows")){
//                int bitness = Integer.parseInt(System.getProperty("sun.arch.data.model"));
//                if(bitness == 32){
//                    Utils.out.println(Main.class, "32 bit detected");
//                    in = Main.class.getResourceAsStream("/opencv/x86/opencv_java245.dll");
//                    fileOut = File.createTempFile("lib", ".dll");
//                }
//                else if (bitness == 64){
//                    Utils.out.println(Main.class, "64 bit detected");
//                    in = Main.class.getResourceAsStream("/opencv/x64/opencv_java245.dll");
//                    fileOut = File.createTempFile("lib", ".dll");
//                }
//                else{
//                    Utils.out.println(Main.class, "Unknown bit detected - trying with 32 bit");
//                    in = Main.class.getResourceAsStream("/opencv/x86/opencv_java245.dll");
//                    fileOut = File.createTempFile("lib", ".dll");
//                }
//            }
//            else if(osName.equals("Mac OS X")){
//                in = Main.class.getResourceAsStream("/opencv/mac/libopencv_java245.dylib");
//                fileOut = File.createTempFile("lib", ".dylib");
//            }
//
//
//            OutputStream out = FileUtils.openOutputStream(fileOut);
//            IOUtils.copy(in, out);
//            in.close();
//            out.close();
//            System.load(fileOut.toString());
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to load opencv native library", e);
//        }
    }
