package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scenarios.Simulation._
import config.Urls._

import scala.concurrent.duration._
import scala.language.postfixOps

class GalaxyServiceLoadTest extends Simulation{
  var httpConf = http.baseUrl(galaxyUrl)

  setUp(
    getAccessToken.inject(atOnceUsers(1)),
    galaxyScen.inject(
      rampConcurrentUsers(1).to(addUsersPerStep).during(stepTime seconds))
  ).protocols(httpConf)
}