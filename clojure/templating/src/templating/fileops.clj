(ns templating.fileops
  (use [clojure.string :only (join)]))

(defn split_path
  [file_path]
  (.split file_path "/"))

(defn filename
  [file_path]
  (last (split_path file_path)))

(defn path 
  [file_path]
  (join "/" 
    (remove filename 
      (split_path file_path))))

(defn file_exists?
  [file_path]
  (def directory 
    (clojure.java.io/file (path file_path)))

  (contains? 
    (set 
      (for [file (file-seq directory)] 
        (.getName file)))
    (filename file_path)))
