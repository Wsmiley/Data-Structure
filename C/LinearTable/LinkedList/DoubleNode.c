#include<stdio.h>
#include<stdlib.h>
#include"DoubleNode.h"


DoubleNode *CreateDoubleNode(){
    DoubleNode *doublenode=(DoubleNode*)malloc(sizeof(DoubleNode));
    return doublenode;
}