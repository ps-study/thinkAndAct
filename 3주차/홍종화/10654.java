import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    final static int INF = 400000001;

    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = atoi(st.nextToken());
        long T = atol(st.nextToken());

        long[] cows = new long[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = atoi(st.nextToken());
            int s = atoi(st.nextToken());
            cows[i] = x + s * T;
            // N : 100,000
            // T : 1,000,000,000
            // s * T +x > int
        }

        long min = cows[N - 1];
        int ans = 1;
        for (int i = N - 2; 0 <= i; i--) {
            if (cows[i] < min) {
                ans += 1;
            }
            min = Math.min(min, cows[i]);
        }
        System.out.println(ans);
    }

    private static long atol(String string) {
        return Long.parseLong(string);
    }

    private static int atoi(String string) {
        return Integer.parseInt(string);
    }
}
