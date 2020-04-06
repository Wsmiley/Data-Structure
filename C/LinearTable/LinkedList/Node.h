#ifndef __NODE__H
#define __NODE__H

#define ElementType int

struct _Node{
    ElementType data;
    struct _Node *next;
};

typedef struct _Node Node;

Node *CreateNode();

#endif