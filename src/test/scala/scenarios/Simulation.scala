package scenarios
import io.gatling.http.Predef._
import io.gatling.core.Predef._
import requests.Request
import requests.Request._

object Simulation {
  def GetPlanetByIdScen = scenario("getPlanetById")
    .exec(getToken)
    .pause(2)
    .exec(getPlanetById)

  def GetSustemsScen = scenario("getSystems")
    .exec(getToken)
    .pause(2)
    .exec(getSystems)
}
