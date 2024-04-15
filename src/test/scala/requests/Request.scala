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

  def auth = {
    exec {
      http("Login")
        .post("api/v1/auth/login/")
        .body(StringBody("""
{
    "login": "user",
    "password": "user",
    "role": "KEEPER"
}
""")).asJson
        .header("content-type", "application/json")
    }
  }

  def getPlanetById = {
    exec {
      http("Get Planet By Id")
        .get("api/v1/planet-app/planets/1")
        .header("content-type", "application/json")
        .check(status.is(200))
    }
  }

}
