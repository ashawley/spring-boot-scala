package hello

import java.util.HashSet
import java.util.Set

import scala.beans.BeanProperty

import org.neo4j.ogm.annotation.GraphId
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

@NodeEntity
class Hello {
  @GraphId
  var id: java.lang.Long = _

  @BeanProperty
  var greeting: String = _

  override def equals(x: Any) = {
    x match {
      case h: Hello => greeting == h.greeting
      case _ => false
    }
  }

  override def toString = {
    s"${getClass.getName}(${greeting})"
  }

  @Relationship(
    `type` = "REPLIES",
    direction = Relationship.INCOMING
  )
  var replies: java.util.Set[Hello]  = new java.util.HashSet[Hello]

  def replyWith(that: Hello): Unit = {
    replies.add(that)
  }
}
object Hello {
  def apply(greeting: String) = {
    val hello = new Hello
    hello.greeting = greeting
    hello
  }
}
