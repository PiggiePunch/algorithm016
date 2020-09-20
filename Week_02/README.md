
## HashMap学习笔记
* Java8以前：数组+链表
* Java8及以后：数组+链表+红黑树，性能从O(N)提高到O(logN)

## 几个关键参数
* DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16（默认初始化大小）
* DEFAULT_LOAD_FACTOR = 0.75f;（负载因子）
* TREEIFY_THRESHOLD = 8;（链表转红黑树的阈值）
* MIN_TREEIFY_CAPACITY = 64;（最小转红黑树的数组大小）

## HashMap: put方法的逻辑
* 若HashMap违背初始化，则进行初始化操作
* 对Key求Hash值，再根据hash值计算下标
* 若未发生碰撞，则直接放入桶中
* 若发生碰撞，则以链表的方式用尾插法连接到后面
* 若链表的长度超过阈值（TREEIFY_THRESHOLD = 8）且HashMap元素超过最低树化容量（MIN_TREEIFY_CAPACITY = 64），则将链表转成红黑树
* 若节点已经存在，则用新的值替换旧值
* 若桶满了（默认容量DEFAULT_INITIAL_CAPACITY = 16 * 负载因子DEFAULT_LOAD_FACTOR = 0.75f），就resize扩容到2倍后重排

## 几个细节
* 从获取hash到散列的过程：调用hashCode() -> h>>>16 -> h^(h>>>16) 很巧妙为了减少后序hash碰撞的概率
* 计算下标（n-1）& hash，这个动作正好和%的结果一致，前提是n为2的幂次方，这是为什么每次扩容的大小必须是2的幂次方
* 负载因子0.75的原因，这个数大了可以节省空间但是碰撞概率高，反之小了浪费空间但是不容易碰撞，0.75是经过多次测算得出的尽量节省空间的情况下出现碰撞的概率又非常低的数值


