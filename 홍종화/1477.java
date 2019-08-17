import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	static int[] express;
	static int N, M, L;

	public static void main(String[] argv) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		L = Integer.parseInt(line[2]);

		line = br.readLine().split(" ");
		express = new int[N + 2];

		for (int i = 0; i < N; i++) {
			express[i] = Integer.parseInt(line[i]);
		}
		express[N] = L;
		Arrays.sort(express);

		int r = Integer.MIN_VALUE;
		for (int i = 1; i < N + 1; i++) {
			int diff = express[i] - express[i - 1];
			if (r < diff) {
				r = diff;
			}
		}

		int l = 0;
		int ans = Integer.MAX_VALUE;
		while (l <= r) {
			int mid = (l + r) / 2;
			int res = isPossible(mid);
			if (res == -1) {
				l = mid + 1;
			} else if (res == 0) {
				r = mid - 1;
			} else {
				if (res < ans) {
					ans = res;
				}
				l = mid + 1;
			}
		}
		System.out.println(ans);
	}

	public static int isPossible(int mid) {
		final int MAX_SIZE = N + M + 2;
		int[] tmp = new int[MAX_SIZE];
		int cnt = 0;

		for (int i = 0; i < N + 1; i++) {
			tmp[cnt++] = express[i];
			int next = express[i] + mid;
			while (cnt < MAX_SIZE && next < express[i + 1]) {
				tmp[cnt++] = next;
				next += mid;
			}

			if (MAX_SIZE <= cnt) {
				return -1;
			}
		}

		tmp[cnt++] = express[N + 1];
		if (cnt < MAX_SIZE) {
			return 0;
		}
		int maxDiff = Integer.MIN_VALUE;
		for (int i = 0; i < MAX_SIZE - 1; i++) {
			int diff = tmp[i + 1] - tmp[i];
			if (maxDiff < diff) {
				maxDiff = diff;
			}
		}
		return maxDiff;
	}
}