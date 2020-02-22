# Davos Client

[![Alpha](https://img.shields.io/badge/Stability-Alpha-red)](https://img.shields.io/badge/Stability-Alpha-red) [![Build Status](https://travis-ci.org/pacphi/davos-client.svg?branch=master)](https://travis-ci.org/pacphi/davos-client) [![Known Vulnerabilities](https://snyk.io/test/github/pacphi/davos-client/badge.svg?style=plastic)](https://snyk.io/test/github/pacphi/davos-client) [![Release](https://jitpack.io/v/pacphi/davos-client.svg)](https://jitpack.io/#pacphi/davos-client/master-SNAPSHOT) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)


Davos exposes data about vulnerabilities in both commercial and open-source software product releases.  This client has been implemented to make it easier to query and consume such data. It leverages Java, Spring Boot, Project Reactor, and OpenFeign to expose a complement of the API backing the [Davos UI](https://davos.cfapps.io).

## Table of Contents

  * [Prerequisites](#prerequisites)
  * [Tools](#tools)
  * [Clone](#clone)
  * [How to Build](#how-to-build)
  * [How to Use](#how-to-use)
  * [MVP Notes](#mvp-notes)
  * [Credits](#credits)


## Prerequisites

Required

* A [Pivotal Davos](https://davos.cfapps.io) account


## Tools

* [git](https://git-scm.com/downloads) 2.20.1 or better
* [JDK](http://openjdk.java.net/install/) 11 or better
* [uaac](https://github.com/cloudfoundry/cf-uaac) 4.1.0 or better


## Clone

```
git clone https://github.com/pacphi/davos-client.git
```


## How to Build

```
./gradlew build
```


## How to Use

Declare a dependency on `davos-client` in your project's build configuration

    // TODO


### with Gradle

    // TODO

### with Maven

    // TODO

Consult [DavosClient](src/main/java/io/davos/DavosClient.java) for an overview.

### Samples

    // TODO


## MVP Notes

davos-client was born out of some random thinking during a flight home from Austin to Seattle.  What's here is just a core dump of the process I used to implement what exists in this repository to-date.

I'm looking for help to make this client ultimately useable.  I have some ideas on how I'd like to integrate this with [cf-butler](https://github/pacphi/cf-butler).  Perhaps it'll simply offer a Pivotal Application Service operator a way to know exactly what complement of an installed base of products contains critical vulnerabilities.  Metrics and measures to be defined later.

* Open Safari
* Visit https://davos.cfapp.io
  * Login with valid credentials (i.e., username/email and password)
  * Davos is backed by https://uaa.run.pivotal.io
  * Somehow an auth token is being managed for access
* The first page you are redirected to after login is https://davos.cfapps.io/notices
* Open Web Inspector.  From Safari menu choose Develop > Show Web Inspector
* Click on the Network tab
* Refresh the page (you may or may not need to do this to see notices)
* Click on the XHR tab
  * Note that notices appears in far left column; click on it
  * You will see a Summary section which is broken into multiple sub-sections (Preview and Headers are possibly the most interesting)
  * Note the URL in th Preview sub-section and the JSON payload in the Preview sub-section
  * Copy and paste the URL and JSON payloads into a text file for consultation
* Build out the domain model
  * Trim each JSON payload, then for each payload, you can generate POJOs.  These will inform the design of each interface method in a DavosClient, particularly the method return signature.  Since we've chosen to implement a Reactor-based client the return types will be either Flux or Mono.
* Playtika's Reactive Feign library cuts down on boilerplate so all we have to do is define an interface
* Click around the Davos UI and consult the XHR tab
  * This is how we learn about the API (path and optional request parameters)

> Does Davos have a public API? Need to understand how to authenticate appropriately to gain access.  A mix of configuration and implementation updates will undoubtedly be required.  Current thinking embodied in [DavosClientTests](src/test/java/io/pivotal/davos/DavosClientTests.java).


## Credits

* [jsonschema2pojo](http://www.jsonschema2pojo.org)
* [Reactive Feign](https://github.com/Playtika/feign-reactive)
* [Safari's Web Inspector](https://developer.apple.com/safari/tools/)
* [User Account and Authentication Server](https://docs.run.pivotal.io/concepts/architecture/uaa.html)