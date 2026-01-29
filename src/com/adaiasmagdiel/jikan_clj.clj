(ns com.adaiasmagdiel.jikan-clj
  "Main library namespace for Jikan API wrapper."
  (:require [com.adaiasmagdiel.utils :as utils]))

(def ^:private settings
  (atom {:base-url "https://api.jikan.moe/v4"}))

(defn configure
  "Globally configures the wrapper options.
   
   Currently supports:
   - `:base-url`: The root URL for the Jikan API.
   
   Example:
   (configure {:base-url \"https://my-proxy-server.com/v4\"})"
  [config]
  (swap! settings merge config))

;; === ANIME

(defn anime
  "Fetches anime details by ID. Returns nil if not found.
  
     Maps to Jikan API:
     - false: `GET /anime/{id}`
     - true:  `GET /anime/{id}/full`"
  ([id] (anime id false))
  ([id full?]
   (let [endpoint (str "/anime/" id (if full? "/full" ""))
         url (str (:base-url @settings) endpoint)]
     (utils/fetch-safe url))))
