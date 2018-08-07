package hello

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

import javax.persistence.PersistenceContext

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.assertThat

import org.hamcrest.Matchers.equalTo

import scala.collection.JavaConverters.seqAsJavaListConverter

@RunWith(classOf[SpringRunner])
@DataJpaTest
class HelloRepositoryJpaTest {

    val hello = Hello("Hello world!")
    
    @Autowired
    var hellos: HelloRepository = _

    @Before
    def setUp: Unit = {
      hellos.save(hello)
    }

    @After
    def tearDown: Unit = {
      hellos.deleteAll
    }

    @Test
    def testFindByGreeting: Unit = {
      assertThat(hellos.findByGreeting("Hello world?"), equalTo(List.empty[Hello].asJava))
      assertThat(hellos.findByGreeting("Hello world!"), equalTo(List(hello).asJava))
    }
}
