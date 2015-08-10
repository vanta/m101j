package pl.vanta.m101j;

import static spark.Spark.get;

public class HelloWorldSpark {
    public static void main(String[] args) {
        get("/", (request, response) -> "Hello world Spark");
    }
}
