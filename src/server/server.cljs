(ns clj-dash.server
  (:require [cljs.nodejs :as nodejs]))
 
(def http (nodejs/require "http"))
 
(defn greetHandler [req res]
  (doto res
    (.writeHead 200 {"Content-Type" "text/plain"})
    (.end "Hello World")))
 
(defn server [handler port url]
  (-> (.createServer http handler)
      (.listen port url)))
 
(defn -main [& mess]
  (server greetHandler 3000 "127.0.0.1")
  (println "Server running at http://127.0.0.1:3000/"))
 
(set! *main-cli-fn* -main)