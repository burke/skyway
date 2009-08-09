#!/usr/bin/env clojure

(ns application.run
  (use application.config [server :as server]))

(start server/application-server)
