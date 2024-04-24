package scenarios
import io.gatling.core.Predef._
import requests._
import requests.Request._

object Simulation {
  val getAccessToken = scenario("Get and use token")
    .exec(AuthRequest.getAccessToken)

  def planetScen = scenario("PlanetScenario")
    .exec(AuthRequest.useAccessToken)
    .exec(getPlanetById)
    .exec(getPlanetsBySystemId)

  def galaxyScen = scenario("GalaxyScenario")
    .exec(AuthRequest.useAccessToken)
    .exec(getSystemsById)
    .exec(getSystemsByGalaxyId)
    .exec(getGalaxiesById)
    .exec(getGalaxiesBySystemId)
    .exec(getGalaxies)

  def homeWorkScen = scenario("HomeWorkScenario")
    .exec(AuthRequest.useAccessToken)
    .exec(getHomeWorkByHomeWorkId)
}
