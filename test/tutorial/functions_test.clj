(ns tutorial.core.functions-tests
  "Test methods for the exercises on Functions at 
   https://clojure.org/guides/learn/functions."
  (:require [clojure.test :as tests]
            [tutorial.functions :as functions]))

(tests/deftest greeting-test
  (tests/testing "greeting-test failed."
    (tests/is (= "Hello, World!" (functions/greeting)))
    (tests/is (= "Hello, Clojure!" (functions/greeting "Clojure")))
    (tests/is (= "Good morning, Clojure!" (functions/greeting "Good morning" "Clojure")))))

(tests/deftest do-nothing-test
  (tests/testing "do-nothing-test failed."
    (tests/is (= 10 (functions/do-nothing 10)))))

(tests/deftest always-thing-test
  (tests/testing "always-thing-test failed."
    (tests/is (= 100 (functions/always-thing 111)))))

(tests/deftest make-thingy-test
  (tests/testing "make-thingy-test failed."
    (let [n (rand-int Integer/MAX_VALUE) f (functions/make-thingy n)]
      (tests/is (= n (f)))
      (tests/is (= n (f 123)))
      (tests/is (= n (apply f 123 (range)))))))

(tests/deftest triplicate-test
  (tests/testing "triplicate-test failed."
    (tests/is (= nil (functions/triplicate (fn [] (println "Surprise mothafucka")))))
    (tests/is (= nil (functions/triplicate #(println "Surprise mothafucka"))))))

(tests/deftest opposite-test
  (tests/testing "opposite-test failed."
    ((functions/opposite (fn [& x] (get x 0))) 10)))

(tests/deftest triplicate2-test
  (tests/testing "triplicate2-test failed."
    (functions/triplicate2 (fn [& x] (println x)) 20 10 5 0)))

(tests/deftest calculate-cos-of-PI-test
  (tests/testing "calculate-cos-of-PI-test failed."
    (tests/is (= -1 (functions/calculate-cos-of-PI)))))

(tests/deftest add-sin-and-cos-to-the-second-power-test
  (tests/testing "add-sin-and-cos-to-the-second-power-test failed."
    (tests/is (= 1 (functions/add-sin-and-cos-to-the-second-power 5)))))

(tests/deftest http-get-test
  (tests/testing "http-get-test failed."
    (tests/is (.contains (functions/http-get "https://www.w3.org") "html"))))

(tests/deftest one-less-arg-test
  (tests/testing "one-less-arg-test failed."
    (tests/is (= '(10 1 2 3 4) ((functions/one-less-arg (fn [& x] x) 10) 1 2 3 4)))))

(tests/deftest two-fns-test
  (tests/testing "two-fns-test failed."
    (tests/is (= 20 ((functions/two-fns (fn [x] x) (fn [x] (+ x 10))) 10)))))