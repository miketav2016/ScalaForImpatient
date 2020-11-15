package chapter8.exercise4

import scala.collection.mutable.ArrayBuffer

class Bundle {

  val packet: ArrayBuffer[SimpleItem] =  ArrayBuffer[SimpleItem]()

  def addingItems(item: SimpleItem) :Unit = {
     packet += item
  }
  def price: Int = (for(i <- packet) yield i.price).sum

  override def toString: String = {
    packet.foldLeft("")((str, i) => str + s"description: ${i.description} price = ${i.price} \n")
  }

}
object B extends App {
  val myB = new Bundle
  myB.addingItems(new SimpleItem(10, "a"))
  myB.addingItems(new SimpleItem(20, "b"))
  myB.addingItems(new SimpleItem(30, "c"))
  myB.addingItems(new SimpleItem(40, "d"))
  println(myB.price)
  println(myB.toString)
}
