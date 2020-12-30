package ch19AdvancedTypes.s1SingletonTypes

import scala.collection.mutable.ListBuffer

class Book extends Document {
  private var chapters = new ListBuffer[String]()

  def addChapter(chapter: String) = {
    chapters += chapter
    this
  }
}
