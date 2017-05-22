import com.codecool.testfiles.FilePartReader;
import com.codecool.testfiles.FileWordAnalyzer;

public class Main {
    public static void main(String[] args) {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("src/main/java/test_data.txt", 1, 2);

        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("abc\n");
        for (String item : fileWordAnalyzer.wordsByABC()) {
            System.out.println(item);
        }
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("substring\n");
        for (Object item : fileWordAnalyzer.wordsContainingSubString("4b")) {
            System.out.println(item);
        }
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("palindrome\n");
        for (Object item : fileWordAnalyzer.wordsArePalindrome()) {
            System.out.println(item);
        }
        System.out.println("---------------------------------------------------------------------------------");
    }
}