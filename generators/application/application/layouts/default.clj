(sky-ns layout default)

(deflayout default
  [title & rest]
  `(str (doctype :xhtml-strict)
        (html (xhtml-tag "en"
               [:head
                (include-css "style")
                (include-js  "jquery" "jquery.autocomplete" "jquery.facelist")
                [:title ~title]]
               [:body
                [:h3 "I'm in ur layout."]
                [:hr]
                ~@rest]))))
