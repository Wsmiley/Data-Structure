#include<stdio.h>
#include<stdlib.h>
#include"Node.c"

#define Position int


Node* CreateSingleList(ElementType array[],int length);
void InsertNode(Node *node,ElementType data,Position p);
ElementType DeleteNode(Node *node,Position p);
Position ReturnIndex(Node *node,ElementType data);
void Reverse(Node *node);
int Size(Node *node);
int IsEmpty(Node *node);
void printSingleList(Node *node);
void Sort(Node *node);
//逆序递归
void ReversePrint(Node *node);
void JosephCycle(Node *node,int start,int distance);

int main(void){
    ElementType array[]={1,7,3,5,4,6,2};
    int length=sizeof(array)/sizeof(ElementType);
    Node *node=CreateSingleList(array,length);
    printSingleList(node);
    InsertNode(node,10,3);
    printSingleList(node);
    DeleteNode(node,8);
    printSingleList(node);
    Position index=0;
    index=ReturnIndex(node,11);
    printf("index=%d\n",index);
    Reverse1(node);
    printSingleList(node);
    int size=Size(node);
    printf("size=%d\n",size);
    printf("bool=%d\n",IsEmpty(node));
    Sort(node);
    ReversePrint(node);
    JosephCycle(node,0,2);
    printSingleList(node);
    return 0;

}


Node* CreateSingleList(ElementType array[],int length){
    Node *node=CreateNode();
    Node *head=node;
    head->data=NULL;
    for(int i=0;i<length;i++){
        Node *p=CreateNode();
        p->data=array[i];
        p->next=NULL;
        head->next=p;
        head=head->next;
    }
    return node;
}
void InsertNode(Node *node,ElementType data,Position p){
    Node *temp=node;
    for(int i=1;i<p;i++){
        if(temp->next==NULL){
            printf("Insert position is invalid,So insert to the end\n");
            break;
        }
        temp=temp->next;
    }
    Node *addnode=CreateNode();
    addnode->data=data;
    addnode->next=temp->next;
    temp->next=addnode;
}

ElementType DeleteNode(Node *node,Position p){
    Node *head=node;
    ElementType data;
    for(int i=1;i<p;i++){
        if(head->next==NULL){
            printf("Delete position is invalid");
            return NULL;
        }
        head=head->next;
    }
    Node *del=head->next;
    data=del->data;
    head->next=head->next->next;
    free(del);
    return data;
}

Position ReturnIndex(Node *node,ElementType data){
    Node *head=node->next;
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

int Size(Node *node){
    Node *head=node;
    int count=0;
    while (head->next!=NULL)
    {
        count++;
        head=head->next;
    }
    return count;
    
}

void Reverse(Node *node){
    if(IsEmpty(node))
        return;
    Node *head=node->next;
    Node *temp=NULL;
    Node *front=NULL;
    while (head!=NULL){
        temp=head->next;
        head->next=front;
        front=head;
        head=temp;
    }
    node->next=front;
    
}

/*
return 0:not empty
return 1:is empty
*/
int IsEmpty(Node *node){
    if (node->next==NULL)
        return 1;
    return 0;
}

void Sort(Node *node){
    if(IsEmpty(node))
        return;
    Node *p=NULL;
    int ischange=1;
    while (p!=node->next&&ischange){
        Node *q=node;
        ischange=0;
        for(;q->next&&q->next!=p;q=q->next){
            if(q->data>q->next->data){
                ElementType temp;
                temp=q->data;
                q->data=q->next->data;
                q->next->data=temp;
                ischange=1;
            }
        }
        printSingleList(node);
        p=q;
    }
}

void printSingleList(Node *node){
    if(IsEmpty(node))
        return;
    Node *head=node;
    printf("SingleList{");
    while (head->next!=NULL){
        head=head->next;
        printf("%d",head->data);
        if(head->next!=NULL)
            printf(",");
    }
    printf("}\n");
}

void ReversePrint(Node *node){
    if(node==NULL)
        return;
    ReversePrint(node->next);
    if(node->data!=NULL)
        printf("%d ",node->data);

}

void JosephCycle(Node *node,int start,int distance){
    int i=start;
    ElementType data;
    while (Size(node)>1){
        i=(i+distance-1)%Size(node);
        data=DeleteNode(node,i);
        printf("kill:%d\n",data);
        printSingleList(node);
    }
    
}



























