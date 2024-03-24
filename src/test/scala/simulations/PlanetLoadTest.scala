package simulations
import io.gatling.http.Predef._
import io.gatling.core.Predef._
import scenarios.Simulation.{PlanetRequestScen}

class PlanetLoadTest extends Simulation{
  val httpConf = http.baseUrl("http://localhost:8103/")
    .header("Accept", "application/json")
    .proxy(Proxy("localhost", 8103))

  setUp(
    PlanetRequestScen.inject(
      constantUsersPerSec(1) during 1
    ).protocols(httpConf)
  )
}
