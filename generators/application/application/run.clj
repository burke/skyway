#!/usr/bin/env clojure

(ns application.run
  (:use skyway
        (application.config [server :as server])))

(start server/application-server)
