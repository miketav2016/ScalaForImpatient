package ch19AdvancedTypes.s2TypeProjections

import scala.collection.mutable.ArrayBuffer

class NetWorkFix {

  class MemberF(val name: String) {
    val contacts = new ArrayBuffer[NetWorkFix#MemberF]

    override def equals(obj: Any): Boolean = {
      obj match {
        case _: MemberF => true
        case _ => false
      }
    }
  }

  private val members = new ArrayBuffer[MemberF]

  def join(name: String): MemberF = {
    val m: MemberF = new MemberF(name)
    members += m
    m
  }
}