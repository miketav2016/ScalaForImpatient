package ch19AdvancedTypes.exercises.ex7

import scala.language.existentials

object Answer extends App {
  def foo[T <: {def close(): Unit}, R](obj: T)(f: T => R): R = {
    try {
      f(obj)
    } finally {
      obj.close()
    }
  }
}
