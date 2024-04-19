package requests
object TokenManager {
  var accessToken: Option[String] = None
  var refreshToken: Option[String] = None

  // Метод для обновления токена с использованием refresh token
  def refreshAccessToken(): Unit = {
    // Логика обновления токена с использованием refreshToken
    // Здесь должен быть запрос к серверу для получения нового access token
    // Например:
    // val newToken = // логика обновления токена
    // accessToken = Some(newToken)
  }
}
