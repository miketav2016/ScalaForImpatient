package ch21Implicits.exercises.ex4

import scala.io.StdIn

sealed trait asWhat

object anInt extends asWhat
object aString extends asWhat
object aDouble extends asWhat

class ReadingIDS {
  private var nextType: asWhat = aString
  private var data = List[(String,Any)] ()
  def and(obj:asWhat): this.type = {
    in(obj)
  this
  }
  def in (obj: asWhat): this.type = {
    nextType = obj
    this
  }
  def askingFor (fieldName: String): ReadingIDS = {
    print(fieldName + " :")
    val value = nextType match {
      case _: aString.type => StdIn.readLine()
      case _: anInt.type => StdIn.readInt()
      case _: aDouble.type => StdIn.readDouble()
    }
    data = data:+ (fieldName, value)
    this
  }

}

object Answer extends App {
  val Read = new ReadingIDS

  Read in aString askingFor "Your name" and anInt askingFor "Your age" and aDouble askingFor "Your weight"
}
