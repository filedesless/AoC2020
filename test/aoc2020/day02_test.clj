(ns aoc2020.day02-test
  (:require [aoc2020.day02 :as sut]
            [clojure.test :as t]))

(clojure.test/testing "old-policy"
  (clojure.test/is (sut/old-policy 1 3 \a "abcde"))
  (clojure.test/is (not (sut/old-policy 1 3 \b "cdefg")))
  (clojure.test/is (sut/old-policy 2 9 \c "ccccccccc")))


(clojure.test/testing "new-policy"
  (clojure.test/is (sut/new-policy 1 3 \a "abcde"))
  (clojure.test/is (not (sut/new-policy 1 3 \b "cdefg")))
  (clojure.test/is (not (sut/new-policy 2 9 \c "ccccccccc"))))
