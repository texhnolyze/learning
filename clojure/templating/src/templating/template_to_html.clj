(ns templating.template-to-html
  (:require [clojure.string :refer [split-lines trim]]))

(defn- count-whitespace
  [line]
  (count (take-while #{\ } line)))

(defn- indentation-difference
  [first-line, second-line]
  (- (count-whitespace first-line) (count-whitespace second-line)))

(defn- trim-whitespace
  [lines-vector]
  (doseq [x [lines-vector]] (trim x)))

(defn- sort-template-lines
  [lines]
  (vector (first lines) 
          (if (not (empty? (rest lines)))
          (sort-template-lines (rest lines)))))

(defn to-html
  [template-string]
  (sort-template-lines
    (split-lines template-string)))
