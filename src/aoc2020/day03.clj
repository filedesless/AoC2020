(ns aoc2020.day03)

(defn parse-cell "Maps characters to keywords" [cell]
  (case cell
    \. :open
    \# :tree))

(defn parse-file "Parse input file into a grid of keywords" [filename]
  (let [lines (clojure.string/split-lines (slurp filename))]
    (vec (for [line lines] (vec (for [c line] (parse-cell c)))))))

(defn get-cell [grid row col]
  (get (get grid row) col))

(defn toboggan "Slide through grid moving right and down every step"
  [grid right down]
  (let [nrow (count grid) steps (rest (map vector (range) (range 0 nrow down)))]
    (for [[step row] steps]
      (get-cell grid row (mod (* right step) (count (grid row)))))))

(defn day03a []
  (let [grid (parse-file "resources/03.txt")]
    (count (filter #(= :tree %) (toboggan grid 3 1)))))
