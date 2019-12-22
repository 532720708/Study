package cn.downey.designpattern.observer;

/**
 * @author zsj53
 */
public class HexaObserver extends AbstractObserver {

    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String:\t" + Integer.toHexString(subject.getState()));
    }
}
