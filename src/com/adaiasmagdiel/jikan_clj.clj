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
  "Retrieves detailed information about a specific anime by its MyAnimeList ID.
   Returns nil if the resource is not found.

   Args:
   - `id`: The MyAnimeList ID of the anime.
   - `full?`: When true, fetches complete data including relations and external links.

   Maps to:
   - `GET /anime/{id}` (default)
   - `GET /anime/{id}/full` (when full? is true)"
  ([id] (anime id false))
  ([id full?]
   (let [endpoint (str "/anime/" id (if full? "/full" ""))
         url (str (:base-url @settings) endpoint)]
     (utils/fetch-safe url))))

(defn anime-characters
  "Retrieves a list of characters and staff from a specific anime.
   Returns nil if the resource is not found.

   Maps to: `GET /anime/{id}/characters`"
  [id]
  (let [endpoint (str "/anime/" id "/characters")
        url (str (:base-url @settings) endpoint)]
    (utils/fetch-safe url)))

(defn anime-episodes
  "Retrieves the episode list for a specific anime or details of a single episode.
   Returns nil if the resource is not found.

   Args:
   - `id`: The MyAnimeList ID of the anime.
   - `episode`: (Optional) The specific episode number/ID.

   Maps to:
   - `GET /anime/{id}/episodes` (when episode is nil)
   - `GET /anime/{id}/episodes/{episode_id}` (when episode is provided)"
  ([id] (anime-episodes id nil))
  ([id episode]
   (let [base-path (str "/anime/" id "/episodes")
         endpoint (if (nil? episode)
                    base-path
                    (if (number? episode)
                      (str base-path "/" episode)
                      (throw (IllegalArgumentException. "Episode must be a number"))))
         url (str (:base-url @settings) endpoint)]
     (utils/fetch-safe url))))
