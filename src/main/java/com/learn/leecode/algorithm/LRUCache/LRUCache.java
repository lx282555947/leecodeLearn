package com.learn.leecode.algorithm.LRUCache;

import com.learn.leecode.datastructure.DoubleLinkedNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过哈希表和双向链表实现
 * 哈希表查询的复杂度是O(1),链表的插入、删除复杂度是O(1）
 */
public class LRUCache {

    private final DoubleLinkedNode head;
    private final DoubleLinkedNode tail;
    private final Map<Integer, DoubleLinkedNode> map = new HashMap<>();
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.right = tail;
        tail.left = head;
    }

    public int get(int key) {
        //查询key不存在，返回-1
        if (!map.containsKey(key)) {
            return -1;
        }
        //如果key存在，则获取值，并将该node移动至首部
        final DoubleLinkedNode currNode = map.get(key);
        remove(currNode);
        addFirst(currNode);
        return currNode.value;
    }

    public void put(int key, int value) {
        //先判键是否存在
        final boolean exist = map.containsKey(key);
        //如果存在，则更新键的值，同时，将node插入到链表的首部
        if (exist) {
            final DoubleLinkedNode existNode = map.get(key);
            remove(existNode);
            DoubleLinkedNode node = new DoubleLinkedNode(key, value);
            addFirst(node);
            map.put(key, node);
        } else {
            //如果不存在，首先得判断容器是否充足
            if (map.size() < capacity) {
                //如果容器充足，则直接插入到首部
                DoubleLinkedNode node = new DoubleLinkedNode(key, value);
                addFirst(node);
                map.put(key, node);
            } else {
                //如果容器不足，则移除尾部，将新数据插入到首部
                final DoubleLinkedNode deleteNode = deleteLast();
                map.remove(deleteNode.key);
                DoubleLinkedNode node = new DoubleLinkedNode(key, value);
                addFirst(node);
                map.put(key, node);
            }
        }
    }

    private void addFirst(DoubleLinkedNode node) {
        node.left = head;
        node.right = head.right;
        head.right.left = node;
        head.right = node;
    }

    private void remove(DoubleLinkedNode existNode) {
        existNode.left.right = existNode.right;
        existNode.right.left = existNode.left;
    }

    private DoubleLinkedNode deleteLast() {
        final DoubleLinkedNode deleteNode = tail.left;
        deleteNode.left.right = tail;
        tail.left = deleteNode.left;
        return deleteNode;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }
}
