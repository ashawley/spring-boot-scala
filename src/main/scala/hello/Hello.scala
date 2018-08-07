package hello

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

import scala.beans.BeanProperty

@Entity
class Hello {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @BeanProperty
  var id: Long = _

  @BeanProperty
  var greeting: String = _
}
object Hello {
  def apply(greeting: String) = {
    val hello = new Hello
    hello.greeting = greeting
    hello
  }
}
