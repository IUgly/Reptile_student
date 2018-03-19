package org;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import net.sf.json.JSONObject;
import org.ReferNumber;

public class Servlet extends HttpServlet  {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String name = request.getParameter("name");
        JSONObject resp = new JSONObject();

        if (name.isEmpty()||name == null){
            resp.put("errorcode",1);
            resp.put("desc","invalid parameter");
        }
        else {
                String xh = ReferNumber.Refer(name);
                System.out.println(xh);
        }
    }
}
