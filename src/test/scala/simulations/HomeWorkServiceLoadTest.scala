package simulations

import io.gatling.http.Predef._
import io.gatling.core.Predef._
import scenarios.Simulation._

class HomeWorkServiceLoadTest extends Simulation{
  val httpConf = http.baseUrl("http://10.254.1.192:8107/")

  setUp(
    homeWorkScen.inject(
      constantUsersPerSec(1) during(1)
    ).protocols(httpConf)
  )
}
