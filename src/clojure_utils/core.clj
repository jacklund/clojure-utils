(ns clojure-utils.core)

(defn get-running-threads
  "Get a map of the current running threads as keys and their stack traces as values"
  []
  (into {} (map
             #(vector (first %)
                      (into [] (second %)))
             (into {} (Thread/getAllStackTraces)))))
