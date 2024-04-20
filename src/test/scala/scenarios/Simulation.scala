package scenarios
import io.gatling.core.Predef._
import requests._
import requests.Request._

object Simulation {
  val accessToken = scenario("Get and use token")
    .exec(AuthRequest.getAccessToken)
    .exec(AuthRequest.useAccessToken)

  def planetScen = scenario("PlanetScenario")
    .exec(accessToken)
    .exec(getPlanetById)
    .exec(getPlanetsBySystem)
    .exec(getPlanets)

  def galaxyScen = scenario("GalaxyScenario")
    .exec(accessToken)
    .exec(getSystemsById)
    .exec(getSystemsByGalaxyId)
    .exec(getGalaxiesById)
    .exec(getGalaxiesBySystemId)
    .exec(getGalaxiesBySystem)
    .exec(getGalaxies)

  def homeWorkScen = scenario("HomeWorkScenario")
    .exec(accessToken)
    .exec(getHomeWorks)
}
