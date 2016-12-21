(ns cljxtest.core
  (:require [cljs.core :refer [enable-console-print!]]))

(enable-console-print!)

(defn- build-frame
  [hook]
  (let [frame (.createElement js/document "div")
        title (.createElement js/document "div")]
    (set! (.-innerHTML title) "CLICK ME")
    (.add (.-classList title) "title")
    (.appendChild frame title)
    (.appendChild hook frame)
    frame
    ))

(defn ^:export init
  []
  (let [body (.-body js/document)
        root (build-frame body)]
    (.addEventListener root "click" (fn [event]
                                      (let [e (.createElement js/document "div")]
                                        (set! (.-innerHTML e) "click")
                                        (set! (.-classList e) "line")
                                        (.appendChild root e))))))

;; See :aliases in project.clj

;; Running in figwheel
;; 
;; shell> lein cljs-fig
;; Figwheel: Cutting some fruit, just a sec ...
;; Figwheel: Validating the configuration found in project.clj
;; ...
;; Prompt will show when Figwheel connects to your application
;; To quit, type: :cljs/quit
;; cljs.user=>

;; Building production bundle
;; shell> lein cljs cljsbuild once client-prod
;; Compiling ClojureScript...
;; Compiling "resources/scripts/cljxtest-bundle.js" from ["src/cljs"]...
;; Successfully compiled "resources/scripts/cljxtest-bundle.js" in 11.986 seconds.
;; shell> 


