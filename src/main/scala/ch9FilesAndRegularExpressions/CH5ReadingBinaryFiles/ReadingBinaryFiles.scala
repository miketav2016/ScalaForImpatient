package ch9FilesAndRegularExpressions.CH5ReadingBinaryFiles

import java.io.FileInputStream
import java.io.File

class CH5ReadingBinaryFiles {
  val filename: String = "src/main/scala/chapter9/CH5ReadingBinaryFiles/bin"
  val file: File = new File(filename)
  val in: FileInputStream = new FileInputStream(file)
  val bytes: Array[Byte] = new Array[Byte](file.length.toInt)
  in.read(bytes)
  in.close()
}

object A extends App {
  val readFile = new CH5ReadingBinaryFiles
  println(readFile.bytes.mkString("Array(", ", ", ")"))
  println(readFile.bytes.mkString("Array(", ", ", ")"))

}