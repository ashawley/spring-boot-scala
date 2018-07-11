package hello

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class HelloApplication

object HelloApplication {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[HelloApplication]);
  }
}
