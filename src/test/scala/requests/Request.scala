package requests
import io.gatling.http.Predef._
import io.gatling.core.Predef._
import io.gatling.core.feeder.{BatchableFeederBuilder, FeederBuilderBase}

import scala.reflect.internal.util.BatchSourceFile


object Request {
  def jsonFeed(path: String):FeederBuilderBase[Any] = {
    val feeder = jsonFile(path)
    return feeder
  }

  var getToken = exec(
    http("Get Auth Token")
      .post("http://10.254.1.192:8103/api/v1/auth/login/")
      .body(ElFileBody("resources/datafile.json")).asJson
      .header("content-type", "application/json")
      .check(jsonPath("$.accessToken.accessToken").saveAs("accessToken"))
  )

  def getPlanetById = {
    exec {
      http("Get Planet By Id")
        .get("api/v1/planet-app/planets/1/")
        .header("content-type", "application/json")
        .header("Authorization", "Bearer ${accessToken}")
        .check(status.is(200))
    }
  }

  def getSystems = {
    exec {
      http("Get Planet By Id")
        .get("api/v1/galaxy-app/systems/")
        .header("content-type", "application/json")
        .header("Authorization", "Bearer ${accessToken}")
        .check(status.is(200))
    }
  }

}
