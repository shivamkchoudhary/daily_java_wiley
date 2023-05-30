package org.shivam.ci;

public class Person {
    private final Cert cert;
    private String name;
    private int id;

    public Person(String name, int id, Cert cert) {
        this.name = name;
        this.id = id;
        this.cert = cert;
    }

    public Person(Cert cert, int id) {
        this.cert = cert;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cert getCert() {
        return cert;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cert=" + cert +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
