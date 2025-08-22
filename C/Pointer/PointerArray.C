#include<stdio.h>
#include<conio.h>

int main() {
	int i;
	int n1 = 18;
	int* ptr = &n1; // pointer store variable memory address, here prt store integer n1 variable address

	int arr[5] = { 5, 4, 3, 2, 1 };
	int* ptr2 = arr; // store address of array not use &. because array first value's address is same as array address

	printf("\n\nInteger & pointer\n");
	printf("\t %d \n", n1);
	printf("\t %p \n", &n1); // use & (reference operator) to print address, here printed n1 variable address
	printf("\t %p \n", ptr); // use %p to print pointer value, here ptr value is variable n1 address
	printf("\t %d---\n", ptr); // print variable value by using pointer
	printf("\t %p \n", &ptr); // print pointer address, here printed ptr address not n1 address


	printf("\n\nArray & pointer\n");
	printf("\t array value is: ");
	for (i = 0; i < 5; i++) { printf("%d\t", arr[i]); }
	printf("\n");
	printf("\t %p \n", &arr); // print array address by it's self, using & (here if not use & than answer not change)
	printf("\t %p \n", ptr2); // print array address by pointer ptr2

	printf("\t %d \n", *arr); // print *arr value
	printf("\t %d \n", *ptr2); // print *ptr2 value, here *arr and *ptr2 both value is same
	printf("\t print array values by using pointer\n");
	printf("\t %d \n", *arr); 		  // this print index 0 value, default 0
	printf("\t %d \n", *(arr + 3)); // this print index 3 value
	printf("\t print array all values by using pointer in loop\n\t ");
	for (i = 0; i < 5; i++) {
		printf("%d\t", *(arr + i));
	}

	return 0;
}