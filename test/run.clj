(ns test.run
  (:use clojure.contrib.test-is)
  (:require test.skyway.crypto)
  (:require test.skyway.html.gen)
  (:require test.skyway.html.form-helpers)
  (:require test.skyway.http.helpers)
  (:require test.skyway.http.middleware)
  (:require test.skyway.http.routes)
  (:require test.skyway.http.request)
  (:require test.skyway.http.response)
  (:require test.skyway.http.session)
  (:require test.skyway.str-utils)
  (:require test.skyway.validation))

(run-tests
  'test.skyway.crypto
  'test.skyway.html.gen
  'test.skyway.html.form-helpers
  'test.skyway.http.helpers
  'test.skyway.http.middleware
  'test.skyway.http.routes
  'test.skyway.http.request
  'test.skyway.http.response
  'test.skyway.http.session
  'test.skyway.str-utils
  'test.skyway.validation)
