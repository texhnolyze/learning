(ns templating.conversion
  (:require [templating.fileops :as fileops]))

(defn convert
  [file]
  (if (fileops/file_exists? file)
    (do (println "converting " file))
    (println "does not exist: " (str file))))
