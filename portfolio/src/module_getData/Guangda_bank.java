package module_getData;

import entity.ProductsEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import servlet.SessionInstance;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by p on 2017/5/24.
 */
public class Guangda_bank implements Get_data {
    @Override
    public void getInfo() {
        int i = 0;
        Connection.Response response = null;
        try {
            response = Jsoup.connect("http://www.cmbchina.com/cfweb/svrajax/product.ashx?op=search&type=m&pageindex=1&salestatus=A&baoben=&currency=10&term=&keyword=&series=01&risk=&city=&date=&pagesize=20&orderby=ord1")
                    .method(Connection.Method.GET)
                    .ignoreContentType(true)
                    .execute();
            String res = response.body();
            JSONObject jsonObject = JSONObject.fromObject(response.body().substring(1, res.length() - 1));
            JSONArray array = jsonObject.getJSONArray("list");
            for (Object object : array) {
                JSONObject oldJson = (JSONObject) object;
                ProductsEntity entity = new ProductsEntity();
                entity.setId(oldJson.getString("PrdCode"));
                entity.setLink("http://www.cmbchina.com/cfweb/personal/productdetail.aspx?code=" + entity.getId());
                //得到最小投资金额
                String x = oldJson.getString("InitMoney");
                if (x.equals("null")){
                    entity.setMinMoney(null);
                }
                else {
                    entity.setMinMoney(Double.parseDouble(x));
                }
                String s = oldJson.getString("PrdName");
                entity.setTitle(s);
                //得到年利率
                String earn = oldJson.getString("NetValue");
                if (earn.equals("")){
                    entity.setEarn(null);
                }
                else {
                    entity.setEarn(Double.parseDouble(earn.substring(0, earn.length() - 1)));
                }
                //得到时间
                String day = oldJson.getString("FinDate");
                entity.setDays(Integer.parseInt(day.substring(0,day.length()-1)));
                DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
                Date beginDate = fmt.parse(oldJson.getString("BeginDate"));
                Date endDate = fmt.parse(oldJson.getString("EndDate"));
                Date earnDate = fmt.parse(oldJson.getString("ExpireDate"));
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(earnDate);
                calendar.add(calendar.DATE,0 - entity.getDays());
                earnDate = calendar.getTime();
                entity.setDateStart(String.valueOf(beginDate.getTime()));
                entity.setDateEnd(String.valueOf(endDate.getTime()));
                entity.setDateEarn(String.valueOf(earnDate.getTime()));
                entity.setSurplusValue(null);

                Session session = SessionInstance.getSession();
                Transaction transaction = session.beginTransaction();
                session.saveOrUpdate(entity);
                transaction.commit();
                i++;
                SessionInstance.closeSession();
            }
            System.out.println(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("商行更新 " + i + "条记录");
    }
}
