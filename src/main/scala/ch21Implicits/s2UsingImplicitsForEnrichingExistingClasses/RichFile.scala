package ch21Implicits.s2UsingImplicitsForEnrichingExistingClasses

import java.io.File
import scala.io.Source
import scala.language.implicitConversions

//Instead of providing a conversion function, you can declare RichFile as an implicit class:
object A {

  implicit class RichFile(val from: File) extends AnyVal {
    def read: String = Source.fromFile(from.getPath).mkString

    implicit def file2RichFile(from: File): RichFile = new RichFile(from)

    //Now it is possible to call read on a File object. It is implicitly converted to a RichFile

  }
}
