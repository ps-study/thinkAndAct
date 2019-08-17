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

		int l = 0;
		int r = L;
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
		for (int i = 0; i < N + 1; i++) {
			cnt += (express[i + 1] - express[i] - 1) / mid;
		}
		return M < cnt;
	}
}