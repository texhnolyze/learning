(ns templating.core-test
  (:require [clojure.test :refer :all]
            [templating.core :refer :all]))

(deftest -main-test
  (testing "-main method"
    (testing "should receive one string file arg")
      (-main "/test/folder")))

    (testing "core calls conversion function convert with received arg"
      (-main "test/folder")))
