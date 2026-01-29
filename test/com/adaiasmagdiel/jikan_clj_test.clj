(ns com.adaiasmagdiel.jikan-clj-test
  (:require [clojure.test :refer [deftest is testing]]
            [com.adaiasmagdiel.jikan-clj :as jikan]))

(deftest anime-fetch-test
  (testing "Fetching a known anime (Cowboy Bebop)"
    (let [result (jikan/anime 1)]
      (is (not (nil? result)))
      (is (= "Cowboy Bebop" (:title result)))))

  (testing "Fetching a non-existent anime returns nil"
    (is (nil? (jikan/anime 42)))))
