package CH12HigherOrderFunctions.s8Currying

object A extends App {
  /*Recall that anything defined with def (in the REPL or a class or object) is a method,
   not a function.
*/
  val mul = (x: Int, y: Int) => x * y
  /*This function takes one argument, yielding a function that takes one argument*/
  /*Note the method type (x: Int)(y: Int)Int. In contrast, when you define a function,
   you must use multiple arrows, not multiple parentheses
   */
  val mulOneAtATime0 = (x: Int) => ((y: Int) => x * y)
  println(mul(7, 6))
  println(mulOneAtATime0(7)(6))

  /*When you use def, there is a shortcut for defining such curried methods in Scala*/
  def mulOneAtATime1(x: Int)(y: Int) = x * y

  println(mulOneAtATime1(7)(6))

  val a = Array("Hello", "World")
  val b = Array("hello", "world")
  println(a.corresponds(b)(_.equalsIgnoreCase(_)))
  /*
  Note that the function _.equalsIgnoreCase(_) is passed as a curried parameter, in a separate
set of (...). When you look into the Scaladoc, you will see that corresponds is declared as
def corresponds[B](that: Seq[B])(p: (A, B) => Boolean): Boolean
The that sequence and the predicate function p are separate curried parameters. The type inferencer
can figure out what B is from the type of that, and then it can use that information when analyzing
the function that is passed for p.
In our example, that is a String sequence. Therefore, the predicate is expected to have type
(String, String) => Boolean. With that information, the compiler can accept
_.equalsIgnoreCase(_) as a shortcut for (a: String, b: String) =>
a.equalsIgnoreCase(b).

   */
}
