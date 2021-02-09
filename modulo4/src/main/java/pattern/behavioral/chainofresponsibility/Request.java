package pattern.behavioral.chainofresponsibility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {

    private String url;
    private Map<String, String> headers;
    public String status = "";
    public List<Boolean> results = new ArrayList();
    public Map<String, Boolean> resultsMap = new HashMap();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
