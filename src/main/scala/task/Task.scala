package task

import cats.effect.IO
import sttp.client._


class Task(console: Console[IO], client: Client[IO]) {
  def solve(): IO[Unit] = for {
    a <- client.get("https://api.github/users/S1/repos")
    _ <- console.printLine(a.getOrElse("ddd"))
  } yield ()
}
