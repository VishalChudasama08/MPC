// find repeated number count 
// ex 1. {30, 30, -1, 31, 31, 31, 32} => 3
// ex 2. {10, 10, 20, 10, 10, 10, 10, 30, 40} => 4
// ex 3. {1, 2, 3, 4, 5} => 1
// ex 4. {1,1,2,2,1,1} => 2

#include<stdio.h>
#include<conio.h>

int main() {
	int n, arr[30], i, j, count = 0, max = 0;

	printf("\n\tEnter element number: ");
	scanf("%d", &n);

	printf("\n\tEnter %d numbers: ", n);
	for (i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	printf("\n");
	for (i = 0; i < n; i++) {
		printf("\t%d", arr[i]);
	}

	i = 0;
	j = 0;
	while (j < n) {
		if (arr[i] == arr[j]) {
			count++;
		}
		else {
			if (count > max) {
				max = count;
			}
			count = 0;
			i = j;
			j--;
		}
		j++;
	}
	printf("\n\tanswer: %d", max);

	return 0;
}