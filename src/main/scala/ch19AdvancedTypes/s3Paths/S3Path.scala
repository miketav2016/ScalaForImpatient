package ch19AdvancedTypes.s3Paths

import ch19AdvancedTypes.s2TypeProjections.Network


object S3Path extends App {
  ch13Collections.s1TheMainCollectionsTraits.A.coll0
  var chatter = new Network
  val chatter1 = new Network
//  val fred = new chatter.Member  // Error—chatter is not stable
  /*Since you might assign a different value to chatter, the compiler can’t assign a definite meaning to
  the type chatter.Member.*/
  val fred1 = new chatter1.Member("")

}

