#include<iostream>
#include<vector>

using namespace std;

int findMax(int n, const vector<int>& start, const vector<int>& desti) {
	for (int i = n; i > 0; i--) {
		if (start[i] != desti[i]) {
			return i;
		}
	}
	return 0;
}

int other(int start, int desti) {
	return 6 - (start + desti);
}

int moving(int m, const vector<int>& state, int a) {
	int dist = 0;
	for (int k = m; k >= 1; --k) {
		if (state[k] == a) {
			continue;
		}
		int nxt = other(state[k], a);
		dist += (1 << (k - 1));
		a = nxt;
	}
	return dist;
}


int getCount(int n, const vector<int>& start, const vector<int>& desti) {
	int cur = findMax(n, start, desti);
	if (cur == 0) {
		return 0;
	}

	int a = start[cur];
	int b = desti[cur];
	int c = other(a, b);

	int l = moving(cur - 1, start, c);
	int r = moving(cur - 1, desti, c);
	return l + 1 + r;
}


void getSequence(int n, const vector<int>& start, const vector<int>& desti, vector<pair<int, int>>& seq) {
	int cur = findMax(n, start, desti);
	if (cur == 0) {
		return;
	}
	int a = start[cur];
	int b = desti[cur];
	int c = other(a, b);

	vector<int>m1(cur);
	for (int i = cur - 1; i > 0; i--) {
		m1[i] = c;
	}
	getSequence(cur - 1, start, m1,seq);

	seq.push_back({ a,b });

	vector<int>m2(cur);
	for (int i = cur - 1; i > 0; i--) {
		m2[i] = c;
	}
	getSequence(cur - 1, m2, desti, seq);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int n = 0;
	cin >> n;

	vector<int>start(n + 1), desti(n + 1);

	for (int i = 1; i <= 3; i++) { // 초기 상태
		int a = 0;
		int b = 0;
		cin >> a;
		for (int j = 0; j < a; j++) {
			cin >> b;
			start[b] = i;
		}
	}

	for (int i = 1; i <= 3; i++) { // 종료 상태
		int a = 0;
		int b = 0;
		cin >> a;
		for (int j = 0; j < a; j++) {
			cin >> b;
			desti[b] = i;
		}
	}

	int ans = getCount(n, start, desti);
	cout << ans << "\n";
	if (n <= 10) {
		vector<pair<int, int>>seq;
		seq.reserve((size_t)ans);
		getSequence(n, start, desti, seq);
		for (int i = 0; i < ans; i++) {
			cout << seq[i].first << " " << seq[i].second << "\n";
		}
	}
}