import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    final static int INF = 400000001;
    static char[][] map;
    static int Y, X;
    static ArrayList<Point> list;

    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = atoi(st.nextToken());
        X = atoi(st.nextToken());
        map = new char[Y][X];
        // 가로일경우 : 왼쪽은 막혀있거나 범위밖..
        // 오른쪽은 2칸 비어져있어야함

        // 세로일경우 : 위의 칸은 막혀있거나 밖.
        // 아래 2칸비어
        for (int i = 0; i < Y; i++) {
            map[i] = br.readLine().toCharArray();
        }

        list = new ArrayList<>();
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (isPossibleRow(x, y) || isPossibleColumn(x, y)) {
                    list.add(new Point(x + 1, y + 1));
                }
            }
        }
        StringBuilder ansSB = new StringBuilder();
        ansSB.append(list.size() + "\n");
        for (Point cur : list) {
            ansSB.append(cur.y + " " + cur.x + "\n");
        }
        System.out.println(ansSB);
    }

    private static boolean isPossibleRow(int x, int y) {
        if (X <= x + 2) {
            return false;
        }

        if (0 <= x - 1 && map[y][x - 1] != '#') {
            return false;
        }

        if (map[y][x] != '.') {
            return false;
        }

        if (map[y][x + 1] != '.' || map[y][x + 2] != '.') {
            return false;
        }
        return true;
    }

    private static boolean isPossibleColumn(int x, int y) {
        if (Y <= y + 2) {
            return false;
        }

        if (0 <= y - 1 && map[y - 1][x] != '#') {
            return false;
        }

        if (map[y][x] != '.') {
            return false;
        }

        if (map[y + 1][x] != '.' || map[y + 2][x] != '.') {
            return false;
        }
        return true;
    }

    private static long atol(String string) {
        return Long.parseLong(string);
    }

    private static int atoi(String string) {
        return Integer.parseInt(string);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}