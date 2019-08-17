#include <cstdio>
#include <algorithm>
using namespace std;
const int SIZE = 300'000;
const int INF = 1e9;
int N, M, color[SIZE];
bool isPossible(int m){
    int cnt = 0;
    for (int i = 0; i < M; i++){
        cnt += (color[i] - 1) / m + 1;
    }
    return cnt > N;
}
int main(){
    scanf("%d %d", &N, &M);
    for (int i = 0; i < M; i++) scanf("%d", color + i);
    int lo = 0, hi = INF;
    while (lo + 1 < hi){
        int mid = (lo + hi) / 2;
        if (isPossible(mid)) lo = mid;
        else hi = mid;
    }
    printf("%d\n", hi);
}