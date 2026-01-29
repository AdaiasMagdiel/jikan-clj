(ns build
  "Build script for com.adaiasmagdiel/jikan-clj.
   Provides tasks for cleaning and creating a JAR file."
  (:require [clojure.tools.build.api :as b]))

(def lib 'com.adaiasmagdiel/jikan-clj)
(def version "0.1.0")
(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"}))
(def jar-file (format "target/%s-%s.jar" (name lib) version))

(defn clean [_]
  (b/delete {:path "target"}))

(defn jar [_]
  (b/write-pom {:class-dir class-dir
                :lib lib
                :version version
                :basis basis
                :src-dirs ["src"]
                :pom-data [[:description "A Clojure wrapper for the Jikan (MyAnimeList) API."]
                           [:url "https://github.com/adaiasmagdiel/jikan-clj"]
                           [:scm [:url "https://github.com/adaiasmagdiel/jikan-clj"]
                            [:connection "scm:git:git://github.com/adaiasmagdiel/jikan-clj.git"]
                            [:developerConnection "scm:git:ssh://git@github.com/adaiasmagdiel/jikan-clj.git"]]
                           [:licenses
                            [:license
                             [:name "GNU General Public License v3.0"]
                             [:url "https://www.gnu.org/licenses/gpl-3.0.txt"]]]
                           [:developers
                            [:developer
                             [:name "Adaías Magdiel"]
                             [:email "eu@adaiasmagdiel.com"]
                             [:url "https://adaiasmagdiel.com"]]]]})
  (b/copy-dir {:src-dirs ["src" "resources"]
               :target-dir class-dir})
  (b/jar {:class-dir class-dir
          :jar-file jar-file}))

(defn deploy [_]
  (jar nil)
  (b/process
   {:command-args ["clojure" "-X:deploy"
                   ":artifact" jar-file]}))