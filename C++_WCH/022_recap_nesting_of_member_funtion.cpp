#include<iostream>
#include<string>
using namespace std;

class binary
{
private:
    string s;

public:
    void read(void);
    void check_bin(void);
    void ones_compliment(void);
    void display(void);
};

void binary :: read()
{
    cout<<"Enter Binary Number:- ";
    cin>>s;
    cout<<endl;
}

void binary :: check_bin()
{
    for (int i = 0; i < s.length(); i++) //length is string funtion it is return string length 
    {
        if(s.at(i) != '0' && s.at(i) != '1') //at is string funtion and its return this character and its peramiter is character number 
        {
            cout<<"Incorrect binary format"<<endl;
            exit(0); //exit this program
        }
    }
    
}

void binary :: ones_compliment()
{
    for (int i = 0; i < s.length(); i++)
    {
        if(s.at(i) == '0')
        {
            s.at(i) = '1';
        }
        else
        {
            s.at(i) = '0';
        }
    }
    cout<<"Ones compliment complited!"<<endl;
}

void binary :: display()
{
    cout<<"Displaying Your Binary Number: ";
    for (int i = 0; i < s.length(); i++)
    {
        cout<<s.at(i);
    }
    cout<<endl;
}

int main()
{
    binary b;
    b.read();
    b.check_bin();
    b.display();
    b.ones_compliment();
    b.display();
    return 0;
}