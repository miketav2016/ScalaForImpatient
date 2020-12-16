package ch9FilesAndRegularExpressions.CH7VisitingDirectories

import java.nio.file._
import java.util.stream

class VisitingDirectories {
  val dirName: String = ""
  val entries: stream.Stream[Path] = Files.walk(Paths.get(dirName)) // or Files.list
  def printAllDir: Unit = try {
    entries.forEach(p => println(p.getFileName))
  } finally {
    entries.close()
  }
}

object A extends App {
  val v = new VisitingDirectories
}
