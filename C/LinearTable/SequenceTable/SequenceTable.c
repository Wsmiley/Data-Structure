#include<stdio.h>

#define MaxSize 10
#define ElementType int
#define Position int

struct SequenceTable{
    ElementType elements[MaxSize];
    int last;
};

typedef struct SequenceTable List;

List CreateTable(ElementType array[],int lenght);
List DeleteData(List list,Position p);
List InsertData(List list,ElementType Data,Position p);
List DeleteAllSame(List list,ElementType data);
void PrintList(List list);
List Reverse1(List list);
List Reverse2(List list);

int main(void){
    //CreateTable
    ElementType array[]={11,22,11,44,11,55,66};
    int lenght=sizeof(array)/sizeof(ElementType);
    List list=CreateTable(array,lenght);
    printList(list);
    
    // insertData
    // list=InsertData(list,66,3);
    // printList(list);
    //deleteData
    // list=DeleteData(list,3);
    // printList(list);
    // deleteAllSame
    // list=DeleteAllSame(list,11);
    // PrintList(list);
    list=Reverse1(list);
    printList(list);
    //list=Reverse2(list);
    //PrintList(list);
    return 0;
}


List CreateTable(ElementType array[],int lenght){
    List list;
    list.last=0;
    for(int i=0;i<lenght;i++){
        list.elements[i]=array[i];
    }
    list.last=lenght-1;
    return list;
}

List InsertData(List list,ElementType data,Position p){
    if (list.last>=MaxSize-1){
        printf("SequenceTable is full\n");
        return list;
    }
    if(p>list.last+1||p<0){
        printf("Insert position is invalid\n");
        return list;
    }
    for(int i=list.last;i>=p;i--){
        list.elements[i+1]=list.elements[i];
    }
    list.last++;
    list.elements[p]=data;
    return list;
}

List DeleteData(List list,Position p){
    if(p>list.last+1||p<0){
        printf("Insert position is invalid \n");
        return list;
    }
    ElementType data=list.elements[p];
    for(int i=p;i<list.last;i++){
        list.elements[i]=list.elements[i+1];
    }
    list.last--;
    printf("Deleted element is:%d\n",data);

    return list;
}

List DeleteAllSame(List list,ElementType data){
    for(int i=0;i<=list.last;i++){
        if(list.elements[i]==data){
            list=DeleteData(list,i);
        }
    }
    return list;
}

void PrintList(List list){
    if(list.last<0){
        printf("SequenceTable is empty");
        return;
    }
    printf("SequenceTable{");
    for(int i=0;i<=list.last;i++){
        if(i!=list.last){
            printf("%d,",list.elements[i]);
        }else{
            printf("%d",list.elements[i]);
        }
    }
    printf("}\n");
}

//One sequential tables
List Reverse1(List list){
    if(list.last==0)
        return list;
    int left=0;
    int right=list.last;
    ElementType temp;
    for(;left<=right;left++){
        temp=list.elements[left];
        list.elements[left]=list.elements[right];
        list.elements[right]=temp;
        right--;
    }
    return list;
}

//Two sequential tables
List Reverse2(List list){
    if(list.last==0)
        return list;
    int j=list.last;
    List L;
    L.last=j;
    for(int i=0;i<=list.last;i++){
        L.elements[i]=list.elements[j];
        j--;
    }
    return L;
}


