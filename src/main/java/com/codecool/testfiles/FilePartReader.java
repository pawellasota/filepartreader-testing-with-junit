package com.codecool.testfiles;


import java.io.IOException;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        setFilePath("test_data.txt");
        setFromLine(1);
        setToLine(2);
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setFromLine(Integer fromLine) {
        this.fromLine = fromLine;
    }

    public void setToLine(Integer toLine) {
        this.toLine = toLine;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (fromLine < 1) throw  new IllegalArgumentException("Start line cannot be smaller than 1");
        if (toLine < fromLine) throw new IllegalArgumentException("Start line cannot be smaller than endline");

    }

    private String read() throws IOException {
        return null;
    }

    public String readLines() {
        return null;
    }
}
