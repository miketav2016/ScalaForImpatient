package ch9FilesAndRegularExpressions.exercises.exercise5

import java.io.{File, PrintWriter}

object TwoPower extends App {
  def tPow(path: String): Unit = {
    new File(path).delete()
    val out = new PrintWriter(path)
    for (i <- Range(1 ,21)) out.println(s" ${math.pow(2,i).toInt} ${" " * 10} ${1 / math.pow(2, i)}")
    out.close()
  }

  val path = "src/main/scala/chapter9/exercises/exercise5/test.txt"
  tPow(path)
}
