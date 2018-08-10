package hello

import org.springframework.stereotype.Repository
import org.springframework.data.neo4j.annotation.Query
import org.springframework.data.neo4j.repository.GraphRepository
import org.springframework.data.repository.query.Param

trait HelloRepository extends GraphRepository[Hello] {

  def findByGreeting(greeting: String): java.util.List[Hello]

  @Query("MATCH (hello:Hello { greeting: {greeting} })<-[:REPLIES]-(reply) RETURN reply")
  def getRepliesByGreeting(@Param("greeting") greeting: String): java.util.List[Hello]
}
