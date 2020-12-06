(ns aoc2020.day03-test
  (:require [aoc2020.day03 :as sut]
            [clojure.test :as t]))

(def grid (sut/parse-file "dev-resources/03.txt"))

(t/deftest parse-file
  (t/is (= (first (first grid)) :open))
  (t/is (= (last (first grid)) :open))
  (t/is (= (first (last grid)) :open))
  (t/is (= (last (last grid)) :tree)))

(t/deftest toboggan
  (t/is (= '(:open :tree :open :tree :tree :open :tree :tree :tree :tree)
           (sut/toboggan grid 3 1))))
