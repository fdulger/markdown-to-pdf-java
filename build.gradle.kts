import com.vladsch.flexmark.ext.tables.TablesExtension
import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import com.vladsch.flexmark.pdf.converter.PdfConverterExtension
import com.vladsch.flexmark.util.data.MutableDataSet

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("com.vladsch.flexmark:flexmark:0.64.8")
        classpath("com.vladsch.flexmark:flexmark-all:0.64.8")
    }
}

tasks.register<Task>("markdownToPdf") {
    val options = MutableDataSet()
    options.set(Parser.EXTENSIONS, listOf(TablesExtension.create()))
    val parser = Parser.builder(options).build()
    val renderer = HtmlRenderer.builder(options).build()

    val inputFile = File("markdown/index.md")
    val styleFile = File("markdown/style.css")
    val outputFile = "build/output.pdf"
    File(File(outputFile).parent).mkdirs()

    val document = parser.parse(inputFile.readText())
    val css = styleFile.readText()

    val htmlBody = renderer.render(document)
    val htmlString = "<html><head><style>$css</style></head><body>$htmlBody</body></html>"

    PdfConverterExtension.exportToPdf(outputFile, htmlString, "", options)
}
