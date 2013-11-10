(ns clj-dash.app.dash
  (:require-macros [clang.angular :refer [def.controller defn.scope def.filter fnj]])
  (:require [clojure.string :as cs]
            clobber.core               ;extend all JS objects with ClojureScript core protocols
            clobber.browser
            clang.directive.clangRepeat)
  (:use [clang.util :only [? module]]))

(def m (module "clj-dash" ["clang" "angles"]))

(def.controller m chart [$scope]
  (assoc! $scope :data {:labels   (into [] (range 0 20))
                        :datasets [{:data             (into [] (range 0 20))
                                    :fillColor        "rgba(151,187,205,0)"
                                    :strokeColor      "#e67e22"
                                    :pointColor       "rgba(151,187,205,0)"
                                    :pointStrokeColor "#e67e22"}]})
  (assoc! $scope :options {:segmentStrokeColor "#fff"})
  
  (defn.scope count []
	(count (:data $scope))))
