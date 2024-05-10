package simulations

import io.gatling.http.Predef._
import io.gatling.core.Predef._
import scenarios.Simulation._
import config.Urls._

class HomeWorkServiceLoadTest extends Simulation{
  val httpConf = http.baseUrl(homeWorkUrl)

  setUp(
    homeWorkScen.inject(
      constantUsersPerSec(1) during(1)
    ).protocols(httpConf)
  )
}
