package chapter7.exercise7

/** In the preceding exercise, move all imports into the innermost scope possible.
 */


object MyCopy extends App {

  import java.util.{HashMap => JavaHashMap}
  val b = new JavaHashMap[String, Int]
  b.put("1", 10)
  import scala.collection.mutable.{HashMap => ScalaHashMap}
  def mCopy: ScalaHashMap[String, Int] = {
    var sMap: ScalaHashMap[String, Int] = ScalaHashMap()
    b.forEach((k, v) => sMap += (k -> v))
    sMap
  }

  println(mCopy.mkString)
}
