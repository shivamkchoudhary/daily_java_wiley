package org.shivam.factorymethod;

public class MyServiceFactory {

    // without arguments
    public MyService createMyService() {
        return new MyServiceImpl();
    }

    // with arguments
    public MyService createMyService(String info) {
        MyServiceImpl myService = new MyServiceImpl();
        myService.setInfo(info);
        return myService;
    }

    // without arguments
    public static MyService createMyStaticService() {
        return new MyServiceImpl();
    }

    // with arguments
    public static MyService createMyStaticService(String info) {
        MyServiceImpl myService = new MyServiceImpl();
        myService.setInfo(info);
        return myService;
    }
}
