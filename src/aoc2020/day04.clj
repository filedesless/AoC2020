(ns aoc2020.day04)

(def required_fields '("byr" "iyr" "eyr" "hgt" "hcl" "ecl" "pid"))

(defn parse "parse input file into a list of associative maps" [filename]
  (let [passeports (clojure.string/split (slurp filename) #"\n\n")]
    (for [passeport passeports]
      (apply hash-map (clojure.string/split passeport #"[\s:]")))))

(defn valid? "checks that a passeport contains all the require fields" [passeport]
  (every? (fn [field] (contains? passeport field)) required_fields))

(defn day04a []
  (count (filter valid? (parse "resources/04.txt"))))
