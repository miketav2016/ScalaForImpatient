package ch15Annotations.exercises.ex5

import java.io.{FileNotFoundException, IOException}
import scala.io.Source

object GetFile {
  @throws(classOf[IOException])
  def getStr(path: String): String = {
    try {
      val readmeText = Source.fromResource(path).getLines
      readmeText.mkString("\n")
    } catch {
      case _: FileNotFoundException => s"resource '$path' was not found in the classpath from the given classloader."
    }
  }
}
