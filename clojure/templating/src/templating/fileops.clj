(ns templating.fileops
  (:require [clojure.string :refer [join]]))

(defn- split-path
  [file-path]
  (.split file-path "/"))

(defn filename
  [file-path]
  (last 
    (split-path file-path)))

(defn path 
  [file-path]
  (join "/" 
    (drop-last 
      (split-path file-path))))

(defn file-exists?
  [file-path]
  (def directory 
    (clojure.java.io/file (path file-path)))

  (contains? 
    (set (for [file (.listFiles directory)] 
      (.getName file)))
    (filename file-path)))
