#include<stdio.h>
#include<stdlib.h>
#include"Node.h"


Node *CreateNode(){
    Node *node=(Node*)malloc(sizeof(Node));
    return node;
}