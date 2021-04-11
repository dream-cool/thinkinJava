package util;

/**
 * @description
 * @author: clt
 * @create: 2021-04-11 13:27
 **/
public class LogUtil {
    public static Logger getLogger(Class<?> clz) {
        return new Logger(clz);
    }
}
