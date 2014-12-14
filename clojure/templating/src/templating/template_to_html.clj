(ns templating.template-to-html
  (:require [clojure.string :refer [split-lines trim]]))

(defn- count-whitespace
  [line]
  (count (take-while #{\ } line)))

(defn- indentation-difference
  [first-line, second-line]
  (- (count-whitespace first-line) 
     (count-whitespace second-line)))

(defn- trim-whitespace
  [lines-vector]
  (doseq [x [lines-vector]] (trim x)))

(defn- create-line-hash-map
  [lines]
  (loop [lines lines tree [] parent nil element-id 0]
    (if (not (empty? lines))
      (do
        (println (str "Run number: " element-id " Args: \n" 
                      "lines = " lines "\n"
                      "tree = " tree "\n"
                      "parent = " parent "\n"
                      "element-id = " element-id "\n"))
                      
        (if (< (indentation-difference
                 (first lines) 
                 (first (rest lines))) 0)
          (recur 
            (vec (rest lines)) 
            (conj tree {:id element-id, :element (first lines), :parent parent})
            {:id element-id, :element (first lines), :parent parent}
            (+ element-id 1))

        (if (> (indentation-difference
                 (first lines) 
                 (first (rest lines))) 0)
          (recur 
            (vec (rest lines)) 
            (conj tree {:id element-id, :element (first lines), :parent parent})
            (parent :parent)
            (+ element-id 1))

        (if (= (indentation-difference
                 (first lines) 
                 (first (rest lines))) 0)
          (recur
            (vec (rest lines))
            (conj tree {:id element-id :element (first lines), :parent parent})
            parent
            (+ element-id 1))))))

      (do
        (println tree "\n")
        tree))))

(defn- reverse-line-hash-map
  [line-hash-map]
  (def reverse-nodes
    (fn [node, child-nodes]
      (if (node :parent)
        (reverse-nodes (node :parent) (conj child-nodes node))
          (do 
            (println (str "Adding " {:content child-nodes} " to " node "\n"))
            (conj node {:content child-nodes})))))

  (map 
    (fn [node]
      (reverse-nodes node [])) 
    line-hash-map))


(defn to-html
  [template-string]
  (reverse-line-hash-map
    (create-line-hash-map
      (split-lines template-string))))
