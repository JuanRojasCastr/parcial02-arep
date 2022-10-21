package org.app;

import static spark.Spark.*;

public class CollatzService {

    private static String resp = "";

    public static void main(String... args){
        staticFiles.location("/public");

        port(getPort());
        get("/query", (req,res) -> {
            res.type("application/json");
            return getResp(req.queryString());
        });
    }

    private static ResponseModel getResp(String value) {
        resp = "";
        int num = Integer.parseInt(value.substring(6));
        collatz(num);
        ResponseModel model = new ResponseModel("collatzsequence", num , resp);
        return model;
    }

    private static String collatz(int number) {
        if (number == 1) {
            resp += 1;
            return "";
        }
        else if (number % 2 == 0) {
            resp += number + "->";
            number = number/2;
        }
        else {
            resp += number + "->";
            number = (number * 3) + 1;
        }
        collatz(number);
        return resp;
    }



    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
