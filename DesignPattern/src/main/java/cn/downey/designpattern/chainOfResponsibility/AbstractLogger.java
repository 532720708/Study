package cn.downey.designpattern.chainOfResponsibility;

/**
 * 创建抽象类 AbstractLogger，带有详细的日志记录级别。
 * 然后创建三种类型的记录器，都扩展了 AbstractLogger。
 * 每个记录器消息的级别是否属于自己的级别
 * 如果是则相应地打印出来，否则将不打印并把消息传给下一个记录器。
 */
public abstract class AbstractLogger {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;

    protected int level;

    //责任链中的下一个元素
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}
