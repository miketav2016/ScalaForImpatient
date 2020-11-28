package ch10Traits.exercises.ex10

import ch10Traits.s7TraitsForRichInterfaces.Logger

trait BufferedInputStreamT extends java.io.BufferedInputStream with Logger{
  override def log(msg: String): Unit = println(msg)
  override def read(): Int = {
    log("0")
    0
  }
}
