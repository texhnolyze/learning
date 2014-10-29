(ns templating.conversion-test
  (:require [clojure.test :refer :all]
            [templating.conversion :refer :all]))

(def valid-file "/home/soma")
(def invalid-file "/home/soma/x")

(deftest convert-test
  (testing "convert template file if it exists"
    (testing "if file-exists? returns true converts file"
      (is '(convert valid-file)(str "converting " valid-file)))

    (testing "if file-exists? returns false return error"
      (is '(convert invalid-file)(str "file does not exist " invalid-file)))))
