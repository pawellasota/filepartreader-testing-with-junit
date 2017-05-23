package com.codecool.testfiles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    private final String filePath = "src/main/resources/data/test_data.txt";
    private FilePartReader filePartReader;

    public void setFilePartReader(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public FilePartReader getFilePartReader() {
        return this.filePartReader;
    }

    public String getFilePath() {
        return this.filePath;
    }

    @BeforeEach
    void beforeEach() {
        setFilePartReader(new FilePartReader());
    }

    @DisplayName("Tests whether calling readLines() before setup() throws a FileNotFoundException")
    @Test
    public void testReadLinesBeforeSetup() {
        assertThrows(FileNotFoundException.class, () -> {
            this.getFilePartReader().readLines();
        });
    }

    @DisplayName("Tests whether calling setup() with fromLine argument less than (LT) 1 throws a IllegalArgumentException")
    @Test
    public void testSetupFromLineLT1() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.getFilePartReader().setup(this.getFilePath(), 0, 1);
        });
    }

    @DisplayName("Tests whether calling setup() with argument toLine less than fromLine throws a IllegalArgumentException")
    @Test
    public void testSetupToLineLTFromLine() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.getFilePartReader().setup(this.getFilePath(), 2, 1);
        });
    }

    @DisplayName("Tests whether readLines() called to read first two lines returns expected string")
    @Test
    public void testReadLines1_2() throws Exception {
        this.getFilePartReader().setup(this.getFilePath(), 1, 2);
        assertEquals("1a1\n2b 2a", this.getFilePartReader().readLines());
    }

    @DisplayName("Tests reading lines from 2 to 4")
    @Test
    public void testReadLines2_4() throws Exception {
        this.getFilePartReader().setup(this.getFilePath(), 2, 4);
        assertEquals("2b 2a\n3c 3b 3a\n4d 4cr 4bb4 4a", this.getFilePartReader().readLines());
    }

    @DisplayName("Tests reading all lines from file")
    @Test
    public void testReadLinesAll() throws Exception {
        this.getFilePartReader().setup(this.getFilePath(), 1, 7);
        assertEquals("1a1\n" +
                "2b 2a\n" +
                "3c 3b 3a\n" +
                "4d 4cr 4bb4 4a\n" +
                "5e 5d 5c 5b 5ax\n" +
                "6f 6ea 6d 6ca 6bb 6a\n" +
                "7g 7f 7ea", this.getFilePartReader().readLines());
    }

    @DisplayName("Test reading when toLine is past End Of File")
    @Test
    public void testReadLinesPastEof() throws Exception {
        this.getFilePartReader().setup(this.getFilePath(), 1, 57);
        assertEquals("1a1\n" +
                "2b 2a\n" +
                "3c 3b 3a\n" +
                "4d 4cr 4bb4 4a\n" +
                "5e 5d 5c 5b 5ax\n" +
                "6f 6ea 6d 6ca 6bb 6a\n" +
                "7g 7f 7ea", this.getFilePartReader().readLines());
    }
}