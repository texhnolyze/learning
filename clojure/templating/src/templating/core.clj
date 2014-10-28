(ns templating.core
  (:gen-class)
  (:require [templating.conversion :as conversion]))

(defn -main
  "run application"
  [file & args]
  (conversion/convert file))
