package cn.downey.designpattern.observer;

/**
 * 观察者实体
 *
 * @author zsj53
 */
public class BinaryObserver extends AbstractObserver {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String:\t" + Integer.toBinaryString(subject.getState()));
    }
}
