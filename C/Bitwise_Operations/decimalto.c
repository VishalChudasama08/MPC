/* decimal to binary using bitwise operator */

#include<stdio.h>
#include<conio.h>

void decimalToBinaryBitwise(int);

int main() {
	int n;
	//clrscr();
	printf("\n\tEnter Decimal number: ");
	scanf("%d", &n);

	printf("Decimal = %d", n);
	printf("\nBinaryBitwise = ");
	decimalToBinaryBitwise(n);
	//getch();
	return 0;
}

void decimalToBinaryBitwise(int n) {
	int i;
	int size = sizeof(n) * 8; // normally 32 bits.
	// printf("size = %d\n", size);

	int flag = 0;

	for (i = size - 1; i >= 0; i--) {
		int bit = (n >> i) & 1; // this line do: right shit remove bit and & (AND) operator return only that bit. 
		// ex. n=5, i=2 then: (101 >> 2) => 1 , 1 & 1 => 1
		// ex. n=8, i=2 then: (1000 >> 2) => 10 & 01 => 00 (previous add any amount of 0 it's okay)
		// printf("i%d", i);
		// printf("b%d\t", bit);

		if (bit == 1 && flag == 0) { // one time condition true then another all time condition is false
			flag = 1; // Set flag to indicate first 1 has been found
			// printf("%d\t", bit);
		}
		if (flag == 1) { // start printing bits after the first 1 found. because previous 0 are not meaningful in binary representation.
			printf("%d", bit);
		}
	}
}