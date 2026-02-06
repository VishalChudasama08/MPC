// Circulate Queue

#include<stdio.h>
#include<conio.h>
#define size 4

int queue[size];
int front=-1;
int rear=-1;

int menu();
void enqueue(int);
void dequeue();
int peek(int *);
int isFull();
int isEmpty();
void traversal();

int main(){
	int val, ans, p;
	clrscr();

	do{
		switch(menu()){
			case 0: exit();
			case 1:
				printf("\n\tEnter value to add in queue: ");
				scanf("%d", &val);
				enqueue(val);
				break;
			case 2: dequeue(); break;
			case 3:
				if(peek(&p)){
					printf("\n\tPeeked Value: %d\n", p);
				} else {
					printf("\n\tQueue Underflow\n");
				}
				break;
			case 4:
				if(isFull()){
					printf("\n\tYes, Queue is full\n");
				} else {
					printf("\n\tNo, Queue is not full\n");
				}
				break;
			case 5:
				if(isEmpty()){
					printf("\n\tYes, Queue is empty\n");
				} else {
					printf("\n\tNo, Queue is not empty\n");
				}
				break;
			case 6: traversal(); break;
			default: printf("\nEnter valid number!\n");
		}
	}while(1);
}
void enqueue(int val){
	if(isFull()){
		printf("\n\tQueue is full!\n");
		return;
	}
	if(front==-1 && rear==-1) {
		front=0;
		rear=0;
		queue[rear]=val;
	} else if(rear>=front && rear!=size-1){ // simple queue condition
		rear++;
		queue[rear]=val;
	} else { // curcular queue condition
		if(rear==size-1){ rear=0; } else { rear++; }
		queue[rear]=val;
	}
	printf("\n\tValue added in queue\n");
}

void dequeue(){
	if(isEmpty()){
		printf("\n\tQueue is empty!\n");
		return;
	}
	printf("\n\tDequeue value: %d", queue[front]);
	if(front==rear){ // front at last position
		front=-1;
		rear=-1;
	} else if(front==size-1 && front>rear){ // front at last index, queue not empty
		front=0;
	} else {
		front++;
	}
}
void traversal(){
	int i;
	printf("\n\tQueue ");
	if(isEmpty()){
		printf("is Empty\n");
		return;
	}
	if(front<=rear){ // simple queue
		for(i=front; i<=rear; i++){
			printf("%d  ", queue[i]);
		}
	} else { // circular queue
		for(i=front; i<size; i++){
			printf("%d  ", queue[i]);
		}
		for(i=0; i<=rear; i++){
			printf("%d  ", queue[i]);
		}
	}
	printf("end!\n");
}
int isFull(){
  if(front==0 && rear==size-1){
	return 1;
  } else if(front-1==rear){
	return 1;
  } else {
	return 0;
  }
}

int isEmpty(){
  if(front == -1 && rear == -1){
	return 1;
  } else {
	return 0;
  }
}
int peek(int *value){
	if(front==-1 && rear==-1){
		return 0;
	} else {
		*value = queue[front];
		return 1;
	}
}
int menu(){
	int x;
	printf("\n\t0. Exit program");
	printf("\n\t1. enqueue");
	printf("\n\t2. dequeue");
	printf("\n\t3. peek");
	printf("\n\t4. isfull");
	printf("\n\t5. isempty");
	printf("\n\t6. Traversal");
	printf("\n\tEnter your choise: ");
	scanf("%d", &x);
	return x;
}