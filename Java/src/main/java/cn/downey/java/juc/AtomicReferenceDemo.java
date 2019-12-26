package cn.downey.java.juc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

@Getter
@ToString
@AllArgsConstructor
class User {
    String username;
    int age;
}

/**
 *
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {

        User a = new User("a", 22);
        User b = new User("b", 25);

        AtomicReference<User> atomicReference = new AtomicReference<>();

        atomicReference.set(a);
        System.out.println(atomicReference.compareAndSet(a, b) + "\t" + atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(a, b) + "\t" + atomicReference.get().toString());


    }
}
