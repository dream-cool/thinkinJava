package util;

import java.time.LocalDateTime;

/**
 * @description
 * @author: clt
 * @create: 2021-04-11 13:28
 **/
public class Logger {

    public static final String PLACE_HOLDER = "{}";
    public static final String LEFT = "[";
    public static final String RIGHT = "]";
    public static final String DELIMITER = "-";
    public static final String SPACE = " ";
    public static final String COLON = ":";

    private Level level;

    private Class<?> clz;

    public Logger(Class<?> clz) {
        this.level = Level.INFO;
        this.clz = clz;
    }

    public void info(String msg, Object... params) {
        msg = resolvePlaceHolder(msg);
        StringBuilder logMsg = new StringBuilder(getDefaultLogMsg());
        msg = String.format(msg, params);
        logMsg.append(msg);
        log(Level.INFO, logMsg.toString());
    }

    private String resolvePlaceHolder(String msg) {
        if (msg == null) {
            return null;
        }
        return msg.replace("{}", "%s");
    }


    private void log(Level level, String msg) {
        if (this.level.equals(level)) {
            System.out.println(msg);
        }
    }

    private String getDefaultLogMsg() {
        StringBuilder sb = new StringBuilder(LocalDateTime.now().toString())
                .append(SPACE)
                .append(SPACE)
                .append(level)
                .append(SPACE)
                .append(SPACE)
                .append(LEFT)
                .append(alignRight(Thread.currentThread().getName(), 20, SPACE))
                .append(RIGHT)
                .append(SPACE)
                .append(SPACE)
                .append(LEFT)
                .append(alignRight(clz.getName(), 40, SPACE))
                .append(RIGHT)
                .append(COLON)
                .append(SPACE)
                .append(SPACE);
        return sb.toString();
    }

    private String alignRight(String msg, int length, String fillChar) {
        if (msg != null) {
            StringBuilder msgBuilder = new StringBuilder(msg);
            for (; msgBuilder.length() < length; ) {
                msgBuilder.append(fillChar);
            }
            msg = msgBuilder.substring(0, length);
        }
        return msg;
    }


    private enum Level {
        TRACE,
        DEBUG,
        INFO,
        WARN,
        ERROR;
    }


}

