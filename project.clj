(defproject cljxtest "0.1.0-SNAPSHOT"
  :description "A clojure and clojurescript cradle project"
  :url "https://github.com/nmichel/clj-cljs-cradle"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :plugins [[lein-pprint "1.1.2"]]
  :target-path "target/%s"

  :figwheel {
             :http-server-root "public"
             :server-port 3449
             :server-ip   "127.0.0.1"
             :css-dirs ["resources/styles"]
             :open-file-command "notepad++"
            }

  :profiles {
             :clj {
                   :dependencies []
                   :source-paths ["src/clj"]
                   :main         ^:skip-aot cljxtest.core
                  }

             :cljs {
                    :clean-targets ^{:protect false} ["resources/scripts/build"
                                                      "resources/scripts/cljxtest.js"
                                                      "resources/scripts/cljxtest-bundle.js"
                                                      "resources/scripts/cljxtest-bundle.js.map"
                                                      :target-path]
                    :dependencies  [[org.clojure/clojurescript "1.9.293"]]
                    :plugins [[lein-cljsbuild "1.1.5" :exclusions [org.clojure/clojure]]
                              [lein-figwheel "0.5.8"]]
                    :cljsbuild {
                                :builds {
                                         :client-dev {
                                                      :source-paths ["src/cljs"]
                                                      :figwheel {
                                                                 :websocket-host      "127.0.0.1"
                                                                 :load-warninged-code true
                                                                }
                                                      :compiler {
                                                                 :output-dir    "resources/scripts/build/dev"
                                                                 :output-to     "resources/scripts/cljxtest.js"
                                                                 :optimizations :none
                                                                 :source-map    true
                                                                 :foreign-libs  []
                                                                }}
                                         :client-prod {
                                                       :source-paths ["src/cljs"]
                                                       :compiler {
                                                                  :output-dir    "resources/scripts/build/prod"
                                                                  :output-to     "resources/scripts/cljxtest-bundle.js"
                                                                  :optimizations :advanced
                                                                  :source-map    "resources/scripts/cljxtest-bundle.js.map"
                                                                  :pretty-print  false
                                                                  :foreign-libs  []
                                                                 }}}}
                   }
 
             :uberjar {:aot :all}
            }

  :aliases {
            "clj" ["with-profile" "+clj"]
            "clj-repl" ["with-profile" "+clj" "repl"]
            "cljs" ["with-profile" "+cljs"]
            "cljs-fig" ["with-profile" "+cljs" "figwheel" "client-dev"]
            "cljs-build" ["with-profile" "+cljs" "cljsbuild" "once" "client-prod"]
           }
)
