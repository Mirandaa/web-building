package servlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by p on 2017/5/4.
 */
@WebServlet(name = "crawlNews")
public class getNews extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        response.getWriter().print(crawlNews());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public String crawlNews(){
        Connection.Response response = null;
        JSONArray resJson = new JSONArray();
        try {
            response = Jsoup.connect("https://xueqiu.com/#/").execute();
            response = Jsoup.connect("https://xueqiu.com/v4/statuses/public_timeline_by_category.json?since_id=-1&max_id=-1&count=5&category=-1")
                    .ignoreContentType(true)
                    .header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                    .cookies(response.cookies()).execute();
            String json_res = response.body();
            JSONObject json = JSONObject.fromObject(json_res);
            JSONArray array = (JSONArray) json.get("list");
            for (Object object :array) {
                JSONObject oldJson = (JSONObject) object;
                JSONObject newJson = new JSONObject();
                newJson.put("title",oldJson.getJSONObject("data").getString("topic_title"));
                newJson.put("des",delHref(oldJson.getJSONObject("data").getString("description")));
                newJson.put("link","https://xueqiu.com" + oldJson.getJSONObject("data").getString("target"));
                resJson.add(newJson);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resJson.toString();
    }

    private String delHref(String s){
        Pattern pattern = Pattern.compile("<.*?>");
        Matcher matcher = pattern.matcher(s);
        return  matcher.replaceAll("");
    }
}
