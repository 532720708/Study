package cn.downey.codinginterview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Student {

    private Integer number;

    private Integer score;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", score=" + score +
                '}';
    }
}

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            Student student = new Student();
            student.setNumber(Integer.parseInt(str.split(" ")[0]));
            student.setScore(Integer.parseInt(str.split(" ")[1]));
            students[i] = student;
        }
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore().compareTo(o2.getScore()) == 0 ?
                        o1.getNumber().compareTo(o2.getNumber()) :
                        o1.getScore().compareTo(o2.getScore());
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(students[i].getNumber() + " " + students[i].getScore());
        }
    }

}
