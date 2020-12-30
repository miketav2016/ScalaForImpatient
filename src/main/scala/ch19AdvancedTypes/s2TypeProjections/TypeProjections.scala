package ch19AdvancedTypes.s2TypeProjections


object TypeProjections extends App {

  val chatter: Network = new Network
  val myFace: Network = new Network
  //chatter.Member and myFace.Member are dif erent classes
  val fred: chatter.Member = chatter.join("Fred") // Has type chatter.Member
  val barney: myFace.Member = myFace.join("Barney") // Has type myFace.Member
  //  fred.contacts += barney // Error

  val myFaceF: NetWorkFix = new NetWorkFix
  val chatterF: NetWorkFix = new NetWorkFix
  val barneyF: myFaceF.MemberF = myFaceF.join("Barney")
  val fredF = chatterF.join("Fred")
  fredF.contacts += barneyF // now work
}
