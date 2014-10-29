(ns templating.conversion
  (:require [templating.fileops :refer [file-exists?]]))

(defn convert
  [file]
  (if (file-exists? file)
    (println "converting " file)
    (println "file does not exist " file)))
