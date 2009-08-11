(ns skyway.mvc
  "MVC-related functions. View rendering, etc.")

(defmacro render-view
  [view & rest]
  (let [view-ns (symbol (str "application.views." view))
        render-fn (symbol (str view-ns "/render"))]
    `(do (require '~view-ns)
         (~render-fn ~@rest))))

(defmacro invoke-controller
  [controller & rest]
  (let [controller-ns (symbol (str "application.controllers." controller))
        invoke-fn (symbol (str controller-ns "/invoke"))]
    `(do (require '~controller-ns)
         (~invoke-fn ~@rest))))





