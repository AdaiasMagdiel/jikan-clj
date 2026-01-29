# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/spec/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [0.1.0] - 2026-01-29

### Added

- Initial release of `jikan-clj`.
- Basic anime resource fetching via `anime` function.
- Support for full anime data retrieval using optional `full?` parameter.
- Automated build system using `tools.build`.
- Test suite configured with Kaocha.
- Error handling for 404 (Not Found) responses returning `nil` instead of throwing exceptions.
- GPLv3 License and project metadata (POM).
