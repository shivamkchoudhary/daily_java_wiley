package org.shivam.factorymethod;

public class CBeans {

    private MyService myService;
    private MyService myServiceWithArgs;
    private MyService myStaticService;
    private MyService myStaticServiceWithArgs;

    public void setMyService(MyService myService) {
        this.myService = myService;
    }

    public void setMyServiceWithArgs(MyService myServiceWithArgs) {
        this.myServiceWithArgs = myServiceWithArgs;
    }

    public void setMyStaticService(MyService myStaticService) {
        this.myStaticService = myStaticService;
    }

    public void setMyStaticServiceWithArgs(MyService myStaticServiceWithArgs) {
        this.myStaticServiceWithArgs = myStaticServiceWithArgs;
    }

    public void run() {
        System.out.println("Instance factory method without arguments: " + myService.getInfo());
        System.out.println("Instance factory method with arguments: " + myServiceWithArgs.getInfo());
        System.out.println("Static factory method without arguments: " + myStaticService.getInfo());
        System.out.println("Static factory method with arguments: " + myStaticServiceWithArgs.getInfo());
    }
}
