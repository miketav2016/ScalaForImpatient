package ch7PackagesAndImports.exercise6
/**Write a program that copies all elements from a Java hash map into a Scala hash map.
 *  Use imports to rename both classes.
 */
import java.util.{HashMap => JavaHashMap}
import scala.collection.mutable.{HashMap  => ScalaHashMap}

object MyCopy extends App{
  val b = new JavaHashMap[String, Int]
  b.put("1", 10)
  def mCopy:ScalaHashMap[String, Int] = {
    var sMap: ScalaHashMap[String, Int] = ScalaHashMap()
    b.forEach((k,v) => sMap += (k -> v))
    sMap
  }
  println(mCopy.mkString)
}
