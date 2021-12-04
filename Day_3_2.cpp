#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
#include <string>
#include <sstream>
using namespace std;
typedef vector<long> vl;
typedef vector<string> vs;

string get_most(vs binaryss) {
	vs temp1; int num = 0; char flag;
	for (int i = 0; i < 12; ++i) {
		for (int j = 0; j < binaryss.size(); ++j) {
			if (binaryss[j][i] == '0') ++num;
		}
		if (num >= binaryss.size() - num) flag = '0';
		else flag = '1';
		for (int j = 0; j < binaryss.size(); ++j) {
			if (binaryss[j][i] == flag) temp1.push_back(binaryss[j]);
		}
		binaryss = temp1;
		temp1.clear();
		if (binaryss.size() == 1) break;
	}
	return binaryss[0];
}

string get_least(vs binaryss) {
	vs temp1; int num = 0; char flag;
	for (int i = 0; i < 12; ++i) {
		for (int j = 0; j < binaryss.size(); ++j) {
			if (binaryss[j][i] == '0') ++num;
		}
		if (num < binaryss.size() - num) flag = '0';
		else flag = '1';
		int j = 0;
		while (j < binaryss.size()) {
			if (binaryss[j][i] == flag) temp1.push_back(binaryss[j]);
			++j;
		}
		binaryss = temp1;
		sort(binaryss.begin(), binaryss.end());
		temp1.clear();
		if (binaryss.size() == 1) break;
	}
	return binaryss[0];
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); //*
	FILE* stream;
	freopen_s(&stream, "input.txt", "r", stdin);
	freopen_s(&stream, "output.txt", "w", stdout); //*/
	string longword; vl inputs(12, 0); long a = 0, b = 0, c = 1; vs binaryss;
	vl most(12), least(12);
	while (cin >> longword) {
		binaryss.push_back(longword);
	}
	sort(binaryss.begin(), binaryss.end());
	cout << get_most(binaryss) << ' ' << get_least(binaryss);
	/*
	stringstream check1(longword);
	string intermediate;
	while (getline(check1, intermediate, 'x')) {
		inputs.push_back(stol(intermediate));
	}*/
	return 0;
}
