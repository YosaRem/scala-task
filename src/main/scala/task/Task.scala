package task

import cats.effect.IO

class Task(console: Console[IO], client: Client[IO]) {
  def solve(): IO[Unit] = for {
    _ <-console.printLine("string")
  } yield ()
}
