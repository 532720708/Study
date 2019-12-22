package cn.downey.designpattern.observer;

/**
 * @author zsj53
 */
public class OctalObserver extends AbstractObserver {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String:\t" + Integer.toOctalString(subject.getState()));
    }

}
