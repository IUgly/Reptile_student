package org;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pachongMain {

    public static void main(String[] args) throws Exception {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet get = new HttpGet("http://jwzx.cqupt.edu.cn/jwzxtmp/showBjStu.php?bj=04121706" );

            CloseableHttpResponse response = client.execute(get);
//          System.out.println(response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                String content = EntityUtils.toString(entity, "utf-8");

                String PageData = content.toString();
                Pattern pattern = Pattern.compile("<tr><td>(.*?)</td><td>(.*?)" +
                        "</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)" +
                        "</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td>");
                Pattern pattern1 = Pattern.compile("src='[^<>]*'");

                Matcher matcher = pattern.matcher(PageData);
                Matcher matcher1 = pattern1.matcher(PageData);

                MySql ms = new MySql();
                Map<String, ArrayList<String>> students = new LinkedHashMap<>();
                int m = 1;
                while (matcher.find()) {
                    if (matcher.group(1).equals("No.")) {
                        continue;
                    }
                    System.out.println(matcher1.toString());
                    ArrayList<String> temp = new ArrayList<>();
                    for (int i = 1; i <= 10; i++) {
                        temp.add(matcher.group(i));
                    }
                    students.put(matcher.group(), temp);

                    String sqlLeagues = "INSERT INTO student(name, xh, clazz,major, college, gender) values(\""
                    +matcher.group(3)+"\","+ "\""+matcher.group(2)
                    +"\","+"\""+matcher.group(5)
                    +"\","+"\""+matcher.group(7)
                    +"\","+"\""+matcher.group(8)
                    +"\","+"\""+matcher.group(4)
                    +"\")";
                    //+"\","+"\""+matcher1.group(m)
                    ms.datatoMySql(sqlLeagues);
                }
                System.out.println(students);

                return;

//                for (int i =1;i<60;i++) {
//                    Document doc = Jsoup.parse(content);
//                    org.jsoup.select.Elements element3 = doc.select("h1[class=entry-title]");
//                    String title = element3.text();
//
//
//                    Elements element2 = doc.select("div[class=entry-content]");
//                    String article = element2.html();
//                }
            }else {
                System.out.println("请求失败");
            }
    }
}
