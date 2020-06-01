package task

import cats.effect.{ExitCode, IO, IOApp}
import sttp.client._
import sttp.model.Uri

import scala.io.StdIn
import scala.util.matching.Regex

object task extends IOApp {
  val repos = """
  [
  {
    "name":"Chat-Bot",
    "stargazers_count":0
  },
  {
    "name":"Robots",
    "stargazers_count":10
  },
  {
    "name":"scala-task"
    "stargazers_count":50
  }
  ]
  """
  val followers = """
  [
  {
    "login":"S1"
  },
  {
    "login":"S2"
  }
  ]
  """
  val reposS1 = """
    [
    {
      "name": "S11"
      "stargazers_count":5
    },
    {
      "name": "S12",
      "stargazers_count":49
    }
    ]
    """
  val reposS2 = """
    [
    {
      "name": "S21"
      "stargazers_count":19
    },
    {
      "name": "S22",
      "stargazers_count":51
    }
    ]
    """
  override def run(args: List[String]): IO[ExitCode] = {
    val console = new Console[IO] {
      override def printLine(str: String): IO[Unit] = IO(println(str))
      override def readLine: IO[String] = IO(StdIn.readLine())
    }

    val client = new Client[IO] {
      implicit val backend = HttpURLConnectionBackend()
      override def get(url: Uri): IO[Either[String, String]] = IO(basicRequest.get(url).send().body)

      override def get(url: String) = get(uri"$url")
    }

    val clientMock = new Client[IO] {
      override def get(url: Uri) = IO(Right("No use"))

      val regEx = "https://api.github/users/([0-9a-zA-Z]+?)/([a-z]+?)".r

      override def get(url: String) = url match {
        case regEx(y, x) if y == "S1" && x == "repos" => IO(Right(reposS1))
        case regEx(y, x) if y == "S2" && x == "repos" => IO(Right(reposS2))
        case regEx(_, x) if x == "repos" => IO(Right(repos))
        case regEx(_, x) if x == "followers" => IO(Right(followers))
        case _ => IO(Left("Error"))
      }
    }

    new Task(console, clientMock).solve().map(_ => ExitCode.Success)
  }
}
