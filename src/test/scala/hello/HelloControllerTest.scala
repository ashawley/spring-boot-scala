package hello

import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.equalTo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.http.MediaType

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(classOf[SpringRunner])
@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

  @Autowired
  var mvc: MockMvc = _

  @Test
  def indexGet: Unit = {
    mvc.perform(get("/").accept(MediaType.TEXT_HTML))
      .andExpect(status.isNotFound)
      .andExpect(content.string(equalTo("")))
  }

  @Test
  def helloGet: Unit = {
    mvc.perform(get("/hello").accept(MediaType.TEXT_PLAIN))
      .andExpect(status.isOk)
      .andExpect(content.string(equalTo("Hello world!")))
  }
}
