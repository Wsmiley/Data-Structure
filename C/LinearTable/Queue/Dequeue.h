#ifndef __DEQUEUE__H
#define __DEQUEUE__H
#include<stdbool.h>
#include"..\LinkedList\Node.c"

struct _DeQueue{
    Node *front;
    Node *rear;
};

typedef struct _DeQueue DeQueue;

DeQueue *CreateDeQueue();
void EnFrontDeQueue(DeQueue *DQ,ElementType data);
void EnRearDeQueue(DeQueue *DQ,ElementType data);
ElementType PopFrontDequeue(DeQueue *DQ);
ElementType PopRearQueue(DeQueue *DQ);
void printDeQueue(DeQueue *DQ);

#endif