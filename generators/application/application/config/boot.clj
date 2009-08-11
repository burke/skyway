(ns application.boot
  (:use skyway
        (application.config [server :as server])))

(start server/application-server)
