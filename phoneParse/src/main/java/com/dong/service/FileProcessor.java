package com.dong.service;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileProcessor {

    public List getLineList(File file) throws IOException {

        final List<String> lines = FileUtils.readLines(file, Charsets.UTF_8);
        return lines;
    }
}
