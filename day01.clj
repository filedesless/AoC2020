(def numbers
  (map clojure.edn/read-string (clojure.string/split-lines (slurp "input/01.txt"))))

(defn day01 [entries]
  "Find the product of the entries whose sum is 2020"
  (->> entries
       (filter #(= 2020 (apply + %)))
       (map #(apply * %))
       first))

(let [pairs (for [i numbers j numbers] [i j])
      triplets (for [i numbers pair pairs] (conj pair i))]
  (println "Day01a:" (day01 pairs))
  (println "Day01b:" (day01 triplets)))
