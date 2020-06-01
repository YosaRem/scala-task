package task

import io.circe.parser._
import io.circe.generic.auto._
import cats.effect.IO

class Task(console: Console[IO], client: Client[IO]) {
  val REPOS = "repos"
  val FOLLOWERS = "followers"

  def solve(): IO[Unit] = for {
    login <- console.readLine
    userRepos <- client.get(Task.requestStr(login, REPOS))
    userFollowers <- client.get(Task.requestStr(login, FOLLOWERS))
    repos = decode[List[Repo]](userRepos.fold(l => l, r => r))
    followers = decode[List[Follower]](userFollowers.fold(l => l, r => r))
    (repo, stars) = repos.fold(_ => ("NO", -1), Task.getMaxStar)
    (followerRepo, followerStars) = maxFollowers(followers.fold(_ => List(Follower("NO")), r => r)).maxBy(_._2)
    _ <- if (followerStars > stars) console.printLine(s"В репозитории $followerRepo $followerStars") else
      console.printLine(s"Нет репозиториев, в которых звёзд больше чем $stars")

  } yield ()

  def maxFollowers(followers: List[Follower]): List[(String, Int)] = for {
    follower <- followers
    json = client.get(Task.requestStr(follower.login, REPOS)).unsafeRunSync()
    repos = decode[List[Repo]](json.fold(l => l, r => r))
  } yield repos.fold(_ => ("NO", -1), Task.getMaxStar)
}

object Task {
  def requestStr(repoName: String, method: String) = s"https://api.github.com/users/$repoName/$method"

  def getMaxStar(repos: List[Repo]): (String, Int) = {
    val repo = repos.maxBy(_.stargazers_count)
    (repo.name, repo.stargazers_count)
  }
}
