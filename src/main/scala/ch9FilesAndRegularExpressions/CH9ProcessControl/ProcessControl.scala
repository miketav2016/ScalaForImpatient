package ch9FilesAndRegularExpressions.CH9ProcessControl

import java.io.File
import java.net.URL

class ProcessControl {

  import scala.sys.process._

  val resultInt: Int = "ls -al ..".!
  val result: String = "ls -al /".!!
  /** You can pipe the output of one program into the input of another, using the #| method: */
  val resultI: Int = ("ls -al /" #| "grep u").!

  /** To redirect the output to a file, use the #> method: */
  ("ls -al /" #> new File("src/main/scala/chapter9/CH9ProcessControl/filelist.txt")).!
  println()
  /** To append to a file, use #>> instead: */
  ("ls -al /etc" #>> new File("src/main/scala/chapter9/CH9ProcessControl/filelist.txt")).!
  println()
  /** To redirect input from a file, use #<: */
  ("grep u" #< new File("src/main/scala/chapter9/CH9ProcessControl/filelist.txt")).!
  println()
  /** You can also redirect input from a URL: */
  ("grep Scala" #< new URL("http://horstmann.com/index.html")).!
  println()

  val p: ProcessBuilder = Process("cmd", new File("src/main/scala/chapter9/CH9ProcessControl/filelist1.txt"), ("LANG", "en_US"))
}

object A extends App {
  val processControl = new ProcessControl
  println(processControl.result)
  println(processControl.resultInt)
  println(processControl.resultI)
  println(processControl.p)
}