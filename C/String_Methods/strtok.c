// strtok(<string>, <delimiter>) - split string
// 1st argument: original string. (that string you won to need it part) noted: the original string is changed. after first call original string is store first part.
// 2nd argument: delimiter (that part by using this user do seprate). (this part remove from return value)
// return: part of string at the end return NULL

#include<stdio.h>
#include<conio.h>

int main() {
	char line[] = "string line only.";

	printf("    line is: %s\n", line); // this will print "string line only."
	printf("Using strtok to split the line:\n\n");
	char* part1 = strtok(line, " "); // this is strtok first call than provide line as first argument and second argument is string delimiter (here delimiter is space)
	printf("\tFirst part: %s %d\n"); // this will print "string"
	printf("now line is: %s\n\n", line); // this will print "string" because strtok modify original string

	char* part2 = strtok(NULL, " "); // now this is 2nd call then first argument is NULL, only first calling time provide main string and another all time argument is NULL. at the end strtok return NULL means now all part is done
	printf("\tSecond part: %s\n", part2); // this will print "line"
	printf("now line is: %s\n\n", line); // this will print "string" because strtok modify original string

	char* part3 = strtok(NULL, " "); // now this is 3rd call then first argument is NULL
	printf("\tSecond part: %s\n", part3); // this will print "only."
	printf("now line is: %s\n\n", line); // this will print "string" because strtok modify original string

	char* part4 = strtok(NULL, " "); // now this is 4rd call then first argument is NULL
	printf("\tSecond part: %s\n", part4); // this will print "NULL"
	printf("now line is: %s\n\n", line); // this will print "string" because strtok modify original string

	printf("length of parts is %d %d %d", strlen(part1), strlen(part2), strlen(part3));
	return 0;
}