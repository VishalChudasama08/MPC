#include<iostream>
using namespace std;
int main(){
    enum time{ morning, afternoon, night};

    cout<<morning<<endl;
    cout<<afternoon<<endl;
    cout<<night<<endl<<endl;

    time t1 = morning;
    time t2 = afternoon;
    time t3 = night;

    cout<<t1<<endl;
    cout<<t2<<endl;
    cout<<t3<<endl<<endl;

    cout<<(t1==morning)<<endl; // it is true --> 1
    cout<<(t1==night)<<endl; // it is false --> 0
    return 0;
}