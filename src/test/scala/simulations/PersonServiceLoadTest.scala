package simulations

import config.Urls._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scenarios.Simulation._

import scala.concurrent.duration._
import scala.language.postfixOps


class PersonServiceLoadTest extends Simulation{
  var httpConf = http.baseUrl(personUrl)

  setUp(
    getAccessToken.inject(atOnceUsers(1)),
    personScen.inject(
      rampConcurrentUsers(1).to(addUsersPerStep).during(stepTime seconds))
  ).protocols(httpConf)
}
