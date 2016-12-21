(ns cljxtest.core
  (:gen-class))

(defn echo [v] v)

(defn -main
  [v]
  (println (str "Echo " v)))

;; See :aliases in project.clj

;; Running in repl
;; 
;; shell> lein clj-repl
;; 
;; user=> (require '[cljxtest core])
;; user=> (cljxtest.core/-main 42)
;; Echo 42
;; nil

;; Running from a shell
;; 
;; shell> lein clj uberjar
;; shell> java -cp ./target/uberjar/cljxtest-0.1.0-SNAPSHOT-standalone.jar cljxtest.core John


