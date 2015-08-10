package pl.vanta.m101j;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class HelloWorldFreemarker {
    public static void main(String[] args) throws IOException, TemplateException {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreemarker.class, "/");

        Template template = configuration.getTemplate("hello.ftl");

        StringWriter stringWriter = new StringWriter();

        Map<String, Object> map = new HashMap<>();
        map.put("name", "Freemarker");

        template.process(map, stringWriter);

        System.out.println(stringWriter);
    }
}
