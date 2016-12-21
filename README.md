
# Clojure/ClojureScript Cradle

This project aims at helping newcomers in Clojure/ClojureScript world.

It provides basic configurations for both sides and is easy to derive into a real project file.

It is gross but its goal is to help a true beginner to be playing around in no time.

Hope it helps, though.

# Build your sandbox project

Clone/Copy the project and adapt it to your needs :
* modify  ```project.clj```
  * add your dependencies
  * add your foreign libs
  * ...
* add your .clj/.cljs files 
* add your resources
* ...

# REPL

Launch 2 different REPL in two different shells (e.g. gitbash)

## Clojure

```shell
$> lein with-profile +clj repl
```

Or, using project defined alias

```shell
$> lein clj-repl
```

## ClojureScript

### With cljsbuild in "auto" mode

```shell
$> lein with-profile +cljs cljsbuild auto client-prod
```

### With [figwheel](https://github.com/bhauman/lein-figwheel) for interactive development

```shell
$> lein with-profile +cljs figwheel client-dev
```

Or, using project defined alias

```shell
$> lein cljs-fig
```

# Build

## Clojure

```shell
$> lein clj uberjar
```

## ClojureScript

### With cljsbuild

```shell
$> lein with-profile +cljs cljsbuild once client-prod
```

Or, using project defined alias

```shell
$> lein cljs-build
```
