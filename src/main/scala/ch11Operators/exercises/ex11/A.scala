package ch11Operators.exercises.ex11

import ch11Operators.DynamicProps

object A extends App {
  val sysProps = new DynamicProps(System.getProperties)
  val home0 = sysProps.java_home
  //val home1 = sysProps.java.home // must work...
  println(home0)
  println(sysProps.user_name)
}
