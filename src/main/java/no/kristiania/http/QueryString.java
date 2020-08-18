package no.kristiania.http;

import java.util.Map;

public class QueryString {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(
                "Usage: 'java no.kristiania.http.QueryString <queryString>'." +
                "For example 'java no.kristiania.http.QueryString" +
                " status=302&location=http://example.com'"
            );
            System.exit(1);
        }
        QueryString queryString = new QueryString(args[0]);
        System.out.println(queryString.getParameter("status"));
    }

    private Map<String, String> parameters = new java.util.HashMap<>();

    public QueryString(String queryString) {
        parse(queryString);
    }

    private void parse(String queryString) {
        String[] parameters = queryString.split("&");
        for (String parameter : parameters) {
            int equalsPos = parameter.indexOf('=');

            String parameterName = parameter.substring(0, equalsPos);
            String parameterValue = parameter.substring(equalsPos+1);
            
            this.parameters.put(parameterName, parameterValue);
        }
    }

    public String getParameter(String name) {
        return parameters.get(name);
    }
}
