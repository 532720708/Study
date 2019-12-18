package cn.downey.java.juf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Book {

    //链式编程 + 流式计算
    private int id;
    private String bookName;
    private double price;

    public static void main(String[] args) {
        Book book = new Book();
        book.setId(11).setBookName("java").setPrice(33.5d);

    }

}
