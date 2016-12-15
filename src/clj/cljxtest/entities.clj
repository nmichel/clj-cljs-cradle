(ns cljxtest.entities
  (:require [cljxtest.proto :as proto]))

(deftype Rotor [p a]
  proto/Entity
  (proto/update [this world]
    this))
