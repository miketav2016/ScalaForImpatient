package ch19AdvancedTypes.s13FamilyPolymorphism

import scala.collection.mutable.ArrayBuffer

/*
* The ActionEvent class sets the event source to this, but the type of the event source is
* Object. We can make this typesafe with a self type:
*/

trait Event13[S] {
    var source: S = _
}
trait Listener13[S, E <: Event13[S]] {
    def occurred(e: E): Unit
}
trait Source13[S, E <: Event13[S], L <: Listener13[S, E]] {
    this: S =>
    private val listeners = new ArrayBuffer[L]
    def add(l: L) { listeners += l }
    def remove(l: L) { listeners -= l }
    def fire(e: E) {
        e.source = this // Self type needed here
        for (l <- listeners) l.occurred(e)
    }
}
class ButtonEvent13 extends Event13[Button13]
trait ButtonListener13 extends Listener13[Button13, ButtonEvent13]
class Button13 extends Source13[Button13, ButtonEvent13, ButtonListener13] {
    def click() { fire(new ButtonEvent13) }
}

