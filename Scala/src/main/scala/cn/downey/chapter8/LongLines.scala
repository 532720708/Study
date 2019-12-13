package cn.downey.chapter8

import scala.io.Source

object LongLines {


  def processFile(filename: String, width: Int) = {
    val source = Source.fromFile("")
    for (line <- source.getLines())
      processLine(filename, width, line)
  }

  def processLine(filename: String, width: Int, line: String) = {
    if (line.length > width)
      println(filename + ":" + line.trim)
  }
}
