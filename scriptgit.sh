#!/bin/bash

git add -f *
git status
git commit -m $1
git push

