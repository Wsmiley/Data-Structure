/*
**round-robin queue**
*/
#include<stdio.h>
#include"queue.h"


SeqQueue *CreateSeqQueue(){ 
    SeqQueue *seqQueue;
    seqQueue=(SeqQueue*)malloc(sizeof(ElementType)*MAXSIZE);
    if(NULL == seqQueue)
    {
        printf("malloc failed\n");
        return NULL;
    }
    seqQueue->front=0;
    seqQueue->rear=0;
    return seqQueue;
}


bool SeqQueueIsEmpty(SeqQueue *queue){
    return queue->front==queue->rear;
}

bool SeqQueueFull(SeqQueue *queue){
    return (queue->rear+1)%MAXSIZE==queue->front;
}
bool EnSeqQueue(SeqQueue *queue,ElementType data){
    if(SeqQueueFull(queue)){
        printf("SeqQueue is Full\n");
        return false;
    }
    queue->data[queue->rear]=data;
    queue->rear=(queue->rear+1)%MAXSIZE;
    return true;
}

ElementType DeSeqQueue(SeqQueue *queue){
    if(SeqQueueIsEmpty(queue))
        return NULL;
    ElementType data=queue->data[queue->front];
    queue->front=(queue->front+1)%MAXSIZE;
    return data;
    
}
ElementType GetSeqQueue(SeqQueue *queue){
    return queue->data[queue->front];
}


void printSeqQueue(SeqQueue *queue){
    int num=(queue->rear-queue->front+MAXSIZE)%MAXSIZE;
    int count=queue->front;
    for(int i=0;i<num;i++){
        printf("%d ",queue->data[count]);
        count++;
    }
}
int main(void){
    SeqQueue *sq=CreateSeqQueue();
    printf("%d\n",SeqQueueIsEmpty(sq));
    printf("%d\n",SeqQueueFull(sq));
    EnSeqQueue(sq,1);
    EnSeqQueue(sq,2);
    EnSeqQueue(sq,3);
    EnSeqQueue(sq,5);
    ElementType data=GetSeqQueue(sq);
    printf("data=%d\n",data);
    ElementType data1=DeSeqQueue(sq);
    printf("data1=%d\n",data1);
    EnSeqQueue(sq,4);
    printSeqQueue(sq);
    return 0;
}