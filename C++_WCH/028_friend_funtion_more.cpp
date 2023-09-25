// this is simple friend funtion example
// #include <iostream>
// using namespace std;

// class y;

// class x
// {
//     int data;

// public:
//     void put_d(int value)
//     {
//         data = value;
//     }
//     friend void display(x, y);
// };

// class y
// {
//     int value;

// public:
//     void put_v(int data)
//     {
//         value = data;
//     }
//     friend void display(x, y);
// };

// void display(x o1, y o2)
// {
//     cout << "Class x data is " << o1.data << ", Class y value is " << o2.value << endl;
//     cout << "Sum of this two value is " << o1.data + o2.value;
// }

// int main()
// {
//     x a1;
//     a1.put_d(12);

//     y a2;
//     a2.put_v(21);

//     display(a1, a2);
// }

// friend funtion with refresnse
#include <iostream>
using namespace std;
class y;

class x
{
    int data;

public:
    void put_d(int value)
    {
        data = value;
    }
    void get_d()
    {
        cout << "x class data is " << data << endl;
    }
    friend void swap(x &, y &);
};

class y
{
    int value;

public:
    void put_v(int data)
    {
        value = data;
    }
    void get_v()
    {
        cout << "y class value is " << value << endl;
    }
    friend void swap(x &, y &);
};

void swap(x &o1, y &o2)
{
    int temp = o1.data;
    o1.data = o2.value;
    o2.value = temp;
}

int main()
{
    x a1;
    a1.put_d(12);

    y a2;
    a2.put_v(21);

    a1.get_d();
    a2.get_v();

    swap(a1, a2);

    cout << "after swapeing" << endl;

    a1.get_d();
    a2.get_v();
}
