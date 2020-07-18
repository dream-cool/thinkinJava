package other.proxy.staticproxy;

import other.proxy.Animal;

/**
 * @author clt
 * @create 2020/5/24 10:02
 */
public class StaticProxyAnimal implements Animal {

    private Animal impl;

    public StaticProxyAnimal(Animal impl){
        this.impl = impl;
    }

    @Override
    public void call() {
        beforeEvents();
        impl.call();
        afterEvents();
    }

    @Override
    public void run() {
        impl.run();
    }

    private void beforeEvents(){
        System.out.println("饥饿了-------（前置增强事件）");
    }

    private void afterEvents(){
        System.out.println("找吃的-------（后置增强事件）");
    }


}
