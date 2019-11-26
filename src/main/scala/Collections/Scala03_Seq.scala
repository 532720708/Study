package Collections

object Scala03_Seq {
  def main(args: Array[String]): Unit = {
    //序列 Seq
    var list:List[Int] = List(1,2,3,4)
    val list1: List[Int] = List(5,6,7,8)
    //通过索引获取数据
    println(list(0))

    //增加数据
    println(list :+ 1)
    println(1 +: list)

    val list2: List[Int] = list.++(list1)
    println(list2.mkString(","))

    val list3: List[Int] = list.::(9)
    println(list3.mkString(","))

    val list4 = 7::8::9::list
    println(list4.mkString(","))
  }

}
