package simulations

import io.gatling.http.Predef._
import io.gatling.core.Predef._
import scenarios.Simulation._
import config.Urls._

class PlanetServiceLoadTest extends Simulation{
  val httpConf = http.baseUrl(planetUrl)

  setUp(
    planetScen.inject(
      constantUsersPerSec(1) during 1
    ).protocols(httpConf)
  )
}
