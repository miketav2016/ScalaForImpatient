package chapter9.CH6WritingTextFiles

import java.io.PrintWriter

class WritingTextFiles {
  val out = new PrintWriter("src/main/scala/chapter9/CH6WritingTextFiles/numbers.txt")
  for (i <- 1 to 100) out.println(i)
  out.close()
  val out1 = new PrintWriter("src/main/scala/chapter9/CH6WritingTextFiles/numbers1.txt")
  for (i <- 1 to 100) out1.print(f"$i%6d $i%10.2f")
  out1.close()
}

object A extends App {
  val readFile = new WritingTextFiles
}