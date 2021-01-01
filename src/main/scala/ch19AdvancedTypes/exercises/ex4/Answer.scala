package ch19AdvancedTypes.exercises.ex4

import ch19AdvancedTypes.s2TypeProjections.NetWorkFix

object Answer extends App {
  val myFaceF: NetWorkFix = new NetWorkFix
  val chatterF: NetWorkFix = new NetWorkFix

  val barneyF: myFaceF.MemberF = myFaceF.join("Barney")
  val felixF: myFaceF.MemberF = myFaceF.join("Felix")
  val fredF: chatterF.MemberF = chatterF.join("Fred")
  fredF.contacts += barneyF // now work
  fredF.contacts += felixF
  val boo0 = felixF.equals(barneyF)
  val boo1 = felixF.equals(fredF)
  println(boo0)
  println(boo1)



}
