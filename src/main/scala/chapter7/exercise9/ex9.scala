package chapter7.exercise9
/**Write a program that imports the java.lang.System class, reads the user name from the
user.name system property, reads a password from the StdIn object, and prints a message
to the standard error stream if the password is not "secret". Otherwise, print a greeting to
the standard output stream. Do not use any other imports, and do not use any qualified names
(with dots).
*/
import  java.lang.System.{getProperties => prop}
import  java.lang
object ex9 extends App {
  val res = prop.get("user.name")
  val password = "secret"
  if(scala.io.StdIn.readLine().equals(password))
    println(res)
  else
   println("Wrong password")
}
