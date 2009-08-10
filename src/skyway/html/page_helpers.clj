;; Copyright (c) James Reeves. All rights reserved.
;; The use and distribution terms for this software are covered by the Eclipse
;; Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php) which
;; can be found in the file epl-v10.html at the root of this distribution. By
;; using this software in any fashion, you are agreeing to be bound by the
;; terms of this license. You must not remove this notice, or any other, from
;; this software.

(ns skyway.html.page-helpers
  "Functions for generating document and header boilerplate."
  (:use skyway.control)
  (:use skyway.html.gen)
  (:use skyway.str-utils)
  (:use clojure.contrib.str-utils)
  (:import java.net.URLEncoder))

(def doctype
  {:html4
   (str "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" "
        "\"http://www.w3.org/TR/html4/strict.dtd\">\n")

   :xhtml-strict
   (str "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" "
        "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n")

   :xhtml-transitional
   (str "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" "
        "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n")})

(defn xhtml-tag
  "Create an XHTML tag for the specified locale.
   e.g. (xhtml \"en\"
          [:head ...]
          [:body ...])"
  [lang & contents]
  [:html {:xmlns "http://www.w3.org/1999/xhtml"
          "xml:lang" lang
          :lang lang}
    contents])

(defn locate-asset
  [asset ext dir]
  (if (or (re-matches #"^[a-z]+://" asset)
          (= (.charAt asset 0) \/))
    asset
    (let [asset  (str dir asset)
          pattern (re-pattern (str "\\." ext "$"))]
      (if (and ext (not (re-find pattern asset)))
        (str asset "." ext)
        asset))))

(defn locate-js
  "Convert a possibly-shorthand javascript location to a valid one."
  [script]
  (locate-asset script "js" "/javascripts/"))

(defn locate-css
  "Convert a possibly-shorthand css location to a valid one."
  [style]
  (locate-asset style "css" "/stylesheets/"))

(defn locate-image
  "Convert a possibly-shorthand image location to a valid one."
  [image]
  (locate-asset image nil "/images/"))

(defn include-js
  "Include a list of external javascript files."
  [& scripts]
  (domap [script scripts]
    [:script {:type "text/javascript" :src (locate-js script)}]))

(defn include-css
  "Include a list of external stylesheet files."
  [& styles]
  (domap [style styles]
    [:link {:type "text/css" :href (locate-css style) :rel "stylesheet"}]))

(defn javascript-tag
  "Wrap the supplied javascript up in script tags and a CDATA section."
  [script]
  [:script {:type "text/javascript"}
    (str "//<![CDATA[\n" script "\n//]]>")])

(defn link-to
  "Wraps some content in a HTML hyperlink with the supplied URL."
  [url & content]
  [:a {:href url} content])

(defn url-encode
  "Encodes a single string or sequence of key/value pairs."
  [string-or-map]
  (let [enc #(URLEncoder/encode (str* %))]
    (if (string? string-or-map)
      (enc string-or-map)
      (str-join "&"
        (map (fn [[key val]] (str (enc key) "=" (enc val)))
             string-or-map)))))

(defn url-params
  "Encodes a map of parameters and adds them onto the end of an existing
  address.
  e.g. (url-params \"http://example.com\" {:lang \"en\", :offset 10})
       => \"http://example.com?lang=en&offset=10\""
  [address param-map]
  (str address "?" (url-encode param-map)))

(defn unordered-list
  "Wrap a collection in an unordered list"
  [coll]
  [:ul {}
    (domap [x coll]
      [:li x])])

(defn ordered-list
  "Wrap a collection in an unordered list"
  [coll]
  [:ol {}
    (domap [x coll]
      [:li x])])

(decorate-with optional-attrs
  xhtml-tag
  link-to
  unordered-list
  ordered-list)
