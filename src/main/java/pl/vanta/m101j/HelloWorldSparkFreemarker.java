package pl.vanta.m101j;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

import static spark.Spark.get;

public class HelloWorldSparkFreemarker {
    public static void main(String[] args) {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldSparkFreemarker.class, "/");

        get("/", (request, response) -> {
            Template template = configuration.getTemplate("hello.ftl");

            StringWriter stringWriter = new StringWriter();

            Map<String, Object> map = new HashMap<>();
            map.put("name", "Freemarker");

            template.process(map, stringWriter);

            return stringWriter.toString();
        });

        get("/hello/:who", (request, response) -> "Hello " + request.params(":who"));
        get("/echo/:echo", (request, response) -> request.params(":echo"));


    }
}
