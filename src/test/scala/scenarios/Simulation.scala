package scenarios
import io.gatling.http.Predef._
import io.gatling.core.Predef._
import requests.{AuthRequest, Request}
import requests.Request._

object Simulation {
  val getAccessToken = scenario("Get token")
    .exec(AuthRequest.getAccessToken)

  def planetScen = scenario("getPlanetById")
    .exec(getAccessToken)
    .exec(getPlanetById)

  def systemsScen = scenario("getSystems")
    .exec(getAccessToken)
    .exec(getSystems)
}
