package com.codecool.testfiles;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;


class FileWordAnalyzerTest {

    private String filePath = "src/main/resources/data/test_data.txt";
    private FilePartReader filePartReader;
    private FileWordAnalyzer fileWordAnalyzer;

    public void setFilePartReader(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public FilePartReader getFilePartReader() {
        return this.filePartReader;
    }

    public void setFileWordAnalyzer(FileWordAnalyzer fileWordAnalyzer) {
        this.fileWordAnalyzer = fileWordAnalyzer;
    }

    public FileWordAnalyzer getFileWordAnalyzer() {
        return this.fileWordAnalyzer;
    }

    public String getFilePath() {
        return this.filePath;
    }

    @BeforeEach
    void beforeEach() {
        setFilePartReader(new FilePartReader());
        this.getFilePartReader().setup(this.getFilePath(), 1, 7);
        setFileWordAnalyzer(new FileWordAnalyzer(this.getFilePartReader()));
    }

    @DisplayName("Tests whether calling wordsByABC() with 2 first lines returns expected string")
    @Test
    void testWordsByABC1_2() {
        this.getFilePartReader().setup(this.getFilePath(), 1, 2);
        assertEquals(new ArrayList<>(Arrays.asList("1a1", "2a", "2b")), this.getFileWordAnalyzer().wordsByABC());
    }

    @DisplayName("Tests whether calling wordsByABC() with lines: from 4 to 6 returns expected string")
    @Test
    void testWordsByABC4_6() {
        this.getFilePartReader().setup(this.getFilePath(), 4, 6);
        assertEquals(new ArrayList<>(Arrays.asList("4a", "4bb4", "4cr", "4d", "5ax", "5b", "5c",
                "5d", "5e", "6a", "6bb", "6ca", "6d", "6ea", "6f")), this.getFileWordAnalyzer().wordsByABC());
    }

    @DisplayName("Tests whether calling wordsByABC() with all lines returns expected string")
    @Test
    void testWordsByABCAll() {
        this.getFilePartReader().setup(this.getFilePath(), 1, 7);
        assertEquals(new ArrayList<>(Arrays.asList("1a1", "2a", "2b", "3a", "3b", "3c", "4a", "4bb4", "4cr",
                "4d", "5ax", "5b", "5c", "5d", "5e", "6a", "6bb", "6ca", "6d", "6ea", "6f", "7ea", "7f", "7g")),
                this.getFileWordAnalyzer().wordsByABC());
    }

    @DisplayName("Tests whether calling wordsContainingSubString() method with 3 different substrings input returns expected string")
    @Test
    void testWordsContainingSubString() {
        assertAll("Should return ArrayList with strings containing given substring",
                () -> assertEquals(new ArrayList<>(Arrays.asList("6ca")), this.getFileWordAnalyzer().wordsContainingSubString("ca")),
                () -> assertEquals(new ArrayList<>(Arrays.asList("1a1", "2a", "3a", "4a", "5ax", "6ea", "6ca", "6a", "7ea")),
                        this.getFileWordAnalyzer().wordsContainingSubString("a")),
                () -> assertEquals(new ArrayList<>(Arrays.asList("5ax")), this.getFileWordAnalyzer().wordsContainingSubString("ax"))
        );
    }

    @DisplayName("Tests whether calling wordsContainingSubString() method with empty string as input throws IllegalArgumentException")
    @Test
    public void testWordsContainingSubStringEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.getFileWordAnalyzer().wordsContainingSubString("");
        });
    }

    @DisplayName("Tests whether calling wordsArePalindrome() method returns expected string")
    @Test
    void testWordsArePalindrome() {
          assertEquals(new ArrayList<>(Arrays.asList("1a1", "4bb4")), this.getFileWordAnalyzer().wordsArePalindrome());
    }
}