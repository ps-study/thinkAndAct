#include <iostream>
#include <string>
#include <stack>
using namespace std;
int main(){
    string in;
    cin >> in;
    char prev = in[0];
    int ans = 0, mul = 1;
    stack<char> stk;
    bool possible = true;
    for (auto c : in) {
        if (c == '(') {
            stk.push(c);
            mul *= 2;
        }
        else if (c == '[') {
            stk.push(c);
            mul *= 3;
        }
        else if (c == ')') {
            if (stk.empty() || stk.top() == '[') {
                possible = false;
                break;
            }
            if (prev == '(') ans += mul;
            stk.pop();
            mul /= 2;
        }
        else if (c == ']') {
            if (stk.empty() || stk.top() == '(') {
                possible = false;
                break;
            }
            if (prev == '[') ans += mul;
            stk.pop();
            mul /= 3;
        }
        prev = c;
    }
    if (!stk.empty()) possible = false;
    if (possible) printf("%d\n", ans);
    else puts("0");
}