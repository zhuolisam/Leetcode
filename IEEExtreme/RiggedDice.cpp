// Alice and Bob are playing a dice game with two dice labeled die 11 and die 22. Both dice have six faces valued from 11 to 66. Initially, Alice has die 11 and Bob has die 22. They both start with an initial score of zero. One game consists of NN rounds. In one round, Alice and Bob roll their own dice at the same time, and add the rolled value to their own score, so that each player's score tracks the sum of all the values rolled by the player in this game. After a roll, if Alice's and Bob's scores are not equal, they will exchange their dice before the next round -- This is to avoid cheating in case one of the dice is rigged.

// Unfortunately, one of the two dice is indeed rigged. With a normal die, each value from 11 to 66 has a uniform probability to face up. However, the rigged die has a probability of 2/72/7 to roll a 66, while the values from 11 to 55 each have a probability of 1/71/7 to face up.

// Given the values that Alice and Bob rolled in a game, can you identify which die is rigged?


// Standard input
// The first line contains a single integer TT, the number of games. The die that is rigged in each game is independently selected.

// Each game starts with a single integer NN on a single line, the number of rounds. This is followed by NN lines each having two integers between 11 and 66: the value that Alice rolled, and the value that Bob rolled in one round.


// Standard output
// For each game output a single integer. Output 11 if die 11 (the die that Alice initially had) is rigged. Otherwise, output 22.


// Constraints and notes
// T = 500T=500
// N = 1000N=1000
// The values rolled in each game are according to the rule specified above. Alice and Bob have kept track of their own scores and exchanged dice when required by the rule. Because of those exchanges, Alice and Bob may roll different dice in different rounds of the game.
// For each test file, your solution is judged correct if it identifies the rigged dice correctly in at least 99\%99% of the games.
// You must output either 11 or 22 for each game. Any other output, or missing output for a game, will result in a Wrong Answer verdict.
// The sample test has T=2, N=4T=2,N=4 only for an exemplification of the dice exchanges. The output in the sample answer only showcases output format, and should not be considered successful identifications of the rigged dice. Any answer submitted to the sample test will be judged correct.

#include <bits/stdc++.h>

using namespace std;

void solve(){
    int n; cin>>n;
    int cnt[2][7] = {};
    infor(int i=1; i<7; i++){
    //     cerr<<cnt[0][i]<<" \n"[i==6];
    // }
    // for(int i=1; i<7; i++){
    //     cerr<<cnt[1][i]<<" \n"[i==6];
    // t a=0, b=1;
    int sum[2]={};
    for(int i=0; i<n; i++){
        int x,y; cin>>x>>y;
        sum[0]+=x;
        sum[1]+=y;
        
        cnt[a][x]++;
        cnt[b][y]++;
        
        if(sum[0]!=sum[1]){
            swap(a,b);
        }
    }
    // }
    if(cnt[0][6]>cnt[1][6]){
        cout<<1<<"\n";
    }else{
        cout<<2<<"\n";
    }
}

int main() {
    int t; cin>>t;
    while(t--)solve();
    return 0;
}
