import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int N = atoi(br.readLine());
    if (N == 0) {
      System.out.println(1);
      return;
    }
    int[] dp = new int[N + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= N; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2] + 1) % 1000000007;
    }
    System.out.println(dp[N]);
  }

  private static int atoi(String string) {
    return Integer.parseInt(string);
  }
}
