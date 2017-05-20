package com.codecool.testfiles;


import java.util.ArrayList;

public class FileWordAnalyzer {
    FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        setFilePartReader(filePartReader);
    }

    public void setFilePartReader(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public ArrayList wordsByABC() { //returns the words ordered by alphabetically as an ArrayList
        filePartReader.readLines();
        return null;
    }

    public ArrayList wordsContainingSubString(String subString) { //returns the words which contains the subString
        filePartReader.readLines();
        return null;
    }
    public ArrayList wordsArePalindrome() { //returns the words from the String which are palindrome
        filePartReader.readLines();
        return null;
    }
}
