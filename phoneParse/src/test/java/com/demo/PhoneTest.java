package com.demo;

import com.dong.service.FileProcessor;
import com.dong.service.PhoneProcess;

import java.io.File;

public class PhoneTest {

    public static void main(String[] args) throws Exception {
        PhoneProcess phoneProcess = new PhoneProcess();
        File file = new File("phone");
        FileProcessor fileProcessor = new FileProcessor();
        System.out.println(phoneProcess.isLianTong("18613208491"));
    }
}
