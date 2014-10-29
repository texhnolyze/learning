(ns templating.conversion
  (:require [templating.fileops :refer [file-exists?]]))

(defn convert
  [file]
  (if (file-exists? file)
    (do (println "converting " file))))
