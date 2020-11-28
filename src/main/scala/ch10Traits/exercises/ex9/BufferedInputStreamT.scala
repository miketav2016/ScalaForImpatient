package ch10Traits.exercises.ex9

trait BufferedInputStreamT extends java.io.BufferedInputStream {
  override def read(): Int = 0
}
