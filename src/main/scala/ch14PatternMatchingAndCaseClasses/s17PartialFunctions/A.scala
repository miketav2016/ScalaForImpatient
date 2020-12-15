package ch14PatternMatchingAndCaseClasses.s17PartialFunctions

object A extends App {
  val f: PartialFunction[Char, Int] = { case '+' => 1 ; case '-' => -1 }
  val g: Char => Option[Int] = f.lift // A function with type Char => Option[Int]
  //Now g('-') is Some(-1) and g('*') is None.
  //Conversely, you can turn a function returning Option[R] into a partial function by calling
  //Function.unlift.
  f('-') // Calls f.apply('-'), returns -1
  f.isDefinedAt('0') // false
//  f('0') // Throws MatchError
  "-3+4".collect { case '+' => 1 ; case '-' => -1 } // Vector(-1, 1)
  "-3+4".map { case '+' => 1 ; case '-' => -1; case _ => 0 }
  // Vector(-1, 0, 1, 0)
  val names = Array("Alice", "Bob", "Carmen")
  val scores = Map("Alice" -> 10, "Carmen" -> 7)
  names.collect(scores) // Yields Array(10, 7)

  val varPattern = """\{([0-9]+)\}""".r
  val message = "At {1}, there was {2} on {0}"
  val vars = Map("{0}" -> "planet 7", "{1}" -> "12:30 pm",
    "{2}" -> "a disturbance of the force.")
  val result0 = varPattern.replaceSomeIn(message, m => vars.get(m.matched))
  val result = varPattern.replaceSomeIn(message, m => vars.lift(m.matched))
//  println(result)

  def tryCatch[T](b: => T, catcher: PartialFunction[Throwable, T]) =
    try { b } catch catcher

  val str = "asd"
  val result1 = tryCatch(str.toInt,
    { case _: NumberFormatException => -1 })
  println(result1)


}
