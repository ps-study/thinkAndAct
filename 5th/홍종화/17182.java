import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	final static int INF = Integer.MAX_VALUE;
	static int[][] inputs;
	static boolean[] isVisit;
	static int N;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = atoi(st.nextToken()); // N = 10
		inputs = new int[N][N];
		isVisit = new boolean[N];

		final int start = atoi(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				inputs[i][j] = atoi(st.nextToken());
			}
		}

		isVisit[start] = true;
		floydWarshall();
		dfs(start, 0, 0);

		System.out.println(ans);
	}

	public static void floydWarshall() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (inputs[i][k] + inputs[k][j] < inputs[i][j]) {
						inputs[i][j] = inputs[i][k] + inputs[k][j];
					}
				}
			}
		}
	}

	public static void dfs(int index, int depth, int acc) {
		if (N - 1 <= depth) {
			if (acc < ans) {
				ans = acc;
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (i == index) {
				continue;
			}

			if (!isVisit[i]) {
				isVisit[i] = true;
				dfs(i, depth + 1, acc + inputs[index][i]);
				isVisit[i] = false;
			}
		}
	}

	private static int atoi(String string) {
		return Integer.parseInt(string);
	}
}
