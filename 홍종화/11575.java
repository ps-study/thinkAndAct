import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    final static String ENTER = "\n";

    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = atoi(br.readLine());

        StringBuilder ansSB = new StringBuilder();
        for (int i = 1; i <= tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = atoi(st.nextToken());
            int b = atoi(st.nextToken());

            String input = br.readLine();
            for (char c : input.toCharArray()) {
                int n = c - 'A';
                char encryption = (char) ((a * n + b) % 26 + 'A');
                ansSB.append(encryption);
            }
            ansSB.append(ENTER);
        }
        System.out.println(ansSB);
    }

    private static int atoi(String string) {
        return Integer.parseInt(string);
    }
}
