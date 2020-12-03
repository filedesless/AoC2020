(defn within? [lower upper value]
  (and (<= lower value) (>= upper value)))

(defn valid? [min max letter password]
  "Tells wether password contains at least min times and a most max times letter"
  (->> password
       (filter (partial = letter))
       count
       (within? min max)))

(clojure.test/testing "valid?"
  (clojure.test/is (valid? 1 3 \a "abcde"))
  (clojure.test/is (not (valid? 1 3 \b "cdefg")))
  (clojure.test/is (valid? 2 9 \c "ccccccccc")))

(def lines (clojure.string/split-lines (slurp "input02.txt")))

(defn parse [line]
  "'1-3 a: abcde' -> (1 3 a 'abcde')"
  (apply #(list (clojure.edn/read-string %1)
                (clojure.edn/read-string %2)
                (first %3) %4)
         (filter (partial not-empty)
                 (clojure.string/split line #"[- :]"))))

(defn day02a []
  (count (filter #(apply valid? (parse %)) lines)))

(println "Day02a:" (day02a))
