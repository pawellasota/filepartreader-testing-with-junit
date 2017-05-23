import com.codecool.testfiles.FilePartReader;
import com.codecool.testfiles.FileWordAnalyzer;

public class Main {
    public static void main(String[] args) {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("src/main/resources/data/test_data.txt", 1, 7);

        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("abc\n");
        for (Object item : fileWordAnalyzer.wordsByABC()) {
            System.out.print(item+" ");
        }
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("substring\n");
        for (Object item : fileWordAnalyzer.wordsContainingSubString("a")) {
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