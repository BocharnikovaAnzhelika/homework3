import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GetterFromFile {
    public static String getter(String pathToFile) throws IOException {
        String ans = "";

        FileReader fr = new FileReader(pathToFile);
        Scanner scanner = new Scanner(fr);

        int n = scanner.nextInt();
        scanner.nextLine();
        int k = (int)(Math.random() * 100) % n;
        int i = 0;

        while (scanner.hasNextLine()) {
            String current = scanner.nextLine();
            if (i == k) {
                ans = current;
                System.out.println(current);
                break;
            }
            i++;
        }

        fr.close();

        return ans;
    }

}
