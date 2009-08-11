(ns application.views.layouts.default
  (:use skyway))

(defmacro render
  ""
  [title & rest]
  `(str (doctype :xhtml-strict)
        (html (xhtml-tag "en"
               [:head
                (include-css "style")
                (include-js  "jquery" "jquery.autocomplete" "jquery.facelist")
                [:title ~title]]
               [:body ~@rest]))))

