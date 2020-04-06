#ifndef __QUEUE__H
#define __QUEUE__H
#include<stdbool.h>
#define ElementType int
#define MAXSIZE 5
struct _SeqQueue{
    ElementType data[MAXSIZE];
    int front,rear;
};

typedef struct _SeqQueue SeqQueue;

SeqQueue *CreateSeqQueue();
bool SeqQueueIsEmpty(SeqQueue *queue);
bool SeqQueueFull(SeqQueue *queue);
bool EnSeqQueue(SeqQueue *queue,ElementType data);
ElementType DeSeqQueue(SeqQueue *queue);
ElementType GetSeqQueue(SeqQueue *queue);
void printSeqQueue(SeqQueue *queue);
#endif