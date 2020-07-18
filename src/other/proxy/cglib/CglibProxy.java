//package other.proxy.cglib;
//
//import net.sf.cglib.proxy.Enhancer;
//
///**
// * @author clt
// * @create 2020/5/24 12:18
// */
//public class CglibProxy {
//
//    public static Object getProxy(Class<?> clazz){
//        Enhancer enhancer = new Enhancer();
//        //设置类加载
//        enhancer.setClassLoader(clazz.getClassLoader());
//        //设置被代理类
//        enhancer.setSuperclass(clazz);
//        //设置方法拦截器
//        enhancer.setCallback(new TargetInterceptor());
//        //创建代理类
//        return enhancer.create();
//    }
//}
