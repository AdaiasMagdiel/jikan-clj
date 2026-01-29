# jikan-clj

A Clojure wrapper for the [Jikan API](https://jikan.moe/) (v4), the most popular open-source MyAnimeList component.

## Status

**Alpha** - This project is in its early stages. Currently, it supports basic anime resource fetching.

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

;; Fetch basic anime details by ID
(jikan/anime 1) ;; /anime/1

;; Fetch full anime details (including relations and external links)
(jikan/anime 1 true) ;; /anime/1/full

;; Returns nil if the anime is not found (404)
(jikan/anime 42)
```

## API Support

| Function | API Endpoint           | Description         |
| -------- | ---------------------- | ------------------- |
| `anime`  | `GET /anime/{id}`      | Basic anime details |
| `anime`  | `GET /anime/{id}/full` | Full anime details  |

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
