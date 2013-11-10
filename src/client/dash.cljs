(ns clj-dash.app.dash
  (:require-macros [clang.angular :refer [def.controller defn.scope def.filter fnj]])
  (:require [clojure.string :as cs]
            clobber.core               ;extend all JS objects with ClojureScript core protocols
            clobber.browser
            clang.directive.clangRepeat)
  (:use [clang.util :only [? module]]))

(def m (module "clj-dash" ["clang"]))

(def.controller m chart [$scope]
  (assoc! $scope :data (into [] (map (fn [%] {:x % :y (/ % 10)}) (range 0 10))))

  (defn.scope count []
	(count (:data $scope))))