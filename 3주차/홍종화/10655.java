import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    final static int INF = 400000001;

    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = atoi(br.readLine());

        int[] xPoints = new int[N];
        int[] yPoints = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = atoi(st.nextToken());
            int y = atoi(st.nextToken());
            xPoints[i] = x;
            yPoints[i] = y;
        }

        int totalDist = 0;
        for (int i = 1; i < N; i++) {
            totalDist += getBetweenDist(xPoints[i], xPoints[i - 1], yPoints[i], yPoints[i - 1]);
        }

        int maxDiff = Integer.MIN_VALUE;
        for (int i = 2; i < N; i++) {
            int dist = getBetweenDist(xPoints[i], xPoints[i - 1], yPoints[i], yPoints[i - 1])
                    + getBetweenDist(xPoints[i - 1], xPoints[i - 2], yPoints[i - 1], yPoints[i - 2]);

            int dist2 = getBetweenDist(xPoints[i], xPoints[i - 2], yPoints[i], yPoints[i - 2]);
            maxDiff = Math.max(maxDiff, dist - dist2);
        }

        System.out.println(totalDist - maxDiff);

    }

    private static int getBetweenDist(int x1, int x2, int y1, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private static int atoi(String string) {
        return Integer.parseInt(string);
    }
}
