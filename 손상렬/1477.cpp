#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;
int N, M, L;
vector<int> road;
bool isPossible(int param){
    int cnt = 0;
    for (int i = 0; i < road.size() - 1; i++){
        int diff = road[i + 1] - road[i] - 1;
        cnt += diff / param;
    }
    return cnt > M;
}
int main(){
    freopen("sample_input.txt", "r", stdin);
    scanf("%d %d %d", &N, &M, &L);
    for (int i = 0; i < N; i++){
        int in;
        scanf("%d", &in);
        road.push_back(in);
    }
    road.push_back(0), road.push_back(L);
    sort(road.begin(), road.end());
    int lo = 0, hi = L;
    while (lo + 1 < hi){
        int mid = (lo + hi) / 2;
        if (isPossible(mid)) lo = mid;
        else hi = mid;
    }
    printf("%d\n", hi);
}