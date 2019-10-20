import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  final static Set<Integer> set = new HashSet<>();
  static int MAX_A, MAX_B, MAX_C;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    final int N = atoi(br.readLine());
    final int M = atoi(br.readLine());

    ArrayList<Integer>[] relationships = new ArrayList[N];

    for (int i = 0; i < N; i++) {
      relationships[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = atoi(st.nextToken()) - 1;
      int b = atoi(st.nextToken()) - 1;
      relationships[a].add(b);
      relationships[b].add(a);
    }

    Queue<Integer> q = new LinkedList<Integer>();
    boolean[] isVisit = new boolean[N];
    isVisit[0] = true;

    for (int friend : relationships[0]) {
      q.add(friend);
      isVisit[friend] = true;
    }
    int ansCount = q.size();

    while (!q.isEmpty()) {
      int cur = q.poll();
      for (int friend : relationships[cur]) {
        if (!isVisit[friend]) {
          isVisit[friend] = true;
          ansCount += 1;
        }
      }
    }

    System.out.println(ansCount);
  }

  private static int atoi(String string) {
    return Integer.parseInt(string);
  }
}
