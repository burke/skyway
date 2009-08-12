(ns skyway.mvc
  "MVC-related functions. View rendering, etc.")


(defmulti invoke-controller identity)

(defmacro defcontroller
  "Add a new controller, without futzing around with defmethod."
  [name argv & rest]
  `(defmethod invoke-controller '~name
     [~'_ ~@argv]
     ~@rest))


(defmulti render-view identity)

(defmacro defview
  "Add a new view, without futzing around with defmethod."
  [name argv & rest]
  `(defmethod render-view '~name
     [~'_ ~@argv]
     ~@rest))
