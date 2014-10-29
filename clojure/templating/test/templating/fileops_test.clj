(ns templating.fileops-test
  (:require [clojure.test :refer :all]
            [templating.fileops :refer :all]))

(def filepath "./fileops_test.clj")

(deftest path-test
  (testing "path method returns path to folder of given file"
    (is (path filepath) ".")))

(deftest filename-test
  (testing "filename method returns filename from given file path"
    (is (filename filepath) "fileops_test.clj")))

(deftest file-exists?-test
  (testing "checks file exists for given filepath"
    (is '(file-exists? "./fileops_test.clj") true)))
