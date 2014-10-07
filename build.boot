(set-env!
  :dependencies '[[tailrecursion/boot.task "2.1.0"]]
  :src-paths #{"src"})

(task-options!
 pom [:project 'alandipert/hyperturbo
      :version "0.0.1-SNAPSHOT"])

(deftask build
  "Build jar and install to local repo."
  []
  (comp (pom) (add-src) (jar) (install)))

(deftask play
  "Play lunar lander"
  [] 
  (fn [continue]
    (fn [event]
      (require 'alandipert.hyperturbo.lunar-lander)
      ((resolve 'alandipert.hyperturbo.lunar-lander/run)))))
