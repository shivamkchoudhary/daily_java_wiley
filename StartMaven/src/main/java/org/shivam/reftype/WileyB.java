package org.shivam.reftype;

public class WileyB {
    private int count;


    public WileyB(int count) {
        super();
        this.count = count;
    }

    public WileyB() {
        super();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "WileyB{" +
                "count=" + count +
                '}';
    }
}
