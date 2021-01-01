package ch19AdvancedTypes.exercises.ex3

import scala.collection.mutable.ListBuffer

class Book extends Document {
  private var chapters = new ListBuffer[String]()

  def addChapter(chapter: String) = {
    chapters += chapter
    this
  }
}
