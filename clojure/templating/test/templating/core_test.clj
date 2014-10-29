(ns templating.core-test
  (:require [clojure.test :refer :all]
            [templating.core :refer :all]))

(def filepath "/home/soma")

(deftest -main-test
  (testing "-main method"
    (testing "should receive one string file arg"
    (-main filepath))))

