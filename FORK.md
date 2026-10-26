# cleanyourtv-header-grid

A fork of [cleanyourtv](https://github.com/Gathin23/cleanyourtv) with an Apple TV style layout without a dock, built and
used on four Xiaomi Mi Box S (MIBOX4): two on Android TV 12, two on Android TV 9. Push the
[`header-grid`](themes/header-grid/) theme to get the look:

    TV_HOST=<tv ip> tools/theme.sh themes/header-grid

<img src="themes/header-grid/screenshot.jpg" width="640" alt="header-grid on a Mi Box S">

Everything below is a launcher switch that is **off by default**, so the reference launcher looks and behaves as
upstream until a theme turns it on. Keys are documented in [`themes/README.md`](themes/README.md), screenshots in
[`docs/switches.md`](docs/switches.md).

| Switch | What it does |
|---|---|
| `header_stacked`, `header_side` | Clock centred over the date on the left, Wi-Fi above Settings as short pills on the right, equal side margins |
| `hero_in_header`, `hero_under_clock`, `hero_every_row` | The focused app's big name in the header (or under the clock) for every row, not only the dock; no small names |
| `tile_gap` | The grid runs exactly from the date's first letter to the buttons' right edge, with one even gap across and down |
| `visible_rows` | Exactly N rows on screen; Down scrolls a whole row at a time (also on the TV: Launcher settings > Rows on screen) |
| `grid_order` | The order of the grid after the dock apps |
| `focus_zoom`, `glass_style: double` | A bigger focus zoom and a black-and-white double focus frame that reads on white and dark banners |
| `hero_font`, `clock_font`, `dream_*` | Bold title and clock, and a bold, centred clock screensaver |
| `app_redirects` | When the firmware opens an app by itself, open another one instead. On Android 9 Mi Box S the LIVE button is routed to Live Channels before any key helper sees it, so `com.google.android.tv=<kodi package>` makes it a Kodi button |

Also: a **Theme** row in Launcher settings that switches between layouts built into the launcher
(`launcher/app/src/main/assets/presets/`) on top of the installed theme, keeping app order, remote buttons and the
screensaver; whole-row scrolling without the jump from RecyclerView's estimated scroll offset; and the Wi-Fi pill
re-measured when the network name arrives after the first layout.

Tested on: Xiaomi Mi Box S (MIBOX4), Android TV 12 (STTC.230106.001, firmware 4560) and Android TV 9 (PI.3595, PI.3933).
Launcher unit tests, lint and the release build pass; the APK is about 542 KB (gate 576 KB).
