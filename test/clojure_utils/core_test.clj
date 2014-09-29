(ns clojure-utils.core-test
  (:require [clojure.test :refer :all]
            [clojure-utils.core :refer :all]))

(deftest get-running-threads-test
  (let [thread-name "Test-thread"]
    (.start (Thread. #(Thread/sleep 2000) thread-name))
    (let [threads (get-running-threads)]
      (is (not (empty? (filter
                         #(= (.getName (first %)) thread-name)
                         threads)))))))
