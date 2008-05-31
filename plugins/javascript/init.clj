(def write-json)

(defn- json-array
  [coll]
  (str "[" (join-str (map write-json coll) ", ") "]"))

(defn- json-object
  [hash]
  (let [pair (fn [[k v]]
               (str (write-json k) ": " (write-json v)))]
    (str "{" (join-str (map pair hash) ", ") "}")))

(defn write-json
  [x]
  (cond
    (vector? x)          (json-array x)
    (map? x)             (json-object x)
    (string? x)          (pr-str x)
    (keyword? x)         (pr-str (name x))
    (instance? Number x) (pr-str x)))