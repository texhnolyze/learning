(ns templating.conversion-test
  (:require [clojure.test :refer :all]
            [templating.conversion :refer :all]))

(def valid-file "/home/soma")
(def invalid-file "/home/soma/x")

(deftest convert-test
  (testing "convert template file if it exists"
    (testing "if file-exists? returns true converts file"
      (is (str "converting " valid-file) '(convert valid-file)))

    (testing "if file-exists? returns false return error"
      (is (str "file does not exist " invalid-file) '(convert invalid-file)))))
