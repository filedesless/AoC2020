(defn within? [lower upper value]
  (and (<= lower value) (>= upper value)))

(defn old-policy [min max letter password]
  "Tells wether password contains at least min times and a most max times letter"
  (->> password
       (filter (partial = letter))
       count
       (within? min max)))

(clojure.test/testing "old-policy"
  (clojure.test/is (old-policy 1 3 \a "abcde"))
  (clojure.test/is (not (old-policy 1 3 \b "cdefg")))
  (clojure.test/is (old-policy 2 9 \c "ccccccccc")))

(defn xor [p q]
  "Logical exclusive or"
  (or (and p (not q)) (and (not p) q)))

(defn new-policy [i j letter password]
  "Tells wether password has letter at index i and j (1-indexed)"
  (xor (= letter (get password (dec i))) (= letter (get password (dec j)))))

(clojure.test/testing "new-policy"
  (clojure.test/is (new-policy 1 3 \a "abcde"))
  (clojure.test/is (not (new-policy 1 3 \b "cdefg")))
  (clojure.test/is (not (new-policy 2 9 \c "ccccccccc"))))

(def lines (clojure.string/split-lines (slurp "input02.txt")))

(defn parse [line]
  "'1-3 a: abcde' -> (1 3 a 'abcde')"
  (apply #(list (clojure.edn/read-string %1)
                (clojure.edn/read-string %2)
                (first %3) %4)
         (filter (partial not-empty)
                 (clojure.string/split line #"[- :]"))))

(defn day02 [policy]
  (count (filter #(apply policy (parse %)) lines)))

(println "Day02a:" (day02 old-policy))

(println "Day02b:" (day02 new-policy))
