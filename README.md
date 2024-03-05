# markdown-to-pdf-java

Simple demonstration on how to generate a PDF from your markdown document in gradle using Java library [flexmark](https://github.com/vsch/flexmark-java)

All the coding needed is in the [build.gradle.kts](https://github.com/fdulger/markdown-to-pdf-java/blob/main/build.gradle.kts) file. 

## Generating the PDF 

```
gradlew markdownToPdf
```

Your PDF will be placed in `build/output.pdf`

For more information and other possible configuration options see [flexmark wiki](https://github.com/vsch/flexmark-java/wiki).