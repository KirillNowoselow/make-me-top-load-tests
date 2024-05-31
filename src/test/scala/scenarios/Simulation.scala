package scenarios
import io.gatling.core.Predef._
import requests._
import requests.Request._

object Simulation {
  val toNbUsers: Int = System.getProperty("toNbUsers", "1").toInt
  val duration: Int = System.getProperty("duration", "1").toInt

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

  def homeworkScen = scenario("HomeworkScenario")
    .exec(AuthRequest.useAccessToken)
    .exec(getHomeWorkByHomeWorkId)
    .exec(getHomeWorkByThemeId)
    .exec(createHomeworkForTheme)
    .exec(deleteHomework)
}
