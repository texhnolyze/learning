(ns templating.conversion
  (:require [templating.fileops :refer [file-exists?]]
            [templating.template-to-html :as converter]
            [clojure.xml :as xml]))

(defn convert
  [file]
  (if (file-exists? file)
    (println "converting " file)
    (println "file does not exist " file)))
