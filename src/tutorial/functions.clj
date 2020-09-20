(ns tutorial.functions
  "Test your knowledge from https://clojure.org/guides/learn/functions."
  (:gen-class))

(defn greet
  "1) Define a function greet that takes no arguments and prints 'Hello'."
  [] (println "Hello"))

;; 2) Redefine greet using def with the fn special form.
;; (def greet
;;   (fn [] println "Hello"))

;; 2) Redefine greet using def with the #() reader macro.
;; (def greet
;;   #(println "Hello"))

(defn greeting
  "3) Define a function greeting which:
   -Given no arguments, returns 'Hello, World!'
   -Given one argument x, returns 'Hello, x!'
   -Given two arguments x and y, returns 'x, y!'"
  ([] (greeting "Hello" "World"))
  ([x] (greeting "Hello" x))
  ([x y] (str x ", " y "!")))

(defn do-nothing
  "4) Define a function do-nothing which takes a single argument x and 
   returns it, unchanged."
  [x] x)

(defn always-thing
  "5) Define a function always-thing which takes any number of arguments, 
   ignores all of them, and returns the number 100."
  [& args] (println args) 100)

(defn make-thingy
  "6) Define a function make-thingy which takes a single argument x.
   It should return another function, which takes any number of arguments 
   and always returns x."
  [x]
  ; (fn [& xs] x)
  #(do %& x))

(defn triplicate
  "7) Define a function triplicate which takes another function and calls 
   it three times, without any arguments."
  [f]
  (f) (f) (f))

(defn opposite
  "8) Define a function opposite which takes a single argument f. It should 
   return another function which takes any number of arguments, applies f on 
   them, and then calls not on the result. The not function in Clojure does 
   logical negation."
  [f]
  (fn [& args] (not (apply f args))))

(defn triplicate2
  "9) Define a function triplicate2 which takes another function and any number 
   of arguments, then calls that function three times on those arguments. Re-use 
   the function you defined in the earlier triplicate exercise."
  [f & args]
  (triplicate (fn [] (apply f args))))

(defn calculate-cos-of-PI
  "10) Using the java.lang.Math class (Math/pow, Math/cos, Math/sin, Math/PI), 
   demonstrate the following mathematical facts:
   -The cosine of pi is -1"
  []
  (Math/round (Math/cos Math/PI)))

(defn add-sin-and-cos-to-the-second-power
  "10) Using the java.lang.Math class (Math/pow, Math/cos, Math/sin, Math/PI), 
   demonstrate the following mathematical facts:
   -For some x, sin(x)^2 + cos(x)^2 = 1"
  [x]
  (Math/round (+ (Math/pow (Math/sin x) 2) (Math/pow (Math/cos x) 2))))

(defn http-get
  "11) Define a function that takes an HTTP URL as a string, fetches that URL from 
   the web, and returns the content as a string."
  [url]
  (slurp url))

(defn one-less-arg
  "12) Define a function one-less-arg that takes two arguments:
   -f, a function
   -x, a value
   and returns another function which calls f on x plus any additional arguments."
  [f x]
  (fn [& args] (apply f x args)))

(defn two-fns
  "13) Define a function two-fns which takes two functions as arguments, f and g. 
   It returns another function which takes one argument, calls g on it, then calls f 
   on the result, and returns that.
   That is, your function returns the composition of f and g."
  [f g]
  (fn [x] (f (g x))))