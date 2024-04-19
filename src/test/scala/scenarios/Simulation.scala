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
    .exec(AuthRequest.useAccessToken)
    .pause(2)
    .exec(getPlanetById)

  def systemsScen = scenario("getSystems")
    .exec(getAccessToken)
    .exec(AuthRequest.useAccessToken)
    .pause(4)
    .exec(getGalaxies)
    .exec(getSystemsById)
}
