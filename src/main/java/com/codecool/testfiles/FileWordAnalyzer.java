package com.codecool.testfiles;


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

    public ArrayList<String> wordsByABC() { //returns the words ordered by alphabetically as an ArrayList
        ArrayList<String> outputList = getContentAsList();
        Collections.sort(outputList);
        return outputList;
    }

    public ArrayList wordsContainingSubString(String subString) { //returns the words which contains the subString
        ArrayList<String> outputList = new ArrayList<>();
        for(String word : this.getContentAsList()) {
            if (word.contains(subString)) {
                outputList.add(word);
            }
        }
        return outputList;
    }

    public ArrayList wordsArePalindrome() { //returns the words from the String which are palindrome
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
        return new ArrayList<>(Arrays.asList(filePartReader.readLines().replaceAll("\\r\\n", " ").split(" ")));
    }

}
