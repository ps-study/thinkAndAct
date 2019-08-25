import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    final static Stack<Integer> stack = new Stack<>();
    static boolean[] finished;
    static int[] dfsn;
    static int V, E;
    static int order;
    static StringBuilder ansSB;
    static ArrayList<Integer>[] list;
    static ArrayList<ArrayList> aalist;

    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ansSB = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = atoi(st.nextToken());
        E = atoi(st.nextToken());
        finished = new boolean[V + 1];
        dfsn = new int[V + 1];
        Arrays.fill(dfsn, -1);
        list = new ArrayList[V + 1];
        aalist = new ArrayList<>();

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = atoi(st.nextToken());
            int e = atoi(st.nextToken());
            list[s].add(e);
        }

        order = 1;
        ansSB = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dfsn[i] == -1) {
                dfs(i);
            }
        }

        System.out.println(aalist.size());
        Collections.sort(aalist, new MyComparator());
        for (ArrayList<Integer> curList : aalist) {
            for (int num : curList) {
                ansSB.append(num + " ");
            }
            ansSB.append("-1\n");
        }
        System.out.println(ansSB);
    }

    public static int dfs(int v) {
        dfsn[v] = order++;
        stack.push(v);
        int res = dfsn[v];
        for (int next : list[v]) {
            if (dfsn[next] == -1) {
                res = Math.min(res, dfs(next));
            } else if (!finished[next]) {
                res = Math.min(res, dfsn[next]);
            }
        }

        if (res == dfsn[v]) {
            ArrayList<Integer> list = new ArrayList<>();
            while (true) {
                int pop = stack.pop();
                list.add(pop);
                finished[pop] = true;
                if (pop == v) {
                    break;
                }
            }
            Collections.sort(list);
            aalist.add(list);
        }

        return res;
    }

    private static int atoi(String s) {
        return Integer.parseInt(s);
    }
}

class MyComparator<T extends Number & Comparable<T>> implements Comparator<ArrayList<T>> {
    @Override
    public int compare(ArrayList<T> a, ArrayList<T> b) {
        return a.get(0).compareTo(b.get(0));
    }
}