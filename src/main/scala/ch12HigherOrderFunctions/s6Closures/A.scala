package ch12HigherOrderFunctions.s6Closures

object A extends App {
  def mulBy(factor : Double) = (x : Double) => factor * x
  val triple = mulBy(3)
  val half = mulBy(0.5)
  println(s"${triple(14)} ${half(14)}") // Prints 42 7
}
/*
* Let’s look at them in slow motion.
1. The first call to mulBy sets the parameter variable factor to 3. That variable is referenced
in the body of the function (x : Double) => factor * x, which is stored in triple.
Then the parameter variable factor is popped off the runtime stack.
2. Next, mulBy is called again, now with factor set to 0.5. That variable is referenced in the
body of the function (x : Double) => factor * x, which is stored in half.
Each of the returned functions has its own setting for factor.
Such a function is called a closure. A closure consists of code together with the definitions of any
nonlocal variables that the code uses.
* */