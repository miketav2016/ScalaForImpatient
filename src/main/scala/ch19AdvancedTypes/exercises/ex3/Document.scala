package ch19AdvancedTypes.exercises.ex3

object Title

object Author

class Document {
  private var title: String = ""
  private var author: String = ""

  def setTitle(title: String): this.type = {
    this.title = title
    this
  }

  def setAuthor(author: String): this.type = {
    this.author = author
    this
  }

  private var useNextArgAs: Any = null

  /** Note the Title.type parameter. You can’t use
   * def set(obj: Title) ... // Error
   * since Title denotes the singleton object, not a type.
   */
  def set(obj: Title.type): this.type = {
    useNextArgAs = obj
    this
  }

  def set(obj: Author.type): this.type = {
    useNextArgAs = obj
    this
  }

  def to(arg: String) = {
    if (useNextArgAs == Title)
      title = arg
    this
  }


}
