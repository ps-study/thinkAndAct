#include <cstdio>
#include <queue>
#include <tuple>
#include <vector>
#include <algorithm>
using namespace std;
using tup = tuple<int,int,int>;
constexpr int MAXSIZE = 210;
bool visited[MAXSIZE][MAXSIZE][MAXSIZE];
int main(){
    int A, B, C;
    scanf("%d %d %d", &A, &B, &C);
    queue<tup> q;
    q.push({0, 0, C});
    visited[0][0][C] = true;
    vector<int> bottle;
    while (!q.empty()){
        int a, b, c;
        tie(a, b, c) = q.front();
        q.pop();
        if (!a) bottle.push_back(c);
        if (a + b <= B && !visited[0][a+b][c]){
            q.push({0, a+b, c});
            visited[0][a+b][c] = true;
        }
        if (a + b > B && !visited[a-(B-b)][B][c]){
            q.push({a-(B-b), B, c});
            visited[a-(B-b)][B][c] = true;
        }
        if (a + c <= C && !visited[0][b][a+c]){
            q.push({0, b, a+c});
            visited[0][b][a+c] = true;
        }
        if (a + c > C && !visited[a-(C-c)][b][C]){
            q.push({a-(C-c),b,C});
            visited[a-(C-c)][b][C] = true;
        }
        if (b + a <= A && !visited[b+a][0][c]){
            q.push({b+a, 0, c});
            visited[b+a][0][c] = true;
        }
        if (b + a > A && !visited[A][b-(A-a)][c]){
            q.push({A,b-(A-a),c});
            visited[A][b-(A-a)][c] = true;
        } 
        if (b + c <= C && !visited[a][0][b+c]){
            q.push({a, 0, b+c});
            visited[a][0][b+c] = true;
        }
        if (b + c > C && !visited[a][b-(C-c)][C]){
            q.push({a,b-(C-c),C});
            visited[a][b-(C-c)][C] = true;
        }
        if (c + a <= A && !visited[c+a][b][0]){
            q.push({c+a, b, 0});
            visited[c+a][b][0] = true;
        }
        if (c + a > A && !visited[A][b][c-(A-a)]){
            q.push({A, b, c-(A-a)});
            visited[A][b][c-(A-a)] = true;
        }
        if (c + b <= B && !visited[a][c+b][0]){
            q.push({a, c+b, 0});
            visited[a][c+b][0] = true;
        }
        if (c + b > B && !visited[a][B][c-(B-b)]){
            q.push({a, B, c-(B-b)});
            visited[a][B][c-(B-b)] = true;
        }
    }
    sort(bottle.begin(), bottle.end());
    for (int &k : bottle) printf("%d ", k);
}