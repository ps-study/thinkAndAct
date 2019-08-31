import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = atoi(br.readLine());
        int[] speed = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = atoi(st.nextToken());
            speed[i] = atoi(st.nextToken());
        }

        int min = speed[N - 1];
        int cnt = 1;
        for (int i = N - 2; 0 <= i; i--) {
            if (speed[i] <= min) {
                cnt += 1;
                min = speed[i];
            }
        }
        System.out.println(cnt);
    }

    private static int atoi(String string) {
        return Integer.parseInt(string);
    }
}
