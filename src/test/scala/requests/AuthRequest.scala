package requests

import io.gatling.core.Predef._
import io.gatling.core.feeder.FeederBuilderBase
import io.gatling.http.Predef._

import java.io.{BufferedWriter, FileWriter}

object AuthRequest {
  val getAccessToken = exec(http("Get Auth Token")
      .post("http://10.254.1.192:8103/api/v1/auth/login/")
      .body(ElFileBody("resources/datafile.json"))
      .header("content-type", "application/json")
      .check(
        status.is(200),
        jsonPath("$.accessToken.accessToken").saveAs("accessToken"),
        ))
    .exec { session =>
      val fw = new BufferedWriter(new FileWriter("accessToken.txt", true))
      try {
        fw.write(session("accessToken").as[String] + "\r\n")
      }
      finally fw.close()

      val accessToken = session("accessToken").as[String]
      val refreshToken = session("refreshToken").as[String]
      TokenManager.accessToken = Some(accessToken)
      TokenManager.refreshToken = Some(refreshToken)
      println(s"Access Token: $accessToken")

      session
    }

  val useAccessToken = exec(
    session => {

      TokenManager.accessToken match {
        case Some(token) => session.set("accessToken", token)
        case None => session
      }
    }
  )
}
