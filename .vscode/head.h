/**
@Author: Nick xdqck@live.com
@Date:2017-8-3
@Description: 
    如果要在main(),return 0之前调用函数
    在main()中调用atexit(void* f)方法即可

    static void beforeMainEnd(void);
    int main(void)
    {
        atexit(beforeMainEnd);
        return 0;
    }
*/
#include <stdlib.h>
static void beforeMainStart(void) __attribute__((constructor));
static void afterMainEnd(void) __attribute__((destructor));
static void beforeMainStart()
{
    system("chcp 65001");
    system("cls");
}
static void afterMainEnd()
{
    system("echo.");
    system("pause");
}
