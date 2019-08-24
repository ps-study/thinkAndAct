import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int NQ = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        int[][] map = new int[N + 1][NQ + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            q.offer(i);
            for (int j = 1; j <= NQ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int ans = Integer.parseInt(st.nextToken());
            int len = q.size();
            while (len-- > 0) {
                int index = q.poll();
                if (map[index][id] == ans) {
                    q.offer(index);
                }
            }
        }

        System.out.println(q.size());
    }
}
