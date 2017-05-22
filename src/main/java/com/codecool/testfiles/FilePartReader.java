package com.codecool.testfiles;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        setFilePath("test_data.txt");
        setFromLine(1);
        setToLine(1);
    }

    public String getFilePath() {
        return filePath;
    }

    public Integer getFromLine() {
        return fromLine;
    }

    public Integer getToLine() {
        return toLine;
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
        setFilePath(filePath);
        setFromLine(fromLine);
        setToLine(toLine);
    }

    private String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get(this.getFilePath())));
    }

    public String readLines() {
        try {
            String fileContent = this.read();
            List <String> outputList = new ArrayList<>();
            List<String> contentInList = Arrays.asList(fileContent.split("\n"));
            for (String line : contentInList) {
                if ((contentInList.indexOf(line) >= this.getFromLine()-1)
                    && (contentInList.indexOf(line) <= this.getToLine()-1)) {
                    outputList.add(line);
                }
            }
            return String.join("\n", outputList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    return null;
    }
}
