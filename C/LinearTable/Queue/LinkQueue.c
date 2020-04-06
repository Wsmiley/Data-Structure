#include<stdio.h>
#include<stdlib.h>
#include"LinkQueue.h"


LinkQueue *CreateLinkQueue(){
    LinkQueue *LQ=(LinkQueue*)malloc(sizeof(LinkQueue));
    if(LQ==NULL){
        printf("malloc failed\n");
        return NULL;
    }
    return LQ;
}

void InitQueue(LinkQueue *Q){
    Q->front=Q->rear=CreateNode();
    if(!Q->front||!Q->rear){
        printf("malloc failed\n");
        return;
    }
    Q->front->next=NULL;
}

bool LinkQueueIsEmpty(LinkQueue *Q){
    return Q->front==Q->rear;
}

void EnLinkQueue(LinkQueue *Q,ElementType data){
    Node *Qnode=(Node*)malloc(sizeof(Node));
    Qnode->data=data;
    Qnode->next=NULL;
    Q->rear->next=Qnode;
    Q->rear=Qnode;
}

ElementType DeLinkQueue(LinkQueue *Q){
    if (LinkQueueIsEmpty(Q)){
        printf("LinkQueue Is Empty\n");
        return NULL;
    }
    ElementType data;
    Node *p=Q->front->next;
    Q->front->next=p->next;
    data=p->data;
    if(Q->rear==p){
        Q->rear=Q->front;
    }
    free(p);
    return data;    
}

ElementType GetLinkQueue(LinkQueue *Q){
    if(LinkQueueIsEmpty(Q)){
        printf("LinkQueue Is Empty\n");
        return NULL;
    }
    return Q->front->next->data;
}

bool ClearLinkQueue(LinkQueue *Q){
    Node *p,*q;
    Q->rear=Q->front;
    p=Q->front->next;
    Q->front->next=NULL;
    while (p){
        q=p;
        p=p->next;
        free(q);
    }
    return true;
    
}


void printLinkQueue(LinkQueue *Q){
    if (LinkQueueIsEmpty(Q)){
        printf("LinkQueue Is Empty\n");
        return;
    }
    Node *p=Q->front->next;
    while (p){
        printf("%d ",p->data);
        p=p->next;
    }
    printf("\n");
    
}

int main(void){
    LinkQueue *linkqueue=CreateLinkQueue();
    InitQueue(linkqueue);
    EnLinkQueue(linkqueue,41);
    EnLinkQueue(linkqueue,31);
    EnLinkQueue(linkqueue,13);
    EnLinkQueue(linkqueue,12);
    EnLinkQueue(linkqueue,56);
    printLinkQueue(linkqueue);
    printf("Dequeue:%d\n",DeLinkQueue(linkqueue));
    printf("Dequeue:%d\n",DeLinkQueue(linkqueue));
    printf("Dequeue:%d\n",DeLinkQueue(linkqueue));
    printf("Getqueue:%d\n",GetLinkQueue(linkqueue));
    printf("Dequeue:%d\n",DeLinkQueue(linkqueue));
    EnLinkQueue(linkqueue,56);
    EnLinkQueue(linkqueue,12);
    printLinkQueue(linkqueue);
    ClearLinkQueue(linkqueue);
    printLinkQueue(linkqueue);
    return 0;
}