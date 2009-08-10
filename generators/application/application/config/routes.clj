(ns application.config.routes
  (:use skyway
        (application.controllers login)))

(defroutes application-routes
  (GET   "/"      (html [:p "hi"]))
  (GET   "/login" (login-controller))
  (ANY   "*"      (page-not-found)))
