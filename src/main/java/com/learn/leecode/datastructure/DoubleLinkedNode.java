package com.learn.leecode.datastructure;

public class DoubleLinkedNode {
    public DoubleLinkedNode left;
    public DoubleLinkedNode right;
    public int value;
    public int key;

    public DoubleLinkedNode(){}

    public DoubleLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
