package org.shivam.ci;

public class Cert {
    public String name;

    public Cert(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cert{" +
                "name='" + name + '\'' +
                '}';
    }
}
