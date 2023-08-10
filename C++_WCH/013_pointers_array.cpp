#include<iostream>
using namespace std;
int main(){
    int marks[] = {10,20,30,40,50,60,70,80,90,100};
    int* p = marks;
    *(p+1) = 25; //you can chenge value using pointer
    *(p+5) = 55;
    cout<<"The value of marks[0] is "<<*p<<endl; //using pointer to aecsess array values
    cout<<"The value of marks[1] is "<<*(p+1)<<endl;
    cout<<"The value of marks[2] is "<<*(p+2)<<endl;
    cout<<"The value of marks[3] is "<<*(p+3)<<endl;
    cout<<"The value of marks[5] is "<<*(p+5)<<endl;
    cout<<"The value of marks[6] is "<<*(p+6)<<endl;
    cout<<"The value of marks[7] is "<<*(p+7)<<endl;
    cout<<"The value of marks[8] is "<<*(p+8)<<endl;
    cout<<"The value of marks[9] is "<<*(p+9)<<endl;
    return 0;
}