//package other.proxy.cglib;
//
//
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//
//import java.lang.reflect.Method;
//
///**
// * @author clt
// * @create 2020/5/24 12:02
// */
//public class TargetInterceptor implements MethodInterceptor {
//
//
//    @Override
//    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//        beforeEvents();
//        Object result = proxy.invokeSuper(obj, args);
//        afterEvents();
//        return result;
//    }
//
//    private void beforeEvents(){
//        System.out.println("CGLIB代理前-------（前置增强事件）");
//    }
//
//    private void afterEvents(){
//        System.out.println("CGLIB代理后-------（后置增强事件）");
//    }
//}
