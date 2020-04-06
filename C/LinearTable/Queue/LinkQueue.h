#ifndef __LINKQUEUE__H
#define __LINKQUEUE__H
#include<stdbool.h>
#include"..\LinkedList\Node.c"


struct _LinkQueue{
    Node *front,*rear;
};

typedef struct _LinkQueue LinkQueue;

LinkQueue *CreateLinkQueue();
void InitQueue(LinkQueue *Q);
bool LinkQueueIsEmpty(LinkQueue *Q);
void EnLinkQueue(LinkQueue *Q,ElementType data);
ElementType DeLinkQueue(LinkQueue *Q);
ElementType GetLinkQueue(LinkQueue *Q);
bool ClearLinkQueue(LinkQueue *Q);
void printLinkQueue(LinkQueue *Q);

#endif