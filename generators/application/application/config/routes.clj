(sky-ns config.routes)

(defroutes application-routes
  (GET   "/"      (html [:p "hi"]))
  (GET   "/login" (invoke-controller login))
  (ANY   "*"      (page-not-found)))

