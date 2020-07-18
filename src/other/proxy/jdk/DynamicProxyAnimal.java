package other.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author clt
 * @create 2020/5/24 10:38
 */
public class DynamicProxyAnimal {

    public  static Object getProxy(Object target) throws Exception{
        /**
         * loader 加载代理对象的类加载器
         * interfaces 代理对象实现的接口，与目标对象实现同样的接口
         * h 处理代理对象逻辑的处理器，即上面的 InvocationHandler 实现类。
         */
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TargetInvoker(target)
        );
        return proxy;
    }

}
