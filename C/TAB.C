#include <stdio.h>
#include <stdarg.h>   /* <-- needed for va_list, va_start, va_end */

/* global column tracker so tabs align across calls */
static int tab4_col = 0;

/* expands tabs (\t) into 4-column stops */
static int puts4_expand(const char* s) {
	int i, j, spaces, count;
	count = 0;

	for (i = 0; s[i] != '\0'; i++) {
		if (s[i] == '\t') {
			spaces = 4 - (tab4_col % 4);
			for (j = 0; j < spaces; j++) {
				putchar(' ');
				tab4_col++;
				count++;
			}
		}
		else {
			putchar(s[i]);
			if (s[i] == '\n') {
				tab4_col = 0;   /* reset at newline */
			}
			else {
				tab4_col++;
			}
			count++;
		}
	}
	return count;
}

/* printf-like wrapper */
int print4t(const char* fmt, ...) {
	char buf[1024];   /* buffer for formatted text */
	va_list ap;
	int printed;

	buf[0] = '\0';

	va_start(ap, fmt);
	vsprintf(buf, fmt, ap);   /* Turbo C++ has this */
	va_end(ap);

	printed = puts4_expand(buf);
	return printed;
}

int main() {
	char name[] = "HelloHelloo\t\tWorld";

	print4t("%s\n", "Hello\tWorld");
	print4t("%s\n", name);
	print4t("%s %s\n", name, name);
	print4t("Col1\tCol2\tCol3\n");
	print4t("A\tBB\tCCC\n");
	printf("%s\n", "Hello\tWorld");
	printf("%s\n", name);
	printf("%s %s\n", name, name);
	printf("Col1\tCol2\tCol3\n");
	printf("A\tBB\tCCC\n");

	return 0;
}
