/*Draw shapes using C graphics
This C  graphics program draws basic shapes such as circle, line, rectangle, ellipse and display text on screen using C graphics. This can be a first graphics program for a beginner.*/
#include<graphics.h>
#include<conio.h>
main() {
	int gd = DETECT, gm, left = 100, top = 100, right = 200, bottom = 200, x = 300, y = 150, radius = 50;

	initgraph(&gd, &gm, "C:\\TURBOC3\\BGI");

	rectangle(left, top, right, bottom);
	circle(x, y, radius);
	bar(left + 300, top, right + 300, bottom);
	line(left - 10, top + 150, left + 410, top + 150);
	ellipse(x, y + 200, 0, 360, 100, 50);
	outtextxy(left + 100, top + 325, "My first C graphics program");

	getch();
	closegraph();
	return 0;
}