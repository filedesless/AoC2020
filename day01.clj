(def numbers
  (map clojure.edn/read-string (clojure.string/split-lines (slurp "input01.txt"))))

(def pairs
  (for [i numbers j numbers]
    [i j]))

(def pair
  (first (filter #(= 2020 (+ (get % 0) (get % 1))) pairs)))

(println "Day01a:" (* (get pair 0) (get pair 1)))

(def triplets
  (for [i numbers j numbers k numbers]
    [i j k]))

(def triplet
  (first (filter #(= 2020 (+ (get % 0) (get % 1) (get % 2))) triplets)))

(println "Day01b:" (* (get triplet 0) (get triplet 1) (get triplet 2)))
