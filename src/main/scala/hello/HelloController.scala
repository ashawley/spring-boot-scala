package hello

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping(Array("/hello"))
class HelloController {

    @GetMapping(produces = Array("text/plain"))
    def index: String = {
      "Hello world!"
    }
}
