import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    final static Stack<Integer> stack = new Stack<>();
    static boolean[] isVisit, finished;
    static int[] parent;
    static int[] dfsn;
    static int V, E;
    static int order;
    static int ansCnt = 0;
    static StringBuilder ansSB = new StringBuilder();
    static PriorityQueue<Integer>[] pq;

    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ansSB = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = atoi(st.nextToken());
        E = atoi(st.nextToken());
        isVisit = new boolean[V + 1];
        finished = new boolean[V + 1];
        dfsn = new int[V + 1];
        pq = new PriorityQueue[V + 1];
        for (int i = 1; i <= V; i++) {
            pq[i] = new PriorityQueue<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = atoi(st.nextToken());
            int e = atoi(st.nextToken());
            pq[s].add(e);
        }

        order = 1;
        for (int i = 1; i <= V; i++) {
            dfs(i);
        }

        System.out.println(stack);
        System.out.println(ansCnt);
        System.out.println(ansSB.length());
    }

    public static boolean dfs(int v) {
        // 사이클생김
        if (dfsn[v] != 0 && !finished[v]) {
            return true;
        }

        dfsn[v] = order++;
        isVisit[v] = true;

        // 리프노드인경우..
        if (pq[v].isEmpty()) {
            ansCnt += 1;
            finished[v] = true;
            ansSB.append(v).append("-1\n");
            return false;
        }

        stack.push(v);
        // 자식이 있는경우
        boolean isCycle = false;
        while (!pq[v].isEmpty()) {
            int child = pq[v].poll();
            if (dfs(child)) {
                isCycle = true;
            }
        }

        if (isCycle == false) {
            ansCnt += 1;
            while (true) {
                int pop = stack.pop();
                finished[pop] = true;
                ansSB.append(pop + " ");
                if (pop == v) {
                    ansSB.append("-1\n");
                    break;
                }
            }
            return false;
        }

        return isCycle;
    }

    private static int atoi(String s) {
        return Integer.parseInt(s);
    }
}
