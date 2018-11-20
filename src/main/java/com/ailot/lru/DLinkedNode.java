package com.ailot.lru;

public class DLinkedNode {

    private String key;

    private String value;

    private DLinkedNode pre;

    private DLinkedNode post;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DLinkedNode getPre() {
        return pre;
    }

    public void setPre(DLinkedNode pre) {
        this.pre = pre;
    }

    public DLinkedNode getPost() {
        return post;
    }

    public void setPost(DLinkedNode post) {
        this.post = post;
    }
}
