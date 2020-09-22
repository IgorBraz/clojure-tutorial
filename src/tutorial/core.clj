(ns tutorial.core
  (:require [clojure.repl])
  (:gen-class))


(defn -main
  "Test your knowledge https://clojure.org/guides/learn/syntax."
  [& args]
  (println args)
  
  ;1.Using the REPL, compute the sum of 7654 and 1234.
  (println (+ 7654 1234))
  
  ;2.Rewrite the following algebraic expression as a Clojure expression: 
  ;( 7 + 3 * 4 + 5 ) / 10.
  (println (/ (+ 7 (* 3 4) 5) 10))
  
  ;3.Using REPL documentation functions, find the documentation for the rem 
  ;and mod functions. Compare the results of the provided expressions based 
  ;on the documentation.
  (println (rem (+ 7 (* 3 4) 5) 10))
  (println (mod (+ 7 (* 3 4) 5) 10))
  
  ;4.Using find-doc, find the function that prints the stack trace of the most 
  ;recent REPL exception.
  (clojure.repl/doc clojure.repl/pst)
)

