package com.pro.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class KaptchaController {
    @Autowired
    private Producer defaultKaptcha;

    @GetMapping("/verifyCode")
    public void createVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setDateHeader("Expires",0);   //响应立刻过期
        //不缓存图片
        response.setHeader("Cache-Control","no-store,no-cache,must-revalidate");
        response.setHeader("Cache-Control","post-check=0,pre-check=0");
        response.setHeader("Pragma","no-cache");
        response.setContentType("image/png");

        //生成验证码文本
        String verifyCode=defaultKaptcha.createText();
        request.getSession().setAttribute("verifyCode",verifyCode);
        //这里打印出来，一会实验时对比一下，看看是否一致
        System.out.println(request.getSession().getAttribute("verifyCode"));

        //生成的文本转图片
        BufferedImage image=defaultKaptcha.createImage(verifyCode);
        //从服务器到客户端架了一个管道，把图片验证码发送到你的页面中
        ServletOutputStream outputStream =response.getOutputStream();
        //把图通过管道，写到你的客户端
        ImageIO.write(image,"png",outputStream);
        outputStream.flush();
        outputStream.close();
        //io流  什么是流，有哪些流
    }
}
