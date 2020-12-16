package ch9FilesAndRegularExpressions.exercises.exercise8

import scala.io.{BufferedSource, Source}

object PrintsTheSrcAttributes extends App {
  def function(): Unit = {
    val imgRegex = "<img.*src=(?:\"|')([^\"']+).*>".r
    val path = "https://stackoverflow.com/questions/1196570/using-regular-expressions-to-extract-the-first-image-source-from-html-codes"
    val source: BufferedSource = Source.fromURL(path, "UTF-8")
    val tokens: Array[String] = source.mkString.split("\\s+")
    for (imgRegex(src) <- imgRegex.findAllIn(tokens.mkString))
      println(src)
    source.close()
  }

  function()
}
