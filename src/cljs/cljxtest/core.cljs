(ns cljxtest.core
  (:require [cljs.core :refer [enable-console-print!]]
            [reagent.core :as r]))

(enable-console-print!)

(defonce state (r/atom {:click 0
                        :text "click"
                        :range 5}))

(defn- header []
    [:div {:class "header"}
     [:span
      "Click count [" (get @state :click) "]"]

     [:div {:class "inputs"}
      [:div
       [:div {:class "input"} "range "]
       [:input {:type "text"
                :value (get @state :range)
                :on-change #(swap! state assoc :range (-> % .-target .-value))}]
       ]

      [:div
       [:div {:class "input"} "text "]
       [:input {:type "text"
                :value (get @state :text)
                :on-change #(swap! state assoc :text (-> % .-target .-value))}]
       ]
      ]
])

(defn- line [n]
 ^{:key (str "id-" n)} [:div {:class "line"} (get @state :text) " " n])

(defn- lines []
 [:div
  (let [c (get @state :click)
        r (get @state :range)]
   (for [v (range (max 0 (- c r)) c)]
        [line v]))])

(defn- view []
  [:div
   {:class "view"
    :on-click (fn []
               (let [v (get @state :click)]
                (swap! state assoc-in [:click] (inc v))))}
    [header]
    [lines]])

(defn ^:export init
  []
  (r/render-component [view] (.-body js/document)))
