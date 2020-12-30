package ch19AdvancedTypes.s14HigherKindedTypes

import scala.reflect.ClassTag

/*
* There is one additional complexity in this example, and it has nothing to do with higher-kinded
* types. In order to construct a generic Array[E], the type E must fulfill the ClassTag
* context bound that was discussed in Chapter 18.
* */
class Buffer[E : ClassTag] extends Iterable[E, Buffer] with Container[E] {
    private var capacity = 10
    private var length = 0
    private var elems = new Array[E](capacity) // See note
    def iterator() = new Iterator[E] {
        private var i = 0
        def hasNext = i < length
        def next() = { i += 1; elems(i - 1) }
    }
    def +=(e: E) {
        if (length == capacity) {
            capacity = 2 * capacity
            val nelems = new Array[E](capacity) // See note
            for (i <- 0 until length) nelems(i) = elems(i)
            elems = nelems
        }
        elems(length) = e
        length += 1
    }

    override def build[F](): Buffer[F] = new Buffer[F]
}
class Range(val low: Int, val high: Int) extends Iterable[Int, Buffer] {
    def iterator() = new Iterator[Int] {
        private var i = low
        def hasNext = i <= high
        def next() = { i += 1; i - 1 }
    }
    def build[F]() = new Buffer[F]
}
trait Container[E] {
    def +=(e: E): Unit
}
/*
* This example showed a typical use of higher-kinded types. An Iterator depends on Container,
* but Container isn’t a type—it is a mechanism for making types.
* The Iterable trait of the Scala collections library doesn’t have an explicit parameter for making
* collections. Instead, Scala uses an implicit parameter to conjure up an object for building the target
* collection.
* */