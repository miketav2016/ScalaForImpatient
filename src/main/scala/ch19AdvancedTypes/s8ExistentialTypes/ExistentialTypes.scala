package ch19AdvancedTypes.s8ExistentialTypes

import ch19AdvancedTypes.s2TypeProjections.Network

import javax.swing.JComponent

object ExistentialTypes extends App {

//    val arr0: Array[T] forSome {type T <: JComponent} = Array()
//    val arr1: Array[_ <: JComponent] = Array(null)
    //arr1 and arr0 type is quel

    val arr3: Array[_] = Array()
    val arr2: Array[T] forSome { type T }= Array()
    //arr3 and arr2 type is quel

    val map0: Map[_, _] = Map()
    val map1: Map[T, U] forSome { type T; type U } = Map()
    val map2: Map[T, U] forSome { type T; type U <: T } = Map()

    def process[M <: n.Member forSome { val n: Network }](m1: M, m2: M) = (m1, m2)
    val chatter = new Network
    val myFace = new Network
    val fred = chatter.join("Fred")
    val wilma = chatter.join("Wilma")
    val barney = myFace.join("Barney")
    process(fred, wilma) // OK
//    process(fred, barney) // Error

}
