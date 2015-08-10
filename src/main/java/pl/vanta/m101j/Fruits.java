package pl.vanta.m101j;

import java.io.StringWriter;
import java.util.Map;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import freemarker.template.Configuration;
import freemarker.template.Template;

import static java.util.Arrays.asList;
import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.Spark.post;

public class Fruits {
    public static void main(String[] args) {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(Fruits.class, "/");

        get("/", (request1, response1) -> processTemplate(configuration.getTemplate("fruits.ftl"),
                ImmutableMap.<String, Object>of("fruits", asList("Banana", "Pineapple", "Apple", "Berry"))));

        post("/fruits", (request, response) -> {
            final String fruit = request.queryParams("fruit");

            if (Strings.isNullOrEmpty(fruit)) {
                return "You didn't pick anything";
            } else {
                return "Your favourite fruit is " + fruit;
            }
        });
    }

    private static String processTemplate(Template template, Map<String, Object> params) {
        StringWriter stringWriter = new StringWriter();

        try {
            template.process(params, stringWriter);
            return stringWriter.toString();
        } catch (Exception e) {
            halt(500);
            return "Upppss";
        }

    }
}
