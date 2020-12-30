package ch19AdvancedTypes.s13FamilyPolymorphism.WithAbstractTypes

import scala.collection.mutable.ArrayBuffer
/*
* But there is a price to pay. You can’t have top-level type declarations. That’s why everything is
* wrapped in the ListenerSupport trait.
*/
trait ListenerSupport {
    type S <: Source
    type E <: Event
    type L <: Listener
    trait Event {
        var source: S = _
    }
    trait Listener {
        def occurred(e: E): Unit
    }
    trait Source {
        this: S =>
        private val listeners = new ArrayBuffer[L]
        def add(l: L) { listeners += l }
        def remove(l: L) { listeners -= l }
        def fire(e: E) {
            e.source = this
            for (l <- listeners) l.occurred(e)
        }
    }
}
