//This is University of Florida 2014's problems to solve for practice

#include<iostream>
#include<string>
using namespace std;

int vowelCheck(string name) {
	int len = name.length();
	int vowel = 0;
	int cons = 0;
	for (int i=0; i<len; i++) {
		if (name[i] == 'a' || name[i] == 'e' || name[i] == 'i' || name[i] == 'o' || name[i] == 'u') {
			vowel++;
		}
		else {
			cons++;
		}
	}
	if (vowel>cons) {
		return 1;
	} else {
		return 0;
	}
}

void footballRecord(int games, int points) {
	int wins2 = points/3;
	for (int i=0; i<wins2+1; i++) {
		int games2 = games;
		int points2 = points;
		int wins = points2/3;
		wins = wins-i;
		points2 = points2 - (wins*3);
//		cout<<"-----"<<games2-wins<<"-----"<<points2<<endl;
		if ((games2-wins)>=points2) {
			int ties = points2;
			games2 = games2-wins-ties;
			int losses = games2;
			cout<<wins<<"-"<<ties<<"-"<<losses<<endl;
		}
		
	}
}

int jumpingFrog(int pathLength, int maxjump, string path) {
//	cout<<path<<endl;
	int pos=0, jumps=0, flag=0;
	if (maxjump>pathLength) {
		return 1;
	}
	while ((pos+1)!=pathLength && flag!=1) {
		for (int i=0; i<maxjump+1; i++) {
			if (path[pos+maxjump+1-i] == '.') {
				pos = pos+(maxjump+1-i);
				jumps++;
				break;
			}
			if (i==maxjump) {
				flag=1;
				jumps=0;
				break;
			}
		}	
	}
	return jumps;
	
}

int main() {
	//-----------PROBLEM 1---VOWEL CHECK-----------------
//	int n;
//	cin>>n;
//	string nameArray[n];
//	for (int i=0; i<n; i++) {
//		cin>>nameArray[i];
//	}
//	
//	for (int j=0; j<n; j++) {
//		cout<<nameArray[j]<<endl;
//		cout<<vowelCheck(nameArray[j])<<endl<<"\n";
//	}
	
	
	//-----------PROBLEM 2-----FOOTBALL STANDINGS---------------
//	int games, points;
//	cin>>games;
//	cin>>points;
//	footballRecord(games, points);


	//----------PROBLEM 3------FROG JUMP----------------------
//	int pathLength, maxjump;
//	string path;
//	cin>>pathLength;
//	cin>>maxjump;
//	cin>>path;
//	
//	cout<<jumpingFrog(pathLength, maxjump, path)<<endl;

	int cars;
	cin>>cars;
	int carTime[cars];
	for (int i=0;i<cars;i++) {
		cin>>carTime[i];
	}
	for (int i=0;i<cars;i++) {
		cout<<carTime[i];
	}


	
	
	
	return 0;
}
