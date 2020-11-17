package chapter9.CH7VisitingDirectories

import java.nio.file._

class VisitingDirectories {
  val dirName: String = ""
  val entries = Files.walk(Paths.get(dirName)) // or Files.list
  try {
    entries.forEach(p => println(p.getFileName))
  } finally {
    entries.close()
  }
}

object A extends App {
  val v = new VisitingDirectories
}
