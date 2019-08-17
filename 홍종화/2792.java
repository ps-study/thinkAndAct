import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int[] jewelry;
    static int children, color;

    public static void main(String[] argv) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        children = Integer.parseInt(line[0]);
        color = Integer.parseInt(line[1]);

        jewelry = new int[color];
        int max = 0;
        for (int i = 0; i < color; i++) {
            jewelry[i] = Integer.parseInt(br.readLine());
            if (max < jewelry[i]) {
                max = jewelry[i];
            }
        }
        int l = 1;
        int r = max; // [1, 10^9]
        while (l <= r) {
            int mid = (l + r) / 2;
            if (isPossible(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(l);
    }

    public static boolean isPossible(int mid) {
        int cnt = 0;
        for (int i = 0; i < color; i++) {
            cnt += Math.ceil(jewelry[i] / (double) mid);
            if (children < cnt) {
                return true;
            }
        }
        return false;
    }
}