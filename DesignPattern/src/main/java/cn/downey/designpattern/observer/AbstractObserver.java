package cn.downey.designpattern.observer;


/**
 * @author zsj53
 */
public abstract class AbstractObserver {
    protected Subject subject;

    /**
     * 观察者接收到改变时
     */
    public abstract void update();
}
