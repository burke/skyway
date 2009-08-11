;; Copyright (c) James Reeves. All rights reserved.
;; The use and distribution terms for this software are covered by the Eclipse
;; Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php) which
;; can be found in the file epl-v10.html at the root of this distribution. By
;; using this software in any fashion, you are agreeing to be bound by the
;; terms of this license. You must not remove this notice, or any other, from
;; this software.

(ns skyway
  "Convenience library that includes every skyway.* namespace. If you want
   to access Skyway quickly, and don't care about having everything in one
   namespace, just use or require 'skyway."
  (:use skyway.ns-utils))

(immigrate
  'skyway.control
  'skyway.mvc
  'skyway.html.gen
  'skyway.html.page-helpers
  'skyway.html.form-helpers
  'skyway.http.helpers
  'skyway.http.middleware
  'skyway.http.multipart
  'skyway.http.routes
  'skyway.http.servlet
  'skyway.http.session
  'skyway.server.jetty
  'skyway.str-utils
  'skyway.map-utils
  'skyway.validation)
