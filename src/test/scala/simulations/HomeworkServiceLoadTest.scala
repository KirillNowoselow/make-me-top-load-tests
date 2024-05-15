package simulations

import io.gatling.http.Predef._
import io.gatling.core.Predef._
import scenarios.Simulation._
import config.Urls._
import scala.concurrent.duration.DurationInt

class HomeworkServiceLoadTest extends Simulation{
  var httpConf = http.baseUrl(homeWorkUrl)

  setUp(
    getAccessToken.inject(atOnceUsers(1)),
    homeworkScen.inject(
      rampConcurrentUsers(1).to(addUsersPerStep).during(stepTime seconds))
  ).protocols(httpConf)
}
