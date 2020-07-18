//package other.proxy;
//
//import org.junit.Test;
//import other.proxy.cglib.CglibProxy;
//import other.proxy.jdk.DynamicProxyAnimal;
//import other.proxy.staticproxy.StaticProxyAnimal;
//
///**
// * @author clt
// * @create 2020/5/24 10:04
// */
//public class Main {
//
//    @Test
//    public void testStaticProxy1(){
//        Animal staticProxy = new StaticProxyAnimal(new Cat());
//        staticProxy.call();
//    }
//
//    @Test
//    public  void testStaticProxy2(){
//        Animal staticProxy = new StaticProxyAnimal(new Dog());
//        staticProxy.call();
//    }
//
//    @Test
//    public  void  testJDKDynamicProxy1() throws Exception {
//        Animal proxy = (Animal) DynamicProxyAnimal.getProxy(new Cat());
//        proxy.call();
//        proxy.run();
//    }
//
//    @Test
//    public  void  testJDKDynamicProxy2() throws Exception {
//        Animal proxy = (Animal) DynamicProxyAnimal.getProxy(new Dog());
//        proxy.call();
//    }
//
//    @Test
//    public  void testCglibDynamicProxy1(){
//        Animal cat = (Animal) CglibProxy.getProxy(Cat.class);
//        cat.call();
//    }
//}
