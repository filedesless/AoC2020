(def numbers
  (map clojure.edn/read-string (clojure.string/split-lines (slurp "input01.txt"))))

(doseq [i numbers j numbers]
  (if (= 2020 (+ i j))
    (println i "*" j "=" (* i j))))

(doseq [i numbers j numbers k numbers]
  (if (= 2020 (+ i j k))
    (println i "*" j "*" k "=" (* i j k))))
