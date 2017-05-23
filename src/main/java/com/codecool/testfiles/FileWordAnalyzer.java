package com.codecool.testfiles;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        setFilePartReader(filePartReader);
    }

    public void setFilePartReader(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public FilePartReader getFilePartReader() {
        return filePartReader;
    }

    public ArrayList wordsByABC() {
        ArrayList<String> outputList = getContentAsList();
        if (outputList == null) throw new NullPointerException("List of words equals null");
        Collections.sort(outputList);
        return outputList;
    }

    public ArrayList wordsContainingSubString(String subString) {
        if (subString.equals("")) throw new IllegalArgumentException("Substring cannot be empty string");
        ArrayList<String> outputList = new ArrayList<>();
        for(String word : this.getContentAsList()) {
            if (word.contains(subString)) {
                outputList.add(word);
            }
        }
        return outputList;
    }

    public ArrayList wordsArePalindrome() {
        ArrayList<String> outputList = new ArrayList<>();
        for(String word : getContentAsList()) {
            if (this.isPalindrome(word)) {
                outputList.add(word);
            }
        }
        return outputList;
    }

    private boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    private ArrayList<String> getContentAsList() {
        try {
            return new ArrayList<>(Arrays.asList(this.getFilePartReader().readLines().replaceAll("\\n", " ").split(" ")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    return null;
    }

}
