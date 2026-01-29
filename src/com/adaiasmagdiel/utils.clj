(ns com.adaiasmagdiel.utils
  (:require [clj-http.client :as client]))

(defn fetch-safe
  "Internal helper to handle HTTP GET without crashing on 404."
  [url]
  (let [{:keys [status body]} (client/get url {:as :json :throw-exceptions false})]
    (when (not= status 404)
      (:data body))))