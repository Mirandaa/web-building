package module_getData;

import entity.ProductsEntity;
import entity.SessionInstance;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 * 得到建设银行的理财数据
 * Created by p on 2017/5/23.
 */
public class Jianshe_bank implements Get_data{
    @Override
    public void getInfo() {
        Connection.Response response = null;
        int i = 0;
        try {
            response = Jsoup.connect("http://finance.ccb.com/cc_webtran/queryFinanceProdList.gsp")
                    .ignoreContentType(true)
                    .header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                    .execute();
            String json_res = response.body();
            JSONObject json = JSONObject.fromObject(json_res);
            JSONArray array = (JSONArray) json.get("ProdList");

            for (Object object :array) {
                JSONObject oldJson = (JSONObject) object;
                ProductsEntity entity = new ProductsEntity();
                entity.setLink("http://finance.ccb.com/cn/finance/ProductDetails.html?PRODUCT_ID=" + oldJson.getString("code"));
                String x = oldJson.getString("purFloorAmt");
                if (x.equals("null")){
                    entity.setMinMoney(null);
                }
                else {
                    entity.setMinMoney(Double.parseDouble(x));
                }
                //为实体类设值
                String s = oldJson.getString("name");
                entity.setTitle(s);
                entity.setEarn(oldJson.getDouble("yieldRate"));
                entity.setDateStart(Long.valueOf(oldJson.getString("collBgnDate")));
                entity.setDateEnd(Long.valueOf(oldJson.getString("collEndDate")));
                entity.setDateEarn(Long.valueOf(oldJson.getString("investBgnDate")));
                entity.setDays(oldJson.getInt("investPeriod"));
                entity.setRisk(oldJson.getInt("riskLevel"));
                entity.setGuaranteed(oldJson.getInt("yieldSpec") > 0);
                entity.setSurplusValue(null);
                //通过Session对实体类进行保存
                Session session = SessionInstance.getSession();
                Transaction transaction = session.beginTransaction();
                session.saveOrUpdate(entity);
                transaction.commit();
                i++;
                SessionInstance.closeSession();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("建行更新 " + i + "条记录");
    }
}
