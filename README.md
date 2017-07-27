# Jenkins Pipeline Shared Library sample

Sample project that provides a shared library of steps and functions for Jenkins Pipeline scripts.

[TOC]

# Getting started

This section contains instructions on how to build and use the project.

## Prerequisites

To build this project, the development machine needs the following software:

* JDK 1.8+

## Building the project

This project uses Gradle wrappers for builds and tests. To execute a full build:

### Linux/Mac

```bash
./gradlew clean test
```

### Windows

```
gradlew.bat clean test
```

## Using shared libraries

See the [Jenkins Pipeline docs][1] for a more detailed description on the various ways to use shared libraries in Pipeline
scripts.

If the shared library is defined in the Jenkins global configuration, then the build steps can be imported
with the @Library annotation:

```groovy
@Library('jenkins-pipeline-shared-library')
import se.ansig.sample.jenkins.pipeline.utility.*

node('build') {
   sayHello 'to shared libraries'
}
```

The 'sayHello' step is one of the build steps defined in this project.

# Documentation

## Jenkins Pipeline shared libraries

For more information on how to develop Jenkins Pipeline shared libraries, please see the [Jenkins docs][1] on the topic.

## Spock testing

In this project, the [Spock testing framework][2] is used for unit testing each build step. For some
tests we use the built-in support for mocks to stub out any interaction with JobDSL. See the docs on
[interaction based testing][3] for more details on how mocks work in Spock.

[1]: https://jenkins.io/doc/book/pipeline/shared-libraries/
[2]: http://spockframework.org/spock/docs/1.1/index.html
[3]: http://spockframework.org/spock/docs/1.1/interaction_based_testing.html
