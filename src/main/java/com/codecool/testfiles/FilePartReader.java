package com.codecool.testfiles;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        setFilePath("data/test_data.txt");
        setFromLine(1);
        setToLine(1);
    }

    public String getFilePath() {
        return this.filePath;
    }

    public Integer getFromLine() {
        return this.fromLine;
    }

    public Integer getToLine() {
        return this.toLine;
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
        if (fromLine < 1) throw new IllegalArgumentException("Start line cannot be smaller than 1");
        if (toLine < fromLine) throw new IllegalArgumentException("Start line cannot be smaller than endline");
        setFilePath(filePath);
        setFromLine(fromLine);
        setToLine(toLine);
    }

    private String read() throws IOException {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(this.getFilePath()))) {
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if (line.equals("")) continue;
                sb.append(line).append("\n");
            }
            return sb.toString();
        }
    }

    public String readLines() throws FileNotFoundException{
        try {
            String fileContent = this.read();
            List <String> outputList = new ArrayList<>();
            List<String> contentInList = Arrays.asList(fileContent.split("\n"));
            for (String line : contentInList) {
                if ((contentInList.indexOf(line) >= this.getFromLine()-1)
                    && (contentInList.indexOf(line) <= this.getToLine()-1)) {
                    outputList.add(line+"\n");
                }
            }
            String output = String.join("", outputList);
            return output.substring(0, output.length()-1);
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    return null;
    }
}
