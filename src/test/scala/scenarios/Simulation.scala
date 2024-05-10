package scenarios
import io.gatling.core.Predef._
import requests._
import requests.Request._

object Simulation {
  val addUsersPerStep: Int = System.getProperty("addUsersPerStep", "1").toInt
  val stepTime: Int = System.getProperty("stepTime", "1").toInt
  val stepCnt: Int = System.getProperty("stepCnt", "1").toInt
  val stabilityStepTime: Int = System.getProperty("stabilityStepTime", "2").toInt

  val getAccessToken = scenario("Get token")
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
  def personScen = scenario("PersonScenario")
    .exec(AuthRequest.useAccessToken)
    .exec(goToProfile)

  def homeWorkScen = scenario("HomeWorkScenario")
    .exec(AuthRequest.useAccessToken)
    .exec(getHomeWorkByHomeWorkId)
}
