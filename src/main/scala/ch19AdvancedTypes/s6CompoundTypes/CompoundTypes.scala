package ch19AdvancedTypes.s6CompoundTypes

import java.awt.geom.Area
import java.awt.{Point, Rectangle, Shape}
import scala.collection.mutable.ArrayBuffer

object CompoundTypes extends App {
  //You can use a compound type to manipulate values that must provide multiple traits
  val image: ArrayBuffer[Shape with Serializable] = new ArrayBuffer[java.awt.Shape with java.io.Serializable]
  /**
   * now we can:
   * 1. draw the image object as for (s <- image) graphics.draw(s).
   * 2. serialize the image object because you know that all elements are serializable.
   */
  //Of course, you can only add elements that are both shapes and serializable objects
  val rect = new Rectangle(5, 10, 20, 30)
  image += rect // OK—Rectangle is Serializable
  /**
   * type mismatch;
   * found   : java.awt.geom.Area
   * required: java.awt.Shape with Serializable
   */
  //    image += new Area(rect) // Error—Area is a Shape but not Serializable

}
