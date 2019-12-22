## LRU Cache


### 描述

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

`get(key)` - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.

`set(key, value)` - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.


### 分析

为了使查找、插入和删除都有较高的性能，这题的关键是要使用一个双向链表和一个HashMap，因为：

* HashMap保存每个节点的地址，可以基本保证在`O(1)`时间内查找节点
* 双向链表能后在`O(1)`时间内添加和删除节点，单链表则不行


具体实现细节：

* 越靠近链表头部，表示节点上次访问距离现在时间最短，尾部的节点表示最近访问最少
* 访问节点时，如果节点存在，把该节点交换到链表头部，同时更新hash表中该节点的地址
* 插入节点时，如果cache的size达到了上限capacity，则删除尾部节点，同时要在hash表中删除对应的项；新节点插入链表头部

![LRU Cche](../../images/lru-cache.png)

### 代码

{% if book.cpp %}
C++的`std::list` 就是个双向链表，且它有个 `splice()`方法，`O(1)`时间，非常好用。
{% endif %}

{% if book.java %}
Java中也有双向链表`LinkedList`, 但是 `LinkedList` 封装的太深，没有能在`O(1)`时间内删除中间某个元素的API(C++的`list`有个`splice()`, O(1), 所以本题C++可以放心使用`splice()`)，于是我们只能自己实现一个双向链表。

本题有的人直接用 `LinkedHashMap` ，代码更短，但这是一种偷懒做法，面试官一定会让你自己重新实现。
{% endif %}

{% if book.java %}
```java
// LRU Cache
// 时间复杂度O(logn)，空间复杂度O(n)
public class LRUCache {
    private int capacity;
    private final HashMap<Integer, Node> map;
    private Node head;
    private Node end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }

        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);
            if (map.size() >= capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);
            } else {
                setHead(created);
            }

            map.put(key, created);
        }
    }

    private void remove(Node n){
        if (n.prev !=null) {
            n.prev.next = n.next;
        } else {
            head = n.next;
        }

        if (n.next != null) {
            n.next.prev = n.prev;
        } else {
            end = n.prev;
        }

    }

    private void setHead(Node n){
        n.next = head;
        n.prev = null;

        if (head!=null ) head.prev = n;

        head = n;

        if(end == null) end = head;
    }

    // doubly linked list
    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// LRU Cache
// 时间复杂度O(logn)，空间复杂度O(n)
class LRUCache{
private:
    struct CacheNode {
        int key;
        int value;
        CacheNode(int k, int v) :key(k), value(v){}
    };
public:
    LRUCache(int capacity) {
        this->capacity = capacity;
    }

    int get(int key) {
        if (cacheMap.find(key) == cacheMap.end()) return -1;
        
        // 把当前访问的节点移到链表头部，并且更新map中该节点的地址
        cacheList.splice(cacheList.begin(), cacheList, cacheMap[key]); 
        cacheMap[key] = cacheList.begin();
        return cacheMap[key]->value;
    }

    void set(int key, int value) {
        if (cacheMap.find(key) == cacheMap.end()) {
            if (cacheList.size() == capacity) { //删除链表尾部节点（最少访问的节点）
                cacheMap.erase(cacheList.back().key);
                cacheList.pop_back();
            }
            // 插入新节点到链表头部, 并且在map中增加该节点
            cacheList.push_front(CacheNode(key, value));
            cacheMap[key] = cacheList.begin();
        } else {
            //更新节点的值，把当前访问的节点移到链表头部,并且更新map中该节点的地址
            cacheMap[key]->value = value;
            cacheList.splice(cacheList.begin(), cacheList, cacheMap[key]);
            cacheMap[key] = cacheList.begin();
        }
    }
private:
    list<CacheNode> cacheList; // doubly linked list
    unordered_map<int, list<CacheNode>::iterator> cacheMap;
    int capacity;
};
```
{% endif %}
