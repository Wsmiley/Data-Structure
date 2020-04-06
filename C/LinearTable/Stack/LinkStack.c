#include<stdio.h>
#include<stdlib.h>
#include"LinkStack.h"

LinkStack *CreateSeqStack(){
    LinkStack *head=(LinkStack*)malloc(sizeof(LinkStack));
    head->next=NULL;
    return head;
}

bool LinkStackIsEmpty(LinkStack *stack){
    return (stack->next==NULL);
}

void PushLinkStack(LinkStack *stack,ElementType data){
    LinkStack *in=(LinkStack*)malloc(sizeof(LinkStack));
    in->data=data;
    in->next=stack->next;
    stack->next=in;
}

ElementType PopLinkStack(LinkStack *stack){
    ElementType data;
    if(LinkStackIsEmpty(stack)){
        printf("LinStack is empty \n");
        return NULL;        
    }
    LinkStack *p=stack->next;
    data=p->data;
    stack->next=p->next;
    free(p);
    return data;
}

ElementType GetLinkStack(LinkStack *stack){
    ElementType data;
    if(LinkStackIsEmpty(stack)){
        printf("LinStack is empty \n");
        return NULL;        
    }
    return stack->next->data;
}

void printLinkStack(LinkStack *stack){
    LinkStack *s=stack->next;
    while (s!=NULL){
        printf("%d ",s->data);
        s=s->next;
    }
}


int main(void){
    LinkStack *s=CreateSeqStack();
    PushLinkStack(s,1);
    PushLinkStack(s,17);
    PushLinkStack(s,11);
    PushLinkStack(s,2);
    PushLinkStack(s,4);
    PushLinkStack(s,2);
    PushLinkStack(s,5);
    printf("%d\n",PopLinkStack(s));
    printf("%d\n",GetLinkStack(s));
    printLinkStack(s);
    return 0;
}


