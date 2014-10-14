(ns templating.fileops
  (:require [clojure.string :as string]))

(defn split_path_filename
  [file_path]
  ;(string/split file_path #"$/"))
  (["/home/soma" "test"]))

(defn path 
  [file_path]
  (first (split_path_filename file_path)))

(defn filename
  [file_path]
  (last (split_path_filename file_path)))

(defn file_exists?
  [file]
  (def directory 
    (clojure.java.io/file (path file)))

  (fn files []
    (for [file (file-seq (directory))](.getName file)))

  (contains? 'files (filename file)))
