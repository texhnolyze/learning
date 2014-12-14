(ns templating.template-to-html-test
  (:require [clojure.test :refer :all]
            [templating.template-to-html :refer [to-html]]))

(def template 
  (str "html\n  div\n    a\n  div"))

(deftest to-html-test
  (testing "template is turned into vector"
    (is (= [ "html" ["div" ["a"]] "div"] 
        (to-html template)))))
