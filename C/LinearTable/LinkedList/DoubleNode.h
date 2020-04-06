#ifndef __DOUBLENODE__H
#define __DOUBLENODE__H

#define ElementType int

struct _DoubleNode{
    ElementType data;
    struct _DoubleNode *prior,*next;
};

typedef struct _DoubleNode DoubleNode;

DoubleNode *CreateDoubleNode();

#endif