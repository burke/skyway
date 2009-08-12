(ns application.config.routes
  (:use skyway))

(require 'application.controllers.login)

(defroutes application-routes
  (GET   "/login" (invoke-controller 'login))
  (ANY   "*"      (page-not-found)))

