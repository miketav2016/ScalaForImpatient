package chapter9.exercises.exercise10

import scala.collection.mutable.ArrayBuffer


/** You can omit the @SerialVersionUID annotation if you are OK with the default ID. */
@SerialVersionUID(42L) class Person(val name: String, friend: Person*) extends Serializable {
  private[Person] val friends = new ArrayBuffer[Person]
  addFriend(friend: _*)

  def addFriend(value: Person*): Unit = {
    for (f <- value) {
      if (!friends.contains(this)) {
        f.friends += this
        friends += f
      }
    }
  }

  def listFriend: String = friends.foldLeft("")((list, p) => list + " " + p.name)
}

object DirectoriesClassCount extends App {
  val p0 = new Person("fred")
  val p1 = new Person("makar", p0)
  val p2 = new Person("azat")
  val p3 = new Person("ahmed", p1, p2)
  val ap: Array[Person] = Array(p0, p1, p2, p3)

  import java.io._

  val out = new ObjectOutputStream(new FileOutputStream("src/main/scala/chapter9/exercises/exercise10/test.obj"))
  out.writeObject(ap)
  out.close()
  val in = new ObjectInputStream(new FileInputStream("src/main/scala/chapter9/exercises/exercise10/test.obj"))
  val savedFred = in.readObject().asInstanceOf[Array[Person]]
  savedFred.foreach(f => println(f.listFriend))
}