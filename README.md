# jikan-clj

[![Clojars Project](https://img.shields.io/clojars/v/com.adaiasmagdiel/jikan-clj.svg)](https://clojars.org/com.adaiasmagdiel/jikan-clj)
![status](https://img.shields.io/badge/status-alpha-orange)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

A Clojure wrapper for the [Jikan API](https://jikan.moe/) (v4), the most popular open-source MyAnimeList component.

## Status

**Alpha** - This project is in its early stages. Breaking changes may occur as we expand API coverage.

## Installation

Add the following dependency to your `deps.edn`:

```clojure
com.adaiasmagdiel/jikan-clj {:mvn/version "0.1.0"}
```

## Usage

Require the library in your namespace:

```clojure
(ns my-app.core
  (:require [com.adaiasmagdiel.jikan-clj :as jikan]))

;; --- Configuration (Optional) ---
;; Set a custom base URL (e.g., for proxies or local mocks)
(jikan/configure {:base-url "https://my-proxy-server.com/v4"})

;; --- Anime ---

;; Fetch basic anime details by ID
(jikan/anime 1) ;; GET /anime/1

;; Fetch full anime details (including relations and external links)
(jikan/anime 1 true) ;; GET /anime/1/full

;; Get characters and staff
(jikan/anime-characters 1) ;; GET /anime/1/characters

;; Get all episodes
(jikan/anime-episodes 1) ;; GET /anime/1/episodes

;; Get specific episode details
(jikan/anime-episodes 1 12) ;; GET /anime/1/episodes/12
```

## API Support

| Function           | API Endpoint                    | Description                     |
| ------------------ | ------------------------------- | ------------------------------- |
| `configure`        | N/A                             | Global settings (base-url, etc) |
| `anime`            | `GET /anime/{id}`               | Basic anime details             |
| `anime`            | `GET /anime/{id}/full`          | Full anime details              |
| `anime-characters` | `GET /anime/{id}/characters`    | Characters and Staff            |
| `anime-episodes`   | `GET /anime/{id}/episodes`      | List of episodes                |
| `anime-episodes`   | `GET /anime/{id}/episodes/{id}` | Specific episode info           |

## Development

### Building the JAR

To clean the target folder and build a new JAR file:

```bash
clj -T:build clean
clj -T:build jar
```

### Running Tests

```bash
clj -M:test
```

## License

Copyright © 2026 Adaías Magdiel

This program and the accompanying materials are made available under the terms of the **GNU General Public License v3.0**. See [`LICENSE`](LICENSE) and [`COPYRIGHT`](COPYRIGHT) for more details.
