import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    final static String ENTER = "\n";

    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = atoi(br.readLine());

        // 구간합이 7의 배수인 가장긴 수열
        // N : 50,000
        // V : 1,000,000
        // NV : 50,000,000,000 long
        int[] inputs = new int[N];
        long[] accs = new long[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = atoi(br.readLine());
        }

        ArrayList[] modular = new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            modular[i] = new ArrayList<Integer>();
        }

        accs[0] = inputs[0];
        modular[inputs[0] % 7].add(0);
        for (int i = 1; i < N; i++) {
            long v = accs[i - 1] + (long) inputs[i];
            accs[i] = v;
            int idx = (int) (v % 7);
            modular[idx].add(i);
        }

        int ans = -1;
        if (modular[0].size() > 0) {
            ans = (int) modular[0].get(modular[0].size() - 1);
            ans = ans == 0 ? 1 : ans + 1;
        }

        for (int i = 1; i <= 6; i++) {
            if (1 < modular[i].size()) {
                int lastIdx = modular[i].size() - 1;
                int diff = (int) modular[i].get(lastIdx) - (int) modular[i].get(0);
                ans = Math.max(diff, ans);
            }
        }

        System.out.println(ans == -1 ? 0 : ans);
    }

    private static int atoi(String string) {
        return Integer.parseInt(string);
    }

    private static long atol(String string) {
        return Long.parseLong(string);
    }
}
