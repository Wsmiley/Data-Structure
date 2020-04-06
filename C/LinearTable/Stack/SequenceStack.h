#ifndef __SEQUENCESTACK__H
#define __SEQUENCESTACK__H
#include<stdbool.h>
#define ElementType int
#define MAXSIZE 10

struct _SeqStack{
    ElementType data[MAXSIZE];
    ElementType top;
};

typedef struct _SeqStack SeqStack;

SeqStack *CreateSeqStack();
bool SeqStackIsEmpty(SeqStack *stack);
bool SeqStackFull(SeqStack *stack);
int PushSeqStack(SeqStack *stack,ElementType data);
ElementType PopSeqStack(SeqStack *stack);
ElementType GetSeqStack(SeqStack *stack);
void printSeqStack(SeqStack *stack);
#endif