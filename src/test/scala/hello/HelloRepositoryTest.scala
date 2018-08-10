package hello

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import org.springframework.transaction.annotation.Transactional

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.assertThat

import org.hamcrest.Matchers.equalTo

import scala.collection.JavaConverters.seqAsJavaListConverter
import scala.collection.JavaConverters.setAsJavaSetConverter

@RunWith(classOf[SpringRunner])
@SpringBootTest
@EnableNeo4jRepositories(Array("hello"))
@Transactional
class HelloRepositoryTest {

  val hello = Hello("Hello world!")

  val howAreYou = Hello("How are you?")
  
  @Autowired
  var hellos: HelloRepository = _

  @Before
  def setUp: Unit = {
    hello.replyWith(howAreYou)
    hellos.save(hello)
  }

  @Test
  def testCount: Unit = {
    assertThat(hellos.count, equalTo(2L))
  }

  @Test
  def testFindByGreetingFound: Unit = {
    val found = hellos.findByGreeting("Hello world!")
    assertThat(found, equalTo(List(hello).asJava))
    assertThat(found.get(0).replies, equalTo(Set(howAreYou).asJava))
  }

  @Test
  def testFindByGreetingNotFound: Unit = {
    val notFound = hellos.findByGreeting("Hello world?")
    assertThat(notFound, equalTo(List.empty[Hello].asJava))
  }

  @Test
  def testgetRepliesByGreeting: Unit = {
    val replies = hellos.getRepliesByGreeting("Hello world!")
    assertThat(replies, equalTo(List(howAreYou).asJava))
  }
}
