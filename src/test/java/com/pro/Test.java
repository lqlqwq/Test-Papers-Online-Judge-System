package com.pro;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    public static void main(String[] args) {
        for (int i=0;i<40;i++){
            System.out.println("private int ans"+i+";");
        }
    }
}
