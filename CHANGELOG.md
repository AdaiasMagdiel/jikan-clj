# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/spec/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [0.2.0] - 2026-01-29

### Added

- New `configure` function to allow global settings like `:base-url`.
- Added `anime-characters` to fetch character and staff information.
- Added `anime-episodes` with support for both episode lists and specific episode details.
- Added automated `deploy` task to `build.clj`.

### Changed

- Refactored `base-url` to use a Clojure Atom for dynamic configuration.
- Improved documentation strings (docstrings) for all public functions.
- Increased test stability by adding delays between API calls to avoid rate limiting.

## [0.1.0] - 2026-01-29

### Added

- Initial release of `jikan-clj`.
- Basic anime resource fetching via `anime` function.
- Support for full anime data retrieval using optional `full?` parameter.
- Automated build system using `tools.build`.
- Test suite configured with Kaocha.
- Error handling for 404 (Not Found) responses returning `nil` instead of throwing exceptions.
- GPLv3 License and project metadata (POM).
