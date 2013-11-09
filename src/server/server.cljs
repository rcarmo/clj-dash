(ns clj-dash.server
  (:require [cljs.nodejs :as nodejs]))
 
(def http (nodejs/require "http"))
(def url  (nodejs/require "url"))
(def path (nodejs/require "path"))
(def fs   (nodejs/require "fs"))
 
(defn basic-handler [req res]
  (doto res
    (.writeHead 200 {"Content-Type" "text/plain"})
    (.end "Hello World")))
 
(defn server [handler port url]
  (-> (.createServer http handler)
      (.listen port url)))
 
(defn -main [& args]
  (server basic-handler 3000 "127.0.0.1")
  (println "Server running at http://127.0.0.1:3000/"))
 
(set! *main-cli-fn* -main)