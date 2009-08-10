(ns application.config.server
  (:use skyway
        (application.config [routes :as routes])))

(defserver application-server {:port 8080}
  "/*" (servlet routes/application-routes))


