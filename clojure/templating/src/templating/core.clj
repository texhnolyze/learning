(ns templating.core
  (:gen-class)
  (:require [templating.conversion :refer [convert]]))

(defn -main
  "run application"
  [file]
  (convert file))
