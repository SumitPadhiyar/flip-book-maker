# FlipBookMaker
Source files for FlipBookMaker are located at `src/main/java/flipbookmaker`. Flip language is described in `LANGUAGE_DESIGN.md`.

### Setup
1. Install Maven

### Running Demo
1. Generate FlipBookMaker jar by running `mvn package`
2. Invoke jar with `java -jar target\flipbookmaker-1.0.0.jar -i demo\human_life_span.flip`
    1. Output file name can be provided by `-o` flag as `java -jar target\flipbookmaker-1.0.0.jar -i demo\human_life_span.flip -o human_life_span.pdf`

### Improvements
1. Implementing dynamic flips by changing the position of a single image on flip pages
2. Less decoupling between `Parser` module and `FlipBookCreator` module
