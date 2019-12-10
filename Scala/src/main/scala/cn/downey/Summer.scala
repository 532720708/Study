package cn.downey

import cn.downey.ChecksumAccumulator._

object Summer {
  def main(args: Array[String]): Unit = {
    for (arg <- args) println(arg + ":" + calculate(arg))
  }
}
