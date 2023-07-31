#include<iostream>
#include<iomanip>
using namespace std;
int main(){
    int age;
    cout << "What is your age ? ";
    cin >> age;
    if(age<0){
        cout<<"age not velid!"<<endl;
    }
    else if(age<18 && age>0){
        cout<<"You are not come to my party "<<endl;
    }
    else if(age==18){
        cout<<"you will get a kid pass to the party"<<endl;
    }
    else{
        cout<<"You can come to my party"<<endl;
    }

    switch (age){
    case 18:
        cout<<"Your age is 18"<<endl;
        break;
    case 20:
        cout<<"Your age is 20"<<endl;
        break;
    case 22:
        cout<<"Your age is 22"<<endl;
        break;
    default:
        cout<<"Your age is not 18,20 and 22"<<endl;
        break;
    }
    return 0;
}