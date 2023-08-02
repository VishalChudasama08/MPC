#include<iostream>
using namespace std;
int main(){
    int v,g;
    cout<<"Enter the size of piramid: ";
    cin>>g;
    v=g;
    for (int i = 0; i < v; i++){
        for (int j = g; j > 0; j--){
            cout<<"  ";
        }
        for (int b=i+1; b > 0; b--){
            cout<<" O";
        }
        for (int k=i; k > 0; k--){
            cout<<" O";
        }
        for (int j = g; j > 0; j--){
            cout<<"  ";
        }
        g--;
        cout<<endl;
    }
    return 0;
}