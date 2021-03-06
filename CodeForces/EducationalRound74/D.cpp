#include <bits/stdc++.h>

using namespace std;

using ll = long long;
using P = pair<ll, ll>;
using Graph = vector<vector<ll>>;
#define rep(i, n) for(ll i=0;i<(ll)(n);i++)
#define rep2(i, m, n) for(ll i=m;i<(ll)(n);i++)
#define rrep(i, n, m) for(ll i=n;i>=(ll)(m);i--)
const int dx[4] = {1, 0, -1, 0};
const int dy[4] = {0, 1, 0, -1};
const int ddx[8] = {0, 1, 1, 1, 0, -1, -1, -1};
const int ddy[8] = {1, 1, 0, -1, -1, -1, 0, 1};
const ll MOD = 1000000007;
const ll INF = 1000000000000000000L;
#ifdef __DEBUG

/**
 * For DEBUG
 * https://github.com/ta7uw/cpp-pyprint
 */
#include "cpp-pyprint/pyprint.h"

#endif

vector<pair<char, ll>> RLE(const string &S) {
    ll cnt = 0;
    vector<pair<char, ll>> res;
    for (ll i = 0; i < (ll) S.size(); i++) {
        cnt++;
        if (i == (ll) S.size() - 1) {
            res.emplace_back(S[i], cnt);
            break;
        }
        if (S[i] != S[i + 1]) {
            res.emplace_back(S[i], cnt);
            cnt = 0;
        }
    }
    return res;
}

/**
 * D. AB-string
 * https://codeforces.com/contest/1238/problem/D
 *
 * ランレングス圧縮を使う
 * AB...B, B...BA, A..AB, BA..A
 * の4パターンが悪い例なので部分文字列全体 (N + 1) * N / 2 から
 * これら悪い例を数え上げて引く。
 * 重複して数えてしまわないように注意する
 */
void Main() {
    ll N;
    cin >> N;
    string S;
    cin >> S;
    ll ans = (N + 1) * N / 2;
    auto res = RLE(S);
    rep(i, res.size()) {
        ans -= res[i].second;
        if (i != 0) {
            ans -= res[i - 1].second;
            ans -= res[i].second - 1;
        }
    }
    cout << ans << '\n';
}

int main() {
    cin.tie(nullptr);
    ios::sync_with_stdio(false);
    cout << fixed << setprecision(15);
    Main();
    return 0;
}
