import sys
from git import Repo

OLD_EMAIL = "danmiee@github.com"
CORRECT_NAME = "danmiee"
CORRECT_EMAIL = "dan-mi@kakao.com"

repo = Repo('.')
for commit in repo.iter_commits('--all'):
    if commit.author.email == OLD_EMAIL:
        commit.author.email = CORRECT_EMAIL
        commit.author.name = CORRECT_NAME
    if commit.committer.email == OLD_EMAIL:
        commit.committer.email = CORRECT_EMAIL
        commit.committer.name = CORRECT_NAME
    commit.update()

