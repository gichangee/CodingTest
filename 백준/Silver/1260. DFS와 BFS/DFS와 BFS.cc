#include<iostream>
using namespace std;

typedef struct snode {
	int snd;
	snode* Prev;
}SNode;

typedef struct qnode {
	int qnd;
	qnode* Next;
}QNode;

typedef struct stack {
	int size;
	SNode* Top;
}Stack;

typedef struct queue {
	int size;
	QNode* Head;
	QNode* Tail;
}Queue;

Stack* CreateStack() {
	Stack* Sta = new Stack;
	Sta->size = 0;
	Sta->Top = NULL;
	return Sta;
}

Queue* CreateQueue() {
	Queue* Que = new Queue;
	Que->Head = NULL;
	Que->Tail = NULL;
	Que->size = 0;
	return Que;
}

void PushStack(Stack* Sta, int nd) {
	SNode* NewNode = new SNode;
	NewNode->snd = nd;
	NewNode->Prev = NULL;
	if (Sta->size == 0) {
		Sta->Top = NewNode;
	}
	else {
		NewNode->Prev = Sta->Top;
		Sta->Top = NewNode;
	}
	Sta->size++;
}

void PushQueue(Queue* Que, int nd) {
	QNode* NewNode = new QNode;
	NewNode->qnd = nd;
	NewNode->Next = NULL;
	if (Que->size == 0) {
		Que->Head = NewNode;
		Que->Tail = NewNode;
	}
	else {
		Que->Tail->Next = NewNode;
		Que->Tail = NewNode;
	}
	Que->size++;
}

void PopStack(Stack* Sta) {
	if (Sta->size != 0) {
		SNode* temp = Sta->Top;
		Sta->Top = temp->Prev;
		delete temp;
		Sta->size--;
	}
}

void PopQueue(Queue* Que) {
	if (Que->size != 0) {
		QNode* temp = Que->Head;
		Que->Head = temp->Next;
		delete temp;
		Que->size--;
	}
}

void DeleteStack(Stack* Sta) {
	while (Sta->size !=0)
	{
		PopStack(Sta);
	}
}

void DeleteQueue(Queue* Que) {
	while (Que->size!=0)
	{
		PopQueue(Que);
	}
}


bool map[1005][1005] = { 0, };
int RN, RM, RV;

void DFS(){
	bool mapcheck[1005] = { 0, };
	int dfsAnswer[1005] = { 0, };
	int dfsAnswercnt = 0;
	Stack* Sta = CreateStack();
	PushStack(Sta, RV);
	mapcheck[RV] = true;
	dfsAnswer[dfsAnswercnt] = RV;
	dfsAnswercnt++;
	while (Sta->size != 0)
	{
		bool pushokay = false;
		int FV = Sta->Top->snd;
		for (int i = 1; i <= RN; i++) {
			if (map[FV][i] == true && mapcheck[i] == false) {
				mapcheck[i] = true;
				PushStack(Sta, i);
				pushokay = true;
				dfsAnswer[dfsAnswercnt] = i;
				dfsAnswercnt++;
				break;
			}
		}
		if (pushokay == false) {
			PopStack(Sta);
		}
	}
	for (int i = 0; i < dfsAnswercnt; i++) {
		cout << dfsAnswer[i] << " ";
	}
	cout <<"\n";
}
void BFS() {
	bool mapcheck[1005] = { 0, };
	int bfsAnswer[1005] = { 0, };
	int bfsAnswercnt = 0;
	Queue* Que = CreateQueue();
	PushQueue(Que, RV);
	mapcheck[RV] = true;
	bfsAnswer[bfsAnswercnt] = RV;
	bfsAnswercnt++;
	while (Que->size != 0)
	{
		bool pushokay = false;
		int FV = Que->Head->qnd;
		for (int i = 1; i <= RN; i++) {
			if (map[FV][i] == true && mapcheck[i] == false) {
				mapcheck[i] = true;
				PushQueue(Que, i);
				pushokay = true;
				bfsAnswer[bfsAnswercnt] = i;
				bfsAnswercnt++;
			}
		}
		if (pushokay == false) {
			PopQueue(Que);
		}
	}
	for (int i = 0; i < bfsAnswercnt; i++) {
		cout << bfsAnswer[i] << " ";
	}
	cout << "\n";
}

int main(void) {
	cin >> RN >> RM >> RV;

	for (int i = 0; i < RM; i++) {
		int a, b;
		cin >> a >> b;
		map[a][b] = true;
		map[b][a] = true;
	}

	DFS();
	BFS();

	return 0;
}