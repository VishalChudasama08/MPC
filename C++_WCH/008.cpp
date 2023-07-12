// constants, manipulators, operator precedece
#include<iostream>
#include<iomanip>
using namespace std;
int main(){
    //constants
    const int a = 8;
    cout << "constants variable a value is " << a << endl<< endl;

    // manipulators 
    int b=10, c=111, v=1599;
    cout<<"The value of a without setw is : "<<a<<endl; 
    cout<<"The value of b without setw is : "<<b<<endl; 
    cout<<"The value of c without setw is : "<<c<<endl; 

    cout<<"The vlaue of b is: "<<setw(4)<<b<<endl; //setw() use to right justfy number
    cout<<"The vlaue of c is: "<<setw(4)<<c<<endl;
    cout<<"The vlaue of v is: "<<setw(4)<<v<<endl<<endl;

    //operator precedece
    int g = (((a*b)-c)+v);
    cout<<"value of g is "<<g;
    return 0;
}