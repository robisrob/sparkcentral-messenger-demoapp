.PHONY: build
version ?= dev
PUBLISH_BRANCH=master
SHELL:=/bin/bash

build:
	./gradlew docker -DbuildNumber="${version}"

test:
	./gradlew test

publish:
	docker tag sparkcentral/sparkcentral-messenger-demoapp:${version} sparkcentralinc/sparkcentral-messenger-demoapp:${version}; \
	docker tag sparkcentral/sparkcentral-messenger-demoapp:${version} sparkcentralinc/sparkcentral-messenger-demoapp:latest; \
	docker login -u="${DOCKERHUB_USERNAME}" -p="${DOCKERHUB_PASSWORD}"; \
	docker push sparkcentralinc/sparkcentral-messenger-demoapp:${version}; \
	docker push sparkcentralinc/sparkcentral-messenger-demoapp:latest; \
	(git remote add github git@github.com:sparkcentral/sparkcentral-messenger-demoapp.git || true); \
	git checkout master; \
	git push github master; \
	git push github refs/tags/${version}; \

