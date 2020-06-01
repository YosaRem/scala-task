package task

import cats.effect.{ExitCode, IO, IOApp}
import sttp.client._
import sttp.model.Uri

import scala.io.StdIn

object task extends IOApp {
//  val repos = """
//  [
//  {
//    "id":266222848,
//    "node_id":"MDEwOlJlcG9zaXRvcnkyNjYyMjI4NDg=",
//    "name":"CacheDNS",
//    "full_name":"YosaRem/CacheDNS",
//    "private":false,
//    "html_url":"https://github.com/YosaRem/CacheDNS",
//    "description":"Task for protocols",
//    "fork":false,
//    "url":"https://api.github.com/repos/YosaRem/CacheDNS",
//    "forks_url":"https://api.github.com/repos/YosaRem/CacheDNS/forks",
//    "keys_url":"https://api.github.com/repos/YosaRem/CacheDNS/keys{/key_id}",
//    "collaborators_url":"https://api.github.com/repos/YosaRem/CacheDNS/collaborators{/collaborator}",
//    "teams_url":"https://api.github.com/repos/YosaRem/CacheDNS/teams",
//    "hooks_url":"https://api.github.com/repos/YosaRem/CacheDNS/hooks",
//    "issue_events_url":"https://api.github.com/repos/YosaRem/CacheDNS/issues/events{/number}",
//    "events_url":"https://api.github.com/repos/YosaRem/CacheDNS/events",
//    "assignees_url":"https://api.github.com/repos/YosaRem/CacheDNS/assignees{/user}",
//    "branches_url":"https://api.github.com/repos/YosaRem/CacheDNS/branches{/branch}",
//    "tags_url":"https://api.github.com/repos/YosaRem/CacheDNS/tags",
//    "blobs_url":"https://api.github.com/repos/YosaRem/CacheDNS/git/blobs{/sha}",
//    "git_tags_url":"https://api.github.com/repos/YosaRem/CacheDNS/git/tags{/sha}",
//    "git_refs_url":"https://api.github.com/repos/YosaRem/CacheDNS/git/refs{/sha}",
//    "trees_url":"https://api.github.com/repos/YosaRem/CacheDNS/git/trees{/sha}",
//    "statuses_url":"https://api.github.com/repos/YosaRem/CacheDNS/statuses/{sha}",
//    "languages_url":"https://api.github.com/repos/YosaRem/CacheDNS/languages",
//    "stargazers_url":"https://api.github.com/repos/YosaRem/CacheDNS/stargazers",
//    "contributors_url":"https://api.github.com/repos/YosaRem/CacheDNS/contributors",
//    "subscribers_url":"https://api.github.com/repos/YosaRem/CacheDNS/subscribers",
//    "subscription_url":"https://api.github.com/repos/YosaRem/CacheDNS/subscription",
//    "commits_url":"https://api.github.com/repos/YosaRem/CacheDNS/commits{/sha}",
//    "git_commits_url":"https://api.github.com/repos/YosaRem/CacheDNS/git/commits{/sha}",
//    "comments_url":"https://api.github.com/repos/YosaRem/CacheDNS/comments{/number}",
//    "issue_comment_url":"https://api.github.com/repos/YosaRem/CacheDNS/issues/comments{/number}",
//    "contents_url":"https://api.github.com/repos/YosaRem/CacheDNS/contents/{+path}",
//    "compare_url":"https://api.github.com/repos/YosaRem/CacheDNS/compare/{base}...{head}",
//    "merges_url":"https://api.github.com/repos/YosaRem/CacheDNS/merges",
//    "archive_url":"https://api.github.com/repos/YosaRem/CacheDNS/{archive_format}{/ref}",
//    "downloads_url":"https://api.github.com/repos/YosaRem/CacheDNS/downloads",
//    "issues_url":"https://api.github.com/repos/YosaRem/CacheDNS/issues{/number}",
//    "pulls_url":"https://api.github.com/repos/YosaRem/CacheDNS/pulls{/number}",
//    "milestones_url":"https://api.github.com/repos/YosaRem/CacheDNS/milestones{/number}",
//    "notifications_url":"https://api.github.com/repos/YosaRem/CacheDNS/notifications{?since,all,participating}",
//    "labels_url":"https://api.github.com/repos/YosaRem/CacheDNS/labels{/name}",
//    "releases_url":"https://api.github.com/repos/YosaRem/CacheDNS/releases{/id}",
//    "deployments_url":"https://api.github.com/repos/YosaRem/CacheDNS/deployments",
//    "created_at":"2020-05-22T22:57:13Z",
//    "updated_at":"2020-05-27T21:08:52Z",
//    "pushed_at":"2020-05-27T20:50:41Z",
//    "git_url":"git://github.com/YosaRem/CacheDNS.git",
//    "ssh_url":"git@github.com:YosaRem/CacheDNS.git",
//    "clone_url":"https://github.com/YosaRem/CacheDNS.git",
//    "svn_url":"https://github.com/YosaRem/CacheDNS",
//    "homepage":null,
//    "size":643,
//    "stargazers_count":0,
//    "watchers_count":0,
//    "language":"Python",
//    "has_issues":true,
//    "has_projects":true,
//    "has_downloads":true,
//    "has_wiki":true,
//    "has_pages":false,
//    "forks_count":0,
//    "mirror_url":null,
//    "archived":false,
//    "disabled":false,
//    "open_issues_count":0,
//    "license":null,
//    "forks":0,
//    "open_issues":0,
//    "watchers":0,
//    "default_branch":"master"
//  },
//  {
//    "id":211348776,
//    "node_id":"MDEwOlJlcG9zaXRvcnkyMTEzNDg3NzY=",
//    "name":"Chat-Bot",
//    "full_name":"YosaRem/Chat-Bot",
//    "private":false,
//    "html_url":"https://github.com/YosaRem/Chat-Bot",
//    "description":"Chat bot for OOP.",
//    "fork":false,
//    "url":"https://api.github.com/repos/YosaRem/Chat-Bot",
//    "forks_url":"https://api.github.com/repos/YosaRem/Chat-Bot/forks",
//    "keys_url":"https://api.github.com/repos/YosaRem/Chat-Bot/keys{/key_id}",
//    "collaborators_url":"https://api.github.com/repos/YosaRem/Chat-Bot/collaborators{/collaborator}",
//    "teams_url":"https://api.github.com/repos/YosaRem/Chat-Bot/teams",
//    "hooks_url":"https://api.github.com/repos/YosaRem/Chat-Bot/hooks",
//    "issue_events_url":"https://api.github.com/repos/YosaRem/Chat-Bot/issues/events{/number}",
//    "events_url":"https://api.github.com/repos/YosaRem/Chat-Bot/events",
//    "assignees_url":"https://api.github.com/repos/YosaRem/Chat-Bot/assignees{/user}",
//    "branches_url":"https://api.github.com/repos/YosaRem/Chat-Bot/branches{/branch}",
//    "tags_url":"https://api.github.com/repos/YosaRem/Chat-Bot/tags",
//    "blobs_url":"https://api.github.com/repos/YosaRem/Chat-Bot/git/blobs{/sha}",
//    "git_tags_url":"https://api.github.com/repos/YosaRem/Chat-Bot/git/tags{/sha}",
//    "git_refs_url":"https://api.github.com/repos/YosaRem/Chat-Bot/git/refs{/sha}",
//    "trees_url":"https://api.github.com/repos/YosaRem/Chat-Bot/git/trees{/sha}",
//    "statuses_url":"https://api.github.com/repos/YosaRem/Chat-Bot/statuses/{sha}",
//    "languages_url":"https://api.github.com/repos/YosaRem/Chat-Bot/languages",
//    "stargazers_url":"https://api.github.com/repos/YosaRem/Chat-Bot/stargazers",
//    "contributors_url":"https://api.github.com/repos/YosaRem/Chat-Bot/contributors",
//    "subscribers_url":"https://api.github.com/repos/YosaRem/Chat-Bot/subscribers",
//    "subscription_url":"https://api.github.com/repos/YosaRem/Chat-Bot/subscription",
//    "commits_url":"https://api.github.com/repos/YosaRem/Chat-Bot/commits{/sha}",
//    "git_commits_url":"https://api.github.com/repos/YosaRem/Chat-Bot/git/commits{/sha}",
//    "comments_url":"https://api.github.com/repos/YosaRem/Chat-Bot/comments{/number}",
//    "issue_comment_url":"https://api.github.com/repos/YosaRem/Chat-Bot/issues/comments{/number}",
//    "contents_url":"https://api.github.com/repos/YosaRem/Chat-Bot/contents/{+path}",
//    "compare_url":"https://api.github.com/repos/YosaRem/Chat-Bot/compare/{base}...{head}",
//    "merges_url":"https://api.github.com/repos/YosaRem/Chat-Bot/merges",
//    "archive_url":"https://api.github.com/repos/YosaRem/Chat-Bot/{archive_format}{/ref}",
//    "downloads_url":"https://api.github.com/repos/YosaRem/Chat-Bot/downloads",
//    "issues_url":"https://api.github.com/repos/YosaRem/Chat-Bot/issues{/number}",
//    "pulls_url":"https://api.github.com/repos/YosaRem/Chat-Bot/pulls{/number}",
//    "milestones_url":"https://api.github.com/repos/YosaRem/Chat-Bot/milestones{/number}",
//    "notifications_url":"https://api.github.com/repos/YosaRem/Chat-Bot/notifications{?since,all,participating}",
//    "labels_url":"https://api.github.com/repos/YosaRem/Chat-Bot/labels{/name}",
//    "releases_url":"https://api.github.com/repos/YosaRem/Chat-Bot/releases{/id}",
//    "deployments_url":"https://api.github.com/repos/YosaRem/Chat-Bot/deployments",
//    "created_at":"2019-09-27T15:25:17Z",
//    "updated_at":"2019-12-10T12:03:44Z",
//    "pushed_at":"2019-12-10T12:03:34Z",
//    "git_url":"git://github.com/YosaRem/Chat-Bot.git",
//    "ssh_url":"git@github.com:YosaRem/Chat-Bot.git",
//    "clone_url":"https://github.com/YosaRem/Chat-Bot.git",
//    "svn_url":"https://github.com/YosaRem/Chat-Bot",
//    "homepage":null,
//    "size":25000,
//    "stargazers_count":0,
//    "watchers_count":0,
//    "language":"Java",
//    "has_issues":true,
//    "has_projects":true,
//    "has_downloads":true,
//    "has_wiki":true,
//    "has_pages":false,
//    "forks_count":0,
//    "mirror_url":null,
//    "archived":false,
//    "disabled":false,
//    "open_issues_count":0,
//    "license":null,
//    "forks":0,
//    "open_issues":0,
//    "watchers":0,
//    "default_branch":"master"
//  },
//  {
//    "id":183210578,
//    "node_id":"MDEwOlJlcG9zaXRvcnkxODMyMTA1Nzg=",
//    "name":"Programmer-s-Dream",
//    "full_name":"YosaRem/Programmer-s-Dream",
//    "private":false,
//    "html_url":"https://github.com/YosaRem/Programmer-s-Dream",
//    "description":"Game",
//    "fork":false,
//    "url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream",
//    "forks_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/forks",
//    "keys_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/keys{/key_id}",
//    "collaborators_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/collaborators{/collaborator}",
//    "teams_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/teams",
//    "hooks_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/hooks",
//    "issue_events_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/issues/events{/number}",
//    "events_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/events",
//    "assignees_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/assignees{/user}",
//    "branches_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/branches{/branch}",
//    "tags_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/tags",
//    "blobs_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/git/blobs{/sha}",
//    "git_tags_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/git/tags{/sha}",
//    "git_refs_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/git/refs{/sha}",
//    "trees_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/git/trees{/sha}",
//    "statuses_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/statuses/{sha}",
//    "languages_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/languages",
//    "stargazers_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/stargazers",
//    "contributors_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/contributors",
//    "subscribers_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/subscribers",
//    "subscription_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/subscription",
//    "commits_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/commits{/sha}",
//    "git_commits_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/git/commits{/sha}",
//    "comments_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/comments{/number}",
//    "issue_comment_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/issues/comments{/number}",
//    "contents_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/contents/{+path}",
//    "compare_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/compare/{base}...{head}",
//    "merges_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/merges",
//    "archive_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/{archive_format}{/ref}",
//    "downloads_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/downloads",
//    "issues_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/issues{/number}",
//    "pulls_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/pulls{/number}",
//    "milestones_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/milestones{/number}",
//    "notifications_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/notifications{?since,all,participating}",
//    "labels_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/labels{/name}",
//    "releases_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/releases{/id}",
//    "deployments_url":"https://api.github.com/repos/YosaRem/Programmer-s-Dream/deployments",
//    "created_at":"2019-04-24T10:58:27Z",
//    "updated_at":"2019-05-13T15:24:15Z",
//    "pushed_at":"2019-05-13T15:24:13Z",
//    "git_url":"git://github.com/YosaRem/Programmer-s-Dream.git",
//    "ssh_url":"git@github.com:YosaRem/Programmer-s-Dream.git",
//    "clone_url":"https://github.com/YosaRem/Programmer-s-Dream.git",
//    "svn_url":"https://github.com/YosaRem/Programmer-s-Dream",
//    "homepage":null,
//    "size":403,
//    "stargazers_count":0,
//    "watchers_count":0,
//    "language":"C#",
//    "has_issues":true,
//    "has_projects":true,
//    "has_downloads":true,
//    "has_wiki":true,
//    "has_pages":false,
//    "forks_count":0,
//    "mirror_url":null,
//    "archived":false,
//    "disabled":false,
//    "open_issues_count":0,
//    "license":null,
//    "forks":0,
//    "open_issues":0,
//    "watchers":0,
//    "default_branch":"master"
//  },
//  {
//    "id":258873665,
//    "node_id":"MDEwOlJlcG9zaXRvcnkyNTg4NzM2NjU=",
//    "name":"Robots",
//    "full_name":"YosaRem/Robots",
//    "private":false,
//    "html_url":"https://github.com/YosaRem/Robots",
//    "description":"The project to learn OO design concepts and MDI application development in Java",
//    "fork":true,
//    "url":"https://api.github.com/repos/YosaRem/Robots",
//    "forks_url":"https://api.github.com/repos/YosaRem/Robots/forks",
//    "keys_url":"https://api.github.com/repos/YosaRem/Robots/keys{/key_id}",
//    "collaborators_url":"https://api.github.com/repos/YosaRem/Robots/collaborators{/collaborator}",
//    "teams_url":"https://api.github.com/repos/YosaRem/Robots/teams",
//    "hooks_url":"https://api.github.com/repos/YosaRem/Robots/hooks",
//    "issue_events_url":"https://api.github.com/repos/YosaRem/Robots/issues/events{/number}",
//    "events_url":"https://api.github.com/repos/YosaRem/Robots/events",
//    "assignees_url":"https://api.github.com/repos/YosaRem/Robots/assignees{/user}",
//    "branches_url":"https://api.github.com/repos/YosaRem/Robots/branches{/branch}",
//    "tags_url":"https://api.github.com/repos/YosaRem/Robots/tags",
//    "blobs_url":"https://api.github.com/repos/YosaRem/Robots/git/blobs{/sha}",
//    "git_tags_url":"https://api.github.com/repos/YosaRem/Robots/git/tags{/sha}",
//    "git_refs_url":"https://api.github.com/repos/YosaRem/Robots/git/refs{/sha}",
//    "trees_url":"https://api.github.com/repos/YosaRem/Robots/git/trees{/sha}",
//    "statuses_url":"https://api.github.com/repos/YosaRem/Robots/statuses/{sha}",
//    "languages_url":"https://api.github.com/repos/YosaRem/Robots/languages",
//    "stargazers_url":"https://api.github.com/repos/YosaRem/Robots/stargazers",
//    "contributors_url":"https://api.github.com/repos/YosaRem/Robots/contributors",
//    "subscribers_url":"https://api.github.com/repos/YosaRem/Robots/subscribers",
//    "subscription_url":"https://api.github.com/repos/YosaRem/Robots/subscription",
//    "commits_url":"https://api.github.com/repos/YosaRem/Robots/commits{/sha}",
//    "git_commits_url":"https://api.github.com/repos/YosaRem/Robots/git/commits{/sha}",
//    "comments_url":"https://api.github.com/repos/YosaRem/Robots/comments{/number}",
//    "issue_comment_url":"https://api.github.com/repos/YosaRem/Robots/issues/comments{/number}",
//    "contents_url":"https://api.github.com/repos/YosaRem/Robots/contents/{+path}",
//    "compare_url":"https://api.github.com/repos/YosaRem/Robots/compare/{base}...{head}",
//    "merges_url":"https://api.github.com/repos/YosaRem/Robots/merges",
//    "archive_url":"https://api.github.com/repos/YosaRem/Robots/{archive_format}{/ref}",
//    "downloads_url":"https://api.github.com/repos/YosaRem/Robots/downloads",
//    "issues_url":"https://api.github.com/repos/YosaRem/Robots/issues{/number}",
//    "pulls_url":"https://api.github.com/repos/YosaRem/Robots/pulls{/number}",
//    "milestones_url":"https://api.github.com/repos/YosaRem/Robots/milestones{/number}",
//    "notifications_url":"https://api.github.com/repos/YosaRem/Robots/notifications{?since,all,participating}",
//    "labels_url":"https://api.github.com/repos/YosaRem/Robots/labels{/name}",
//    "releases_url":"https://api.github.com/repos/YosaRem/Robots/releases{/id}",
//    "deployments_url":"https://api.github.com/repos/YosaRem/Robots/deployments",
//    "created_at":"2020-04-25T21:02:22Z",
//    "updated_at":"2020-05-17T10:26:01Z",
//    "pushed_at":"2020-05-29T15:37:10Z",
//    "git_url":"git://github.com/YosaRem/Robots.git",
//    "ssh_url":"git@github.com:YosaRem/Robots.git",
//    "clone_url":"https://github.com/YosaRem/Robots.git",
//    "svn_url":"https://github.com/YosaRem/Robots",
//    "homepage":null,
//    "size":53,
//    "stargazers_count":0,
//    "watchers_count":0,
//    "language":"Java",
//    "has_issues":false,
//    "has_projects":true,
//    "has_downloads":true,
//    "has_wiki":true,
//    "has_pages":false,
//    "forks_count":0,
//    "mirror_url":null,
//    "archived":false,
//    "disabled":false,
//    "open_issues_count":1,
//    "license":null,
//    "forks":0,
//    "open_issues":1,
//    "watchers":0,
//    "default_branch":"master"
//  },
//  {
//    "id":267907317,
//    "node_id":"MDEwOlJlcG9zaXRvcnkyNjc5MDczMTc=",
//    "name":"scala-task",
//    "full_name":"YosaRem/scala-task",
//    "private":false,
//    "html_url":"https://github.com/YosaRem/scala-task",
//    "description":"task for scala",
//    "fork":false,
//    "url":"https://api.github.com/repos/YosaRem/scala-task",
//    "forks_url":"https://api.github.com/repos/YosaRem/scala-task/forks",
//    "keys_url":"https://api.github.com/repos/YosaRem/scala-task/keys{/key_id}",
//    "collaborators_url":"https://api.github.com/repos/YosaRem/scala-task/collaborators{/collaborator}",
//    "teams_url":"https://api.github.com/repos/YosaRem/scala-task/teams",
//    "hooks_url":"https://api.github.com/repos/YosaRem/scala-task/hooks",
//    "issue_events_url":"https://api.github.com/repos/YosaRem/scala-task/issues/events{/number}",
//    "events_url":"https://api.github.com/repos/YosaRem/scala-task/events",
//    "assignees_url":"https://api.github.com/repos/YosaRem/scala-task/assignees{/user}",
//    "branches_url":"https://api.github.com/repos/YosaRem/scala-task/branches{/branch}",
//    "tags_url":"https://api.github.com/repos/YosaRem/scala-task/tags",
//    "blobs_url":"https://api.github.com/repos/YosaRem/scala-task/git/blobs{/sha}",
//    "git_tags_url":"https://api.github.com/repos/YosaRem/scala-task/git/tags{/sha}",
//    "git_refs_url":"https://api.github.com/repos/YosaRem/scala-task/git/refs{/sha}",
//    "trees_url":"https://api.github.com/repos/YosaRem/scala-task/git/trees{/sha}",
//    "statuses_url":"https://api.github.com/repos/YosaRem/scala-task/statuses/{sha}",
//    "languages_url":"https://api.github.com/repos/YosaRem/scala-task/languages",
//    "stargazers_url":"https://api.github.com/repos/YosaRem/scala-task/stargazers",
//    "contributors_url":"https://api.github.com/repos/YosaRem/scala-task/contributors",
//    "subscribers_url":"https://api.github.com/repos/YosaRem/scala-task/subscribers",
//    "subscription_url":"https://api.github.com/repos/YosaRem/scala-task/subscription",
//    "commits_url":"https://api.github.com/repos/YosaRem/scala-task/commits{/sha}",
//    "git_commits_url":"https://api.github.com/repos/YosaRem/scala-task/git/commits{/sha}",
//    "comments_url":"https://api.github.com/repos/YosaRem/scala-task/comments{/number}",
//    "issue_comment_url":"https://api.github.com/repos/YosaRem/scala-task/issues/comments{/number}",
//    "contents_url":"https://api.github.com/repos/YosaRem/scala-task/contents/{+path}",
//    "compare_url":"https://api.github.com/repos/YosaRem/scala-task/compare/{base}...{head}",
//    "merges_url":"https://api.github.com/repos/YosaRem/scala-task/merges",
//    "archive_url":"https://api.github.com/repos/YosaRem/scala-task/{archive_format}{/ref}",
//    "downloads_url":"https://api.github.com/repos/YosaRem/scala-task/downloads",
//    "issues_url":"https://api.github.com/repos/YosaRem/scala-task/issues{/number}",
//    "pulls_url":"https://api.github.com/repos/YosaRem/scala-task/pulls{/number}",
//    "milestones_url":"https://api.github.com/repos/YosaRem/scala-task/milestones{/number}",
//    "notifications_url":"https://api.github.com/repos/YosaRem/scala-task/notifications{?since,all,participating}",
//    "labels_url":"https://api.github.com/repos/YosaRem/scala-task/labels{/name}",
//    "releases_url":"https://api.github.com/repos/YosaRem/scala-task/releases{/id}",
//    "deployments_url":"https://api.github.com/repos/YosaRem/scala-task/deployments",
//    "created_at":"2020-05-29T16:41:27Z",
//    "updated_at":"2020-05-29T16:55:15Z",
//    "pushed_at":"2020-05-29T16:55:12Z",
//    "git_url":"git://github.com/YosaRem/scala-task.git",
//    "ssh_url":"git@github.com:YosaRem/scala-task.git",
//    "clone_url":"https://github.com/YosaRem/scala-task.git",
//    "svn_url":"https://github.com/YosaRem/scala-task",
//    "homepage":null,
//    "size":23,
//    "stargazers_count":0,
//    "watchers_count":0,
//    "language":"Scala",
//    "has_issues":true,
//    "has_projects":true,
//    "has_downloads":true,
//    "has_wiki":true,
//    "has_pages":false,
//    "forks_count":0,
//    "mirror_url":null,
//    "archived":false,
//    "disabled":false,
//    "open_issues_count":0,
//    "license":null,
//    "forks":0,
//    "open_issues":0,
//    "watchers":0,
//    "default_branch":"master"
//  },
//  {
//    "id":256631276,
//    "node_id":"MDEwOlJlcG9zaXRvcnkyNTY2MzEyNzY=",
//    "name":"task1",
//    "full_name":"YosaRem/task1",
//    "private":false,
//    "html_url":"https://github.com/YosaRem/task1",
//    "description":"The first task for protocol",
//    "fork":false,
//    "url":"https://api.github.com/repos/YosaRem/task1",
//    "forks_url":"https://api.github.com/repos/YosaRem/task1/forks",
//    "keys_url":"https://api.github.com/repos/YosaRem/task1/keys{/key_id}",
//    "collaborators_url":"https://api.github.com/repos/YosaRem/task1/collaborators{/collaborator}",
//    "teams_url":"https://api.github.com/repos/YosaRem/task1/teams",
//    "hooks_url":"https://api.github.com/repos/YosaRem/task1/hooks",
//    "issue_events_url":"https://api.github.com/repos/YosaRem/task1/issues/events{/number}",
//    "events_url":"https://api.github.com/repos/YosaRem/task1/events",
//    "assignees_url":"https://api.github.com/repos/YosaRem/task1/assignees{/user}",
//    "branches_url":"https://api.github.com/repos/YosaRem/task1/branches{/branch}",
//    "tags_url":"https://api.github.com/repos/YosaRem/task1/tags",
//    "blobs_url":"https://api.github.com/repos/YosaRem/task1/git/blobs{/sha}",
//    "git_tags_url":"https://api.github.com/repos/YosaRem/task1/git/tags{/sha}",
//    "git_refs_url":"https://api.github.com/repos/YosaRem/task1/git/refs{/sha}",
//    "trees_url":"https://api.github.com/repos/YosaRem/task1/git/trees{/sha}",
//    "statuses_url":"https://api.github.com/repos/YosaRem/task1/statuses/{sha}",
//    "languages_url":"https://api.github.com/repos/YosaRem/task1/languages",
//    "stargazers_url":"https://api.github.com/repos/YosaRem/task1/stargazers",
//    "contributors_url":"https://api.github.com/repos/YosaRem/task1/contributors",
//    "subscribers_url":"https://api.github.com/repos/YosaRem/task1/subscribers",
//    "subscription_url":"https://api.github.com/repos/YosaRem/task1/subscription",
//    "commits_url":"https://api.github.com/repos/YosaRem/task1/commits{/sha}",
//    "git_commits_url":"https://api.github.com/repos/YosaRem/task1/git/commits{/sha}",
//    "comments_url":"https://api.github.com/repos/YosaRem/task1/comments{/number}",
//    "issue_comment_url":"https://api.github.com/repos/YosaRem/task1/issues/comments{/number}",
//    "contents_url":"https://api.github.com/repos/YosaRem/task1/contents/{+path}",
//    "compare_url":"https://api.github.com/repos/YosaRem/task1/compare/{base}...{head}",
//    "merges_url":"https://api.github.com/repos/YosaRem/task1/merges",
//    "archive_url":"https://api.github.com/repos/YosaRem/task1/{archive_format}{/ref}",
//    "downloads_url":"https://api.github.com/repos/YosaRem/task1/downloads",
//    "issues_url":"https://api.github.com/repos/YosaRem/task1/issues{/number}",
//    "pulls_url":"https://api.github.com/repos/YosaRem/task1/pulls{/number}",
//    "milestones_url":"https://api.github.com/repos/YosaRem/task1/milestones{/number}",
//    "notifications_url":"https://api.github.com/repos/YosaRem/task1/notifications{?since,all,participating}",
//    "labels_url":"https://api.github.com/repos/YosaRem/task1/labels{/name}",
//    "releases_url":"https://api.github.com/repos/YosaRem/task1/releases{/id}",
//    "deployments_url":"https://api.github.com/repos/YosaRem/task1/deployments",
//    "created_at":"2020-04-17T23:32:22Z",
//    "updated_at":"2020-04-18T17:38:01Z",
//    "pushed_at":"2020-04-18T17:37:59Z",
//    "git_url":"git://github.com/YosaRem/task1.git",
//    "ssh_url":"git@github.com:YosaRem/task1.git",
//    "clone_url":"https://github.com/YosaRem/task1.git",
//    "svn_url":"https://github.com/YosaRem/task1",
//    "homepage":null,
//    "size":6,
//    "stargazers_count":0,
//    "watchers_count":0,
//    "language":"Python",
//    "has_issues":true,
//    "has_projects":true,
//    "has_downloads":true,
//    "has_wiki":true,
//    "has_pages":false,
//    "forks_count":0,
//    "mirror_url":null,
//    "archived":false,
//    "disabled":false,
//    "open_issues_count":0,
//    "license":null,
//    "forks":0,
//    "open_issues":0,
//    "watchers":0,
//    "default_branch":"master"
//  },
//  {
//    "id":260040040,
//    "node_id":"MDEwOlJlcG9zaXRvcnkyNjAwNDAwNDA=",
//    "name":"tinkoff-payment",
//    "full_name":"YosaRem/tinkoff-payment",
//    "private":false,
//    "description":"Django app for integration with tinkoff payment api",
//    "fork":false,
//    "url":"https://api.github.com/repos/YosaRem/tinkoff-payment",
//    "forks_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/forks",
//    "keys_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/keys{/key_id}",
//    "collaborators_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/collaborators{/collaborator}",
//    "teams_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/teams",
//    "hooks_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/hooks",
//    "issue_events_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/issues/events{/number}",
//    "events_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/events",
//    "assignees_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/assignees{/user}",
//    "branches_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/branches{/branch}",
//    "tags_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/tags",
//    "blobs_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/git/blobs{/sha}",
//    "git_tags_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/git/tags{/sha}",
//    "git_refs_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/git/refs{/sha}",
//    "trees_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/git/trees{/sha}",
//    "statuses_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/statuses/{sha}",
//    "languages_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/languages",
//    "stargazers_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/stargazers",
//    "contributors_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/contributors",
//    "subscribers_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/subscribers",
//    "subscription_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/subscription",
//    "commits_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/commits{/sha}",
//    "git_commits_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/git/commits{/sha}",
//    "comments_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/comments{/number}",
//    "issue_comment_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/issues/comments{/number}",
//    "contents_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/contents/{+path}",
//    "compare_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/compare/{base}...{head}",
//    "merges_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/merges",
//    "archive_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/{archive_format}{/ref}",
//    "downloads_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/downloads",
//    "issues_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/issues{/number}",
//    "pulls_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/pulls{/number}",
//    "milestones_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/milestones{/number}",
//    "notifications_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/notifications{?since,all,participating}",
//    "labels_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/labels{/name}",
//    "releases_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/releases{/id}",
//    "deployments_url":"https://api.github.com/repos/YosaRem/tinkoff-payment/deployments",
//    "created_at":"2020-04-29T20:34:40Z",
//    "updated_at":"2020-05-01T18:35:18Z",
//    "pushed_at":"2020-05-01T18:35:15Z",
//    "git_url":"git://github.com/YosaRem/tinkoff-payment.git",
//    "ssh_url":"git@github.com:YosaRem/tinkoff-payment.git",
//    "clone_url":"https://github.com/YosaRem/tinkoff-payment.git",
//    "svn_url":"https://github.com/YosaRem/tinkoff-payment",
//    "homepage":null,
//    "size":18,
//    "stargazers_count":0,
//    "watchers_count":0,
//    "language":"Python",
//    "has_issues":true,
//    "has_projects":true,
//    "has_downloads":true,
//    "has_wiki":true,
//    "has_pages":false,
//    "forks_count":0,
//    "mirror_url":null,
//    "archived":false,
//    "disabled":false,
//    "open_issues_count":0,
//    "license":null,
//    "forks":0,
//    "open_issues":0,
//    "watchers":0,
//    "default_branch":"master"
//  }
//  ]
//  """
//  val followers = """
//  [
//  {
//    "login":"IlyaBat9",
//    "id":7255833,
//    "node_id":"MDQ6VXNlcjcyNTU4MzM=",
//    "avatar_url":"https://avatars3.githubusercontent.com/u/7255833?v=4",
//    "gravatar_id":"",
//    "url":"https://api.github.com/users/IlyaBat9",
//    "html_url":"https://github.com/IlyaBat9",
//    "followers_url":"https://api.github.com/users/IlyaBat9/followers",
//    "following_url":"https://api.github.com/users/IlyaBat9/following{/other_user}",
//    "gists_url":"https://api.github.com/users/IlyaBat9/gists{/gist_id}",
//    "starred_url":"https://api.github.com/users/IlyaBat9/starred{/owner}{/repo}",
//    "subscriptions_url":"https://api.github.com/users/IlyaBat9/subscriptions",
//    "organizations_url":"https://api.github.com/users/IlyaBat9/orgs",
//    "repos_url":"https://api.github.com/users/IlyaBat9/repos",
//    "events_url":"https://api.github.com/users/IlyaBat9/events{/privacy}",
//    "received_events_url":"https://api.github.com/users/IlyaBat9/received_events",
//    "type":"User",
//    "site_admin":false
//  },
//  {
//    "login":"toplenboren",
//    "id":33755274,
//    "node_id":"MDQ6VXNlcjMzNzU1Mjc0",
//    "avatar_url":"https://avatars2.githubusercontent.com/u/33755274?v=4",
//    "gravatar_id":"",
//    "url":"https://api.github.com/users/toplenboren",
//    "html_url":"https://github.com/toplenboren",
//    "followers_url":"https://api.github.com/users/toplenboren/followers",
//    "following_url":"https://api.github.com/users/toplenboren/following{/other_user}",
//    "gists_url":"https://api.github.com/users/toplenboren/gists{/gist_id}",
//    "starred_url":"https://api.github.com/users/toplenboren/starred{/owner}{/repo}",
//    "subscriptions_url":"https://api.github.com/users/toplenboren/subscriptions",
//    "organizations_url":"https://api.github.com/users/toplenboren/orgs",
//    "repos_url":"https://api.github.com/users/toplenboren/repos",
//    "events_url":"https://api.github.com/users/toplenboren/events{/privacy}",
//    "received_events_url":"https://api.github.com/users/toplenboren/received_events",
//    "type":"User",
//    "site_admin":false
//  }
//  ]
//  """
//
  override def run(args: List[String]): IO[ExitCode] = {
    val console = new Console[IO] {
      override def printLine(str: String): IO[Unit] = IO(println(str))
      override def readLine: IO[String] = IO(StdIn.readLine())
    }

    val client = new Client[IO] {
      implicit val backend = HttpURLConnectionBackend()
      override def get(url: Uri): IO[Either[String, String]] = IO(basicRequest.get(url).send().body)
    }

    new Task(console, client).solve().map(_ => ExitCode.Success)
  }
}
