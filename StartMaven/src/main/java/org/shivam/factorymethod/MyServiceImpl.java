package org.shivam.factorymethod;

public class MyServiceImpl implements MyService {

    private String info;

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String getInfo() {
        return info;
    }


}

