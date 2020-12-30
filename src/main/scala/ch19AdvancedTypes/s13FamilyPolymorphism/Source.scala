package ch19AdvancedTypes.s13FamilyPolymorphism

import scala.collection.mutable.ArrayBuffer

trait Source[E, L <: Listener[E]] {
    private val listeners = new ArrayBuffer[L]
    def add(l: L) { listeners += l }
    def remove(l: L) { listeners -= l }
    def fire(e: E) {
        for (l <- listeners) l.occurred(e)
    }
}