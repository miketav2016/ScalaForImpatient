package ch18TypeParameters.s8TypeConstraints

class PairS81[T](val first: T, val second: T) {
  def smaller(implicit ev: T <:< Ordered[T]): T = {if (first < second) first else second
    /*
    You can form a Pair[URL], even though URL is not ordered. You will get an error only if you
    invoke the smaller method.
    */
  }
}