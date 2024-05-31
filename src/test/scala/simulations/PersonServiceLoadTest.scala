package simulations

import config.Urls._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scenarios.Simulation._
import scala.concurrent.duration._

class PersonServiceLoadTest extends Simulation{
  var httpConf = http.baseUrl(personUrl)

  setUp(
    getAccessToken.inject(atOnceUsers(1)),
    personScen.inject(
      constantConcurrentUsers(toNbUsers).during(duration seconds))
  ).protocols(httpConf)
}
