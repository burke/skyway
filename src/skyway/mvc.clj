(ns skyway.mvc
  "MVC-related functions. View rendering, etc.")

;; Controllers ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defmulti call-controller (fn [x & _] x))
(defmacro defcontroller
  "Add a new controller, without futzing around with defmethod."
  [name argv & rest]
  `(defmethod call-controller '~name
     [~'_ ~@argv]
     ~@rest))

(defmacro invoke-controller
  [name & rest]
  (call-controller name))

;; Layouts ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defmulti call-layout (fn [x & _] x))
(defmacro deflayout
  "Add a new layout, without futzing around with defmethod."
  [name argv & rest]
  `(defmethod call-layout '~name
     [~'_ ~@argv]
     ~@rest))

(defmacro render-layout
  [name title & content]
  `(call-layout ~name ~title ~@content))

;; Views ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defmulti call-view (fn [x & _] x))
(defmacro defview
  "Add a new view, without futzing around with defmethod."
  [name argv & rest]
  `(defmethod call-view '~name
     [~'_ ~@argv]
     ~@rest))

(defmacro render-view
  [name]
  `(render-layout ~''default
                  "TITLE!"
                  (call-view '~name)))





                 
