#include <iostream>
#include<vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false); cin.tie(nullptr);

    int n;
    cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }

    vector<int> L(n), R(n);

    L[0] = min(a[0], 1);
    for (int i = 1; i < n; ++i) {
        L[i] = min(a[i], L[i - 1] + 1);
    }

    R[n - 1] = min(a[n - 1], 1);
    for (int i = n - 2; i >= 0; --i) {
        R[i] = min(a[i], R[i + 1] + 1);
    }

    int ans = 0;
    for (int i = 0; i < n; ++i) {
        int h = min(L[i], R[i]);
        if (h > 0) {
            ans = max(ans, 2 * h - 1);
        }
    }

    cout << ans;
    return 0;
}
