#include<stdio.h>
#include"SequenceStack.h"
#include<stdlib.h>


SeqStack *CreateSeqStack(){
    SeqStack *stack;
    stack=(SeqStack*)malloc(sizeof(ElementType)*MAXSIZE);
    stack->top=-1;
    return stack;
}
bool SeqStackIsEmpty(SeqStack *stack){
    return (stack->top==-1?true:false);
}
bool SeqStackFull(SeqStack *stack){
    return (stack->top==MAXSIZE-1?true:false);
}

int PushSeqStack(SeqStack *stack,ElementType data){
    if(SeqStackFull(stack)){
        printf("stack is full\n");
        return 0;
    }
        
    stack->data[++stack->top]=data;
    return 1;
}

ElementType PopSeqStack(SeqStack *stack){
    if (SeqStackIsEmpty(stack)){
        printf("stack is empty\n");
        return NULL;
    }
    ElementType data=stack->data[stack->top--];
    return data;
}

void printSeqStack(SeqStack *stack){
    if (SeqStackIsEmpty(stack)){
       printf("stack is empty\n");
       return;
    }
    int count=stack->top;
    while (count!=-1){
        printf("stack element:%d\n",stack->data[count--]);
    }
    
}

ElementType GetSeqStack(SeqStack *stack){
    if (SeqStackIsEmpty(stack)){
        printf("stack is empty\n");
        return;
    }
    return stack->data[stack->top];
}

int main(void){
    SeqStack *st=CreateSeqStack();
    PushSeqStack(st,5);
    PushSeqStack(st,3);
    PushSeqStack(st,1);
    PushSeqStack(st,4);
    PushSeqStack(st,2);
    ElementType data;
    data=PopSeqStack(st);
    printf("pop data=%d\n",data);
    printSeqStack(st);
    return 0;
}