package com.demo;

import com.dong.service.FileProcessor;
import com.dong.service.PhoneProcess;

import java.io.File;
import java.util.List;

public class PhoneTest {

    public static void main(String[] args) throws Exception {
        PhoneProcess phoneProcess = new PhoneProcess();
        File file = new File("C:\\Users\\WangDong\\IdeaProjects\\demo\\phoneParse\\src\\main\\resources\\phone");
        FileProcessor fileProcessor = new FileProcessor();
        List<String> line = fileProcessor.getLineList(file);
        int count = 0;
        for (String tel :
                line) {
         if (!phoneProcess.isUnicom(tel)){
             count++;
             System.out.print(tel + ",");
         }

        }
        System.out.println(count);

    }
}
