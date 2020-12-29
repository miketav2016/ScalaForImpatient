package ch18TypeParameters.s11ObjectsCantBeGeneric

/*Here I use Node and Empty to make the discussion easier to follow for Java programmers. If
you are experienced with Scala lists, just substitute :: and Nil in your mind.*/
abstract class List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}
class Node[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}
class Empty[T] extends List[T] {
  def isEmpty = true
  def head = throw new UnsupportedOperationException
  def tail = throw new UnsupportedOperationException
}
//object Empty[T] extends List[T] // Error
object Empty extends List[Nothing] {
  override def isEmpty = true
  override def head = throw new UnsupportedOperationException
  override def tail = throw new UnsupportedOperationException
}
