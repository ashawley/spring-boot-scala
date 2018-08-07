package hello

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
trait HelloRepository extends CrudRepository[Hello, java.lang.Long] {

  def findByGreeting(string: String): java.util.List[Hello]
}
