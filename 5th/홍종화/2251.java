import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  final static Set<Integer> set = new HashSet<>();
  static boolean[][] isVisit;
  static int MAX_A, MAX_B, MAX_C;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    // [1,200]
    MAX_A = atoi(st.nextToken());
    MAX_B = atoi(st.nextToken());
    MAX_C = atoi(st.nextToken());
    isVisit = new boolean[MAX_A + 1][MAX_B + 1];

    dfs(0, 0, MAX_C);

    printAns();
  }

  // a->b
  // a->c
  // b->c
  // b->a
  // c->a
  // c->b
  public static void dfs(int a, int b, int c) {
    if (isVisit[a][b]) {
      return;
    }

    if (a == 0) {
      set.add(c);
    }

    isVisit[a][b] = true;

    // case 1: a -> b
    if (a + b <= MAX_B) {
      dfs(0, a + b, c);
    } else {
      dfs((a + b) - MAX_B, MAX_B, c);
    }

    // case 2: a -> c
    dfs(0, b, a + c);

    // case 3: b -> a
    if (a + b <= MAX_A) {
      dfs(a + b, 0, c);
    } else {
      dfs(MAX_A, (a + b) - MAX_A, c);
    }

    // case 4: b -> c
    dfs(a, 0, b + c);

    // case 5 : c -> a
    if (a + c <= MAX_A) {
      dfs(a + c, b, 0);
    } else {
      dfs(MAX_A, b, (a + c) - MAX_A);
    }

    // case 6 : c -> b
    if (b + c <= MAX_B) {
      dfs(a, b + c, 0);
    } else {
      dfs(a, MAX_B, (b + c) - MAX_B);
    }

  }

  public static void printAns() {
    int len = set.size();
    int[] ans = new int[len];
    int i = 0;
    for (int num : set) {
      ans[i++] = num;
    }

    Arrays.sort(ans);
    StringBuilder ansSB = new StringBuilder();
    for (int z = 0; z < len; z++) {
      ansSB.append(ans[z] + " ");
    }
    System.out.println(ansSB);
  }

  private static int atoi(String string) {
    return Integer.parseInt(string);
  }
}

class Water {
  int a;
  int b;
  int c;

  public Water(int a, int b, int c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }
}