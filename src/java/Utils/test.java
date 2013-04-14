/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;


//import Model.UF;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author José Alexandre
 */
public class test {
//    String url = "http://localhost:8080/padeb_web_service/getServlet";
//    public test() {
//        
//    }
//
//   
//    public void main(String[] args) throws FileNotFoundException {
//    }
//    
//    public List<UF> getUFs() {
//        InputStream in = null;
//        try {
//            HttpClient client = new HttpClient();
//            PostMethod postMethod = new PostMethod(url);
//            postMethod.addParameter("idSerie", "5");
//            postMethod.addParameter("tipoRede", "0");
//            postMethod.addParameter("localizacao", "0");
//            postMethod.addParameter("capital", "0");
//            postMethod.addParameter("filtro", "filtroUF");
//            int statusCode = client.executeMethod(postMethod);
//            if (statusCode != -1) {
//                in = postMethod.getResponseBodyAsStream();
//            }
//            ObjectMapper mapper = new ObjectMapper();
//            List<UF> listaUFs = (List<UF>) mapper.readValue(in, List.class);
////            listaUFs.get(0).getNome();
////            Gson gson = new Gson();
////            List<UF> listaUFs = gson.fromJson(in, new TypeToken<List<UF>>(){}.getType());
//
//            return listaUFs;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;        
//    }
//    
}
