package task

import sttp.model.Uri

trait Client[F[_]] {
  def get(url: Uri): F[Either[String, String]]
}

trait Console[F[_]] {
  def readLine: F[String]
  def printLine(str: String): F[Unit]
}