(ns test.skyway.html.page-helpers
  (:use skyway.html.page-helpers)
  (:use clojure.contrib.test-is))

(defn attribute
  "Get an attribute from a tag vector."
  [tag key]
  ((second tag) key))

(deftest test-locate-css
  (is (= (locate-css "style.css")
         "/stylesheets/style.css"))
  (is (= (locate-css "style")
         "/stylesheets/style.css"))
  (is (= (locate-css "http://google.com/style.css")
         "http://google.com/style.css"))
  (is (= (locate-css "/a/b/c.css")
         "/a/b/c.js")))

(deftest test-locate-js
  (is (= (locate-js "script.js")
         "/javascripts/script.js"))
  (is (= (locate-js "script")
         "/javascripts/script.js"))
  (is (= (locate-js "http://google.com/script.js")
         "http://google.com/script.js"))
  (is (= (locate-js "/a/b/c.js")
         "/a/b/c.js")))

(deftest test-locate-image
  (is (= (locate-image "image.jpg")
         "/images/image.jpg"))
  (is (= (locate-image "image")
         "/images/image")) ; Don't assume extensions for images.
  (is (= (locate-image "http://google.com/image.jpg")
         "http://google.com/image.jpg"))
  (is (= (locate-image "/a/b/c.jpg")
         "/a/b/c.jpg")))
