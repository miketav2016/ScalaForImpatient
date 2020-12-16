package ch9FilesAndRegularExpressions.CH8Serialization

import scala.collection.mutable.ArrayBuffer

/**You can omit the @SerialVersionUID annotation if you are OK with the default ID.*/
@SerialVersionUID(42L) class Person extends Serializable {
  private val friends = new ArrayBuffer[Person] // OK—ArrayBuffer is serializable

}
object A extends App {
  val fred = new Person()
  import java.io._
  val out = new ObjectOutputStream(new FileOutputStream("src/main/scala/chapter9/CH8Serialization/test.obj"))
  out.writeObject(fred)
  out.close()
  val in = new ObjectInputStream(new FileInputStream("src/main/scala/chapter9/CH8Serialization/test.obj"))
  val savedFred = in.readObject().asInstanceOf[Person]
}
