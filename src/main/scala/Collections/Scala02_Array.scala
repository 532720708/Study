package Collections

object Scala02_Array {

  def main(args: Array[String]): Unit = {

    //Scala中的数组

    //java数组，int[] ints = new int[3]
    //          ints[0] = 1
    //          int i = ints[0]

    //Scala中的数组，使用Array对象实现，使用中括号声明数组的类型
    //Array[String]
    //Scala可以使用简单的方式创建数组
    //Array可以通过apply方法来创建数组对象

    val ints: Array[Int] = Array(1, 2, 3, 4)
    //访问数组:使用小括号，增加索引的方式来访问数组
    //    println(ints(0))

    //数组的长度
    //println(ints.length)
    //println(ints)

    //将数组转换为字符串打印
    //println(ints.mkString("==="))

    //    for(elem <- ints){
    //      println(elem)
    //    }

    //    def printlnXXX(i:Int): Unit ={
    //      println(i)
    //    }

    //foreach方法会将数组中的每一个元素进行循环遍历，执行指定函数实现逻辑
    //    ints.foreach(println)

    //修改元素
    //    ints.update(1,5)

    //增加元素
    //采用方法向数组中增加元素，但不会对原有数组造成影响，而是产生新的数组（不可变）
    //    val ints1: Array[Int] = ints:+(5)

    //    println(ints.mkString(","))

    //可变数组
    val arrayBuffer: ArrayBuffer[Int] = ArrayBuffer(5, 6, 7, 8)
    //    arrayBuffer.mkString(",")

    //增加数据
    arrayBuffer.insert(3, 5)
    arrayBuffer += 9
    println(arrayBuffer.mkString(","))
    arrayBuffer.remove(3)
    println(arrayBuffer.mkString(","))
    arrayBuffer.remove(0, 2)
    println(arrayBuffer.mkString(","))

    //可变数组和不可变数组转换
    val buffer: mutable.Buffer[Int] = ints.toBuffer
    val array: Array[Int] = arrayBuffer.toArray

  }

}
