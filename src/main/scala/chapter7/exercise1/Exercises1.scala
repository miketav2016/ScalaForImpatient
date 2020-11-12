package chapter7.exercise1
/**Write an example program to demonstrate that
package com.horstmann.impatient
is not the same as
package com
package horstmann
 */
object Exercises1 extends App{
  println(com.horstmann.impatient.A.A)
  println(com.horstmann.B.B)
  println(com.B.B)
}
