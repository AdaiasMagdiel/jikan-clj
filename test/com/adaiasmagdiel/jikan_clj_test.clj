(ns com.adaiasmagdiel.jikan-clj-test
  (:require [clojure.test :refer [deftest is testing]]
            [com.adaiasmagdiel.jikan-clj :as jikan]))

;; Helper to avoid rate limiting (429) during integration tests
(defn- wait-a-bit [] (Thread/sleep 2500))

(deftest anime-fetch-test
  (testing "Fetching a known anime (Cowboy Bebop)"
    (let [result (jikan/anime 1)]
      (is (not (nil? result)))
      (is (= "Cowboy Bebop" (:title result)))))

  (wait-a-bit)
  (testing "Fetching full anime data"
    (let [result (jikan/anime 1 true)]
      (is (not (nil? result)))
      (is (contains? result :relations))))

  (wait-a-bit)
  (testing "Fetching a non-existent anime returns nil"
    (is (nil? (jikan/anime 42)))))
