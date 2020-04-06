#ifndef __LINSTACK__H
#define __LINSTACK__H
#include<stdbool.h>
#define ElementType int

struct _LinkStack{
    ElementType data;
    struct _LinkStack *next;
};

typedef struct _LinkStack LinkStack;

LinkStack *CreateSeqStack();
bool LinkStackIsEmpty(LinkStack *stack);
void PushLinkStack(LinkStack *stack,ElementType data);
ElementType PopLinkStack(LinkStack *stack);
ElementType GetLinkStack(LinkStack *stack);
void printLinkStack(LinkStack *stack);
#endif