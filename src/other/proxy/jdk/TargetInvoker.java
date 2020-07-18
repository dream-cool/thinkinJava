package other.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author clt
 * @create 2020/5/24 10:34
 */
public class TargetInvoker implements InvocationHandler {

    private Object target;

    public TargetInvoker(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeEvents();
        Object result = method.invoke(target, args);
        afterEvents();
        return result;
    }

    private void beforeEvents(){
        System.out.println("JDK代理前-------（前置增强事件）");
    }

    private void afterEvents(){
        System.out.println("JDK代理后-------（后置增强事件）");
    }


}
