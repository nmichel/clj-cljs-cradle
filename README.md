

# REPL

Launch 2 different REPL in two different shells (e.g. gitbash)

## server-side (Clojure)

```shell
$> lein with-profile +clj repl
```

## client-side (Clojurescript)

### With cljsbuild in "auto" mode

```shell
$> lein with-profile +cljs cljsbuild auto client-prod`
```

### With [figwheel](https://github.com/bhauman/lein-figwheel) for interactive development

```shell
$> lein with-profile +cljs figwheel client-dev`
```
