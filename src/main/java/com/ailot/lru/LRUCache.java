package com.ailot.lru;

import java.util.HashMap;

public class LRUCache {

    private HashMap<String, DLinkedNode> cache = new HashMap<>();

    private int count;

    private int capacity;

    private DLinkedNode head;

    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        this.head = new DLinkedNode();
        head.setPre(null);
        this.tail = new DLinkedNode();
        tail.setPost(null);

        head.setPost(tail);
        tail.setPre(head);
    }

    public String get(String key){
        DLinkedNode node = cache.get(key);
        if (node == null){
            return "";
        }
        this.moveToHead(node);
        return node.getValue();
    }

    public void set(String key,String value){
        DLinkedNode node = cache.get(key);
        if (node == null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.setKey(key);
            newNode.setValue(value);
            this.cache.put(key,newNode);
            this.addNode(node);
            ++count;
            if (count > capacity){
                DLinkedNode tail = popTail();
                cache.remove(tail.getKey());
                --count;
            }
        }else {
            node.setValue(value);
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    private void addNode(DLinkedNode node){
        node.setPre(head);
        node.setPost(head.getPost());

        head.getPost().setPre(node);
        head.setPost(node);
    }

    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.getPre();
        DLinkedNode post = node.getPost();

        pre.setPost(post);
        post.setPre(pre);
    }


    private DLinkedNode popTail(){
        DLinkedNode res = tail.getPre();
        removeNode(res);
        return res;

    }
}
