(ns test.skyway.str-utils
  (:use skyway.str-utils)
  (:use clojure.contrib.test-is))

(deftest test-escape
  (is (= (escape "aeiou" "hello world")
         "h\\ell\\o w\\orld")))
