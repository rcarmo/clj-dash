(defproject
  clj-dash "0.1.0-SNAPSHOT"
  :description "ClojureScript on Angular"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2014"]
                 [xnlogic/clobber "0.1.0-SNAPSHOT"]
                 [com.taoensso/carmine "2.3.1"]]
  :source-paths ["client"]
  :plugins [[lein-cljsbuild "1.0.0-alpha2"]]

  :cljsbuild {:repl-launch-commands {"firefox" ; lein cljsbuild trampoline repl-launch firefox path/to/html
                                       ["/Applications/Firefox.app/Contents/MacOS/firefox"
                                        "-jsconsole"
                                        :stdout ".repl-firefox-out"
                                        :stderr ".repl-firefox-err"]
                                     "ff"
                                       ["/Applications/Firefox.app/Contents/MacOS/firefox"
                                        "-jsconsole"
                                        "resources/public/index.html"
                                        :stdout ".repl-firefox-out"
                                        :stderr ".repl-firefox-err"]
                                     }
              :repl-listen-port 9000
              :notify-command ["osascript" "-e" "'display notification \"%s\" with title \"leiningen\" subtitle \"cljsbuild\"'"]

              :builds
              {:dev
               {:source-paths ["client" "app"]
                :compiler {:output-to "resources/public/js/clj-dash_dbg.js"
                           :optimizations :whitespace
                           :pretty-print true}}

               :prod
               {:source-paths ["client" "app"]
                :compiler {:output-to "resources/public/js/clj-dash.js"
                           :pretty-print false
                           :optimizations :advanced}}

               :pre-prod
               {:source-paths ["client" "app"]
                :compiler {:output-to "resources/public/js/clj-dash_pre.js"
                           :optimizations :simple
                           :pretty-print true}}}})


