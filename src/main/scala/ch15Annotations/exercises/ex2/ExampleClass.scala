package ch15Annotations.exercises.ex2

@deprecated
class ExampleClass[@deprecated T](@deprecated val string: String) {

  type myType = Int@deprecated

  @deprecated
  val tmp: String = "deprecated"

  @deprecated
  def foo(): Unit = {}

  def foo1(@deprecated i: Int): Int = {
    -i: @deprecated

  }
}

object A {
  val exampleClass0 = new ExampleClass("deprecated")
  val exampleClass = new ExampleClass("deprecated")
  exampleClass.tmp
  exampleClass.foo()
  exampleClass.foo1(2)
}
