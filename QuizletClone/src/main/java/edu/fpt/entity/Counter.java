package edu.fpt.entity;

public class Counter {

    private int count;

    public Counter(int init) {
        count = init;
    }

    public Counter create(int init){
        Counter counter = new Counter(init);
        return counter;
    }

    public void set(int value){
        count = value;
    }

    public int get() {
        return count;
    }

    public void clear() {
        count = 0;
    }

    public void increment() {
        count++;
    }

    public int incrementAndGet() {
        return ++count;
    }

    public String toString() {
        return "" + count;
    }
}