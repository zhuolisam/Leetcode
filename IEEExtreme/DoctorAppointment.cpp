// The global pandemic has caused the Doctor Xtreme's office to become ultra busy. There are NN patients numbered 11 to NN that need to see Doctor Xtreme in the following NN days. On each day Doctor Xtreme will have a single appointment to see one of the NN patients. Each patient ii has provided his/her available time window as two integers L_i, R_iL 
// i
// ​
//  ,R 
// i
// ​
//  , which means that he/she can come to see Doctor Xtreme on any day between the L_iL 
// i
// ​
//  th day and the R_iR 
// i
// ​
//  th day (inclusive on both ends).

// Can Doctor Xtreme successfully schedule NN appointments to see all the NN patients?


// Standard input
// The first line of input contains a single integer TT, the number of test cases.

// Each test case begins with an integer NN on the first line, the number of patients. The next NN lines each have two integers, describing the available time window of one patient. The iith line has L_iL 
// i
// ​
//   and R_iR 
// i
// ​
//  .


// Standard output
// For each test case output a single line.

// If it is possible for Doctor Xtreme to see all the NN patients, output NN space-separated integers on a single line. The iith of these integers is the patient that Doctor Xtreme will see on the iith day. If there are multiple ways to schedule the NN appointments, you may output any of them.

// If Doctor Xtreme cannot see all the NN patients, output impossible.


// Constraints and notes
// 1 \leq T \leq 301≤T≤30
// 2 \leq N \leq 10^52≤N≤10 
// 5
 
// 1 \leq L_i \leq R_i \leq N1≤L 
// i
// ​
//  ≤R 
// i
// ​
//  ≤N
// For 60\%60% of the test files, N \leq 10N≤10.
// For 80\%80% of the test files, N \leq 1\,000N≤1000.





#include <bits/stdc++.h>

using namespace std;

void solve(){
    int n; cin>>n;
    vector<int>L(n+1), R(n+1);
    
    vector<vector<int>>adj(n+1);
    
    for(int i=1; i<=n; i++){
        cin>>L[i]>>R[i];
        adj[L[i]].push_back(i);
    }
    vector<int>ans(n+1);
    bool dead = false;
    set<pair<int,int>>s;
    
    for(int i=1; i<=n; i++){
        for(int j:adj[i]){
            s.emplace(R[j],j);
        }
        if(s.empty()){
            dead = true;
            break;
        }else{
            auto x = *(s.begin());
            if(x.first<i){
                dead = true;
                break;
            }
            s.erase(s.begin());
            ans[i]=x.second;
        }
    }
    
    if(dead){
        cout<<"impossible\n";
    }else{
        for(int i=1; i<=n; i++){
            if(i>1)cout<<" ";
            cout<<ans[i];
        }
        cout<<"\n";
    }
}

int main() {
    int t; cin>>t;
    while(t--)solve();
    return 0;
}
