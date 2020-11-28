package ch10Traits.exercises.ex11

import scala.collection.AbstractIterator

class IterableInputStream extends java.io.InputStream with Iterable[Byte]{
  override def read(): Int = 5

  override def iterator: Iterator[Byte] = new AbstractIterator[Byte] {
    override def hasNext: Boolean = ???

    override def next(): Byte = ???
  }
}
