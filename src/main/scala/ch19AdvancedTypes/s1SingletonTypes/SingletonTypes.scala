package ch19AdvancedTypes.s1SingletonTypes

object SingletonTypes extends App {
  val article = new Document
  article.setTitle("Whatever Floats Your Boat").setAuthor("Cay Horstmann")
  val book = new Book()
  //Since the setTitle method returns this, => changed method returns 'this.type'
  book.setTitle("Scala for the Impatient").addChapter("chapter1") // WARN


  book set Title to "Scala for the Impatient"
  book.set(Title).to("Scala for the Impatient")

}
