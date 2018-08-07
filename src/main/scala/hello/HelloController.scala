package hello

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

import scala.collection.JavaConverters.iterableAsScalaIterableConverter

@RestController
@RequestMapping(Array("/hello"))
class HelloController {

    @Autowired
    var helloRepository: HelloRepository = _

    @GetMapping(produces = Array("text/plain"))
    def index: String = {
      val hellos: List[Hello] = helloRepository.findByGreeting("Hello world!").asScala.toList
      val maybeHello: Option[Hello] = hellos.headOption
      val result: String = maybeHello.map {
        _.getGreeting
      }.getOrElse("Not found")
      result
    }
}
