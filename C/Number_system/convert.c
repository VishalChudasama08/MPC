/* binary to decimal octal and hexadecimal by normal and bitwise operation */
#include<stdio.h>
#include<conio.h>
#include <stdlib.h> // needd for use exit() function
#define MAX 20

void decimal_to_binary(int);
void display(int[], int);

int convert(int, int, int);
int menu();

int main() {
	int number, x;

	do {
		switch (menu()) {
		case 0: exit(1);
		case 1:
			printf("\n\tEnter Decimal number(0-9): ");
			scanf("%d", &number);
			// decimal_to_binary(number);
			printf("\n\t%d decimal = %d binary", number, convert(number, 10, 2)); // decimal to binary
			break;

		case 2:
			printf("\n\tEnter Decimal number(0-9): ");
			scanf("%d", &number);
			printf("\n\t%d decimal = %d octal", number, convert(number, 10, 8)); // decimal to octal 
			break;
		case 4:
			printf("\n\tEnter Binary number(0-1): ");
			scanf("%d", &number);
			printf("\n\t%d binary = %d decimal", number, convert(number, 2, 10)); // binary to decimal
			break;
		case 5:
			printf("\n\tEnter Binary number(0-1): ");
			scanf("%d", &number);
			printf("\n\t%d binary = %d octal", number, convert(convert(number, 2, 10), 10, 8)); // binary to octal => 1. binary to decimal 2. decimal to octal
			break;
		case 7:
			printf("\n\tEnter Octal number(0-7): ");
			scanf("%d", &number);
			decimal_to_binary(number);
			// printf("\n\t%d octal = %d binary", number, convert(convert(number, 10, 2), 10, 10)); // octal to binary => 1. octal to decimal 2. decimal to binary
			break;
		case 8:
			printf("\n\tEnter Octal number(0-7): ");
			scanf("%d", &number);
			printf("\n\t%d octal = %d decimal", number, convert(convert(number, 10, 8), 10, 10)); // octal decimal
			break;
			// case 7:
			// 	printf("\n\tEnter Octal number(0-7): ");
			// 	scanf("%d", &number);

			// 	octal_to_binary(number);
			// 	break;

		default: printf("\n\t\t Enter valid number from menu");
		}
		printf("\n\n\tPress Enter for continue");
		getch();
	} while (1);
}

int menu() {
	int i = 0;
	printf("\n\n\t0. Exit program");
	printf("\n\t1. Decimal to binary     \t4. Binary to decimal    \t7. Octal to binary      \t10. Hexadecimal to binary");
	printf("\n\t2. Decimal to octal      \t5. Binary to octal      \t8. Octal to decimal     \t11. Hexadecimal to octal");
	printf("\n\t3. Decimal to hexadecimal\t6. Binary to hexadecimal\t9. Octal to hexadecimal \t12. Hexadecimal to decimal");
	printf("\n\tWhich conversion perform ? Enter that number :- ");
	scanf("%d", &i);
	return i;
}

int convert(int number, int number_base, int result_base) { // here result_base change 8 then this function will convert decimal to octal.
	// if binary to decimal/octal convert then, base is 2. if decimal to binary/octal convert then base is 10
	int result = 0, placeValue = 1;

	while (number > 0) {
		int last_digit = number % result_base;
		number /= result_base;
		result += last_digit * placeValue;
		placeValue *= number_base;
	}

	return result;
}

void decimal_to_binary(int decimal) {
	int binary[MAX], i = 0, n = decimal;
	while (n > 0) {
		binary[i++] = n % 2;
		n /= 2;
	}
	printf("\n\t%d decimal to binary = ", decimal);
	display(binary, i);
}

void display(int a[], int size) {
	int i;
	for (i = size - 1;i >= 0;i--) {
		printf("%d", a[i]);
	}
}