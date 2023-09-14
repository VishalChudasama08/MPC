#include <iostream>
using namespace std;

class Shop
{
    int itemId[100], itemPrice[100], counter;

public:
    void initCounter(void)
    {
        counter = 0;
    }
    void setPrice(void);
    void displayPrice(void);
};
void Shop ::setPrice(void)
{
    cout << "Enter Id of your item of no " << counter + 1 << " : ";
    cin >> itemId[counter];
    cout << "Enter Price of yout item "
         << " : ";
    cin >> itemPrice[counter];
    counter++;
}

void Shop ::displayPrice(void)
{
    for (int i = 0; i < counter; i++)
    {
        cout << "The Price of item with ID " << itemId[i] << " is " << itemPrice[i] << endl;
    }
}

int main()
{
    Shop dukan;
    dukan.initCounter();
    dukan.setPrice();
    dukan.setPrice();
    dukan.setPrice();
    dukan.displayPrice();
    return 0;
}