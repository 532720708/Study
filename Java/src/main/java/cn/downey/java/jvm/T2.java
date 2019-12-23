package cn.downey.java.jvm;

/**
 * 生产环境中Xmx和Xms一样
 * 避免内存忽高忽低产生停顿
 *
 * @author zsj53
 */
public class T2 {
    public static void main(String[] args) {
        //虚拟机试图使用的最大内存
        long maxMemory = Runtime.getRuntime().maxMemory();
        //虚拟机中内存总量
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("-Xmx:\tMAX_MEMORY = " + (maxMemory / (double) 1024 / 1024) + "MB");
        System.out.println("-Xms:\tTOTAL_MEMORY = " + (totalMemory / (double) 1024 / 1024) + "MB");

    }
}
