#include<stdio.h>
#include"Dequeue.h"

DeQueue *CreateDeQueue(){
    DeQueue *DQ=(DeQueue*)malloc(sizeof(DeQueue));
    DQ->front=DQ->rear=(Node*)malloc(sizeof(Node));
    Node *node=(Node*)malloc(sizeof(Node));
    if(DQ==NULL||node==NULL||DQ->front==NULL||DQ->rear==NULL){
        printf("malloc failed\n");
        return NULL;
    }
    DQ->front=node;
    DQ->rear=node;
    return DQ;
}

// front insert
void EnFrontDeQueue(DeQueue *DQ,ElementType data){
    Node *node=(Node*)malloc(sizeof(Node));
    node->data=data;
    if(DQ->front==DQ->rear){
        DQ->front->next=node;
        node->next=NULL;
        DQ->rear=node;
        return;
    }
    node->next=DQ->front->next;
    DQ->front->next=node;
}
//rear insert
void EnRearDeQueue(DeQueue *DQ,ElementType data){
    Node *node=(Node*)malloc(sizeof(Node));
    node->data=data;
    if(DQ->front==DQ->rear){
        DQ->front->next=node;
        node->next=NULL;
        DQ->rear=node;
        return;
    }
    DQ->rear->next=node;
    node->next=NULL;
    DQ->rear=node;
}

ElementType PopFrontDequeue(DeQueue *DQ){
    if(DQ->front==DQ->rear){
        printf("DeQueue is Empty");
        return NULL;        
    }
    Node *p=DQ->front->next;
    ElementType data=p->data;
    if(DQ->front->next==DQ->rear){
        DQ->rear=DQ->front;
        DQ->rear->next=NULL;
        free(p);
        return data;
    }
    DQ->front->next=p->next;
    free(p);
    return data;
}

ElementType PopRearQueue(DeQueue *DQ){
    Node *p;
    Node *q=DQ->front;
    ElementType data;
    if(DQ->front==DQ->rear){
        printf("DeQueue is Empty");
        return NULL;   
    }
    p=DQ->rear;
    data=p->data;
    while (q->next!=DQ->rear){
        q=q->next;
    }
    DQ->rear=q;
    DQ->rear->next=NULL;
    free(p);
    return data;
}

void printDeQueue(DeQueue *DQ){
    Node *p=DQ->front->next;
    while (p!=NULL){
        printf("%d ",p->data);
        p=p->next;
    }
    printf("\n");
}


int main(void){
    DeQueue *DQ;
    DQ=CreateDeQueue();
    EnFrontDeQueue(DQ,1);
    EnFrontDeQueue(DQ,3);
    EnFrontDeQueue(DQ,4);
    EnRearDeQueue(DQ,2);
    printDeQueue(DQ);
    printf("PopRearQueue:%d\n",PopRearQueue(DQ));
    printf("PopfrontQueue:%d\n",PopFrontDequeue(DQ));
    printDeQueue(DQ);
    EnFrontDeQueue(DQ,2);
    EnFrontDeQueue(DQ,23);
    EnFrontDeQueue(DQ,55);
    EnRearDeQueue(DQ,4);
    EnRearDeQueue(DQ,11);
    printDeQueue(DQ);
}