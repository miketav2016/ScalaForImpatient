package ch21Implicits.s9Evidence

object Evidence {
  def firstLast[A, C](it: C)(implicit ev: C <:< Iterable[A]) = {
    (it.head, it.last)
  }
    //The =:= and <:< are classes with implicit values, defined in the Predef object
}
