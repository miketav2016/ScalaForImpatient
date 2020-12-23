package ch15Annotations.s5AnnotationsForJavaFeatures

import scala.annotation.strictfp
import scala.collection.immutable.HashMap

object JavaModifiers {
  @volatile var done = false // Becomes a volatile field in the JVM
  //A volatile field can be updated in multiple threads.

  @transient var recentLookups = new HashMap[String, String]
  // Becomes a transient field in the JVM.A transient field is not serialized.
  // This makes sense for cache data that need not be saved, or data that can easily be recomputed.

  //The @strictfp annotation is the analog of the Java strictfp modifier:
  @strictfp def calculate(x: Double) = 10
  /*
  This method does its floating-point calculations with IEEE double values, not using the 80 bit
  extended precision (which Intel processors use by default). The result is slower and less precise but
  more portable.
  */
  //The @native annotation marks methods that are implemented in C or C++ code.
  // It is the analog of the native modifier in Java.

  @native def win32RegKeys(root: Int, path: String): Array[String] = {
    Array("")
  }
}
