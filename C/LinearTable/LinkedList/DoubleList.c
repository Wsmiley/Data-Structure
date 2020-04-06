#include<stdio.h>
#include"DoubleNode.c"

#define Position int

DoubleNode* CreateDoubleList(ElementType array[],int lenght);
void InsertDoubleNode(DoubleNode *doubleNode,ElementType data,Position p);
void DeleteDoubleNode(DoubleNode *doubleNode,Position p);
Position ReturnIndex(DoubleNode *doubleNode,ElementType data);
void Reverse(DoubleNode *doubleNode);
int Size(DoubleNode *doubleNode);
int IsEmpty(DoubleNode *doubleNode);
void printDoubleList(DoubleNode *doubleNode);

int main(void){
    ElementType array[]={1,7,3,5,4,6,2};
    int length=sizeof(array)/sizeof(ElementType);
    DoubleNode *dounode=CreateDoubleList(array,length);
    printDoubleList(dounode);
    InsertDoubleNode(dounode,10,5);
    printDoubleList(dounode);
    printf("index=%d\n",ReturnIndex(dounode,10));
    DeleteDoubleNode(dounode,5);
    printDoubleList(dounode);
    Reverse(dounode);
    printDoubleList(dounode);
    return 0;
}


DoubleNode* CreateDoubleList(ElementType array[],int length){
    DoubleNode *dounode=CreateDoubleNode();
    DoubleNode *head=dounode;
      for(int i=0;i<length;i++){
        DoubleNode *p=CreateDoubleNode();
        p->data=array[i];
        p->next=NULL;
        p->prior=head;
        head->next=p;
        head=head->next;
    }
    return dounode;
}

void InsertDoubleNode(DoubleNode *doublenode,ElementType data,Position p){
    DoubleNode *head=doublenode;
    for(int i=1;i<p;i++){
        if(head->next==NULL){
            printf("Insert position is invalid,So insert to the end\n");
            break;
        }
        head=head->next;
    }
   DoubleNode *temp=CreateDoubleNode();
   temp->data=data;
   temp->next=head->next;
   head->next->prior=temp;
   head->next=temp;
   temp->prior=head;
}


void DeleteDoubleNode(DoubleNode *doubleNode,Position p){
    DoubleNode *head=doubleNode;
    for(int i=1;i<p;i++){
        if(head->next==NULL){
            printf("Delete position is invalid");
            return;
        }
        head=head->next;
    }
    DoubleNode *del=head->next;
    head->next=head->next->next;
    head->next->next->prior=head;
    free(del);
}

Position ReturnIndex(DoubleNode *doubleNode,ElementType data){
    DoubleNode *head=doubleNode->next;
    int count=1;
    while (head->next!=NULL){
        if(head->data==data){
            return count;
        }
        count++;
        head=head->next;
    }
    return -1;
}

void Reverse(DoubleNode *doubleNode){
    if(IsEmpty(doubleNode))
        return;
    DoubleNode *head=doubleNode->next;
    DoubleNode *temp=NULL; 
    DoubleNode *front=NULL; 
    while (head!=NULL){
        temp=head->next;
        head->next=front;
        head->prior=temp;
        front=head;
        head=temp;
    }
    doubleNode->next=front;
    
}

int Size(DoubleNode *doubleNode){
    DoubleNode *head=doubleNode->next;
    int count=0;
    while (head!=NULL)
    {
        count++;
        head=head->next;
    }
    return count;
}

/*
return 0:not empty
return 1:is empty
*/
int IsEmpty(DoubleNode *doubleNode){
    if (doubleNode->next==NULL)
        return 1;
    return 0;
}
void printDoubleList(DoubleNode *doubleNode){
    if(IsEmpty(doubleNode))
        return;
    DoubleNode *head=doubleNode;
    printf("DoubleList{");
    while (head->next!=NULL){
        head=head->next;
        printf("%d",head->data);
        if(head->next!=NULL)
            printf(",");
    }
    printf("}\n");
}