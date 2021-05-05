package index.test;

import com.jindan.jdy.timing.dto.AccessSmsXiaoxi;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.Map;

public class ClassTest {


    @Test
    public void tegnxSlllms() {
//        RestTemplate restTemplate=new RestTemplate();
//        Map<String,String> params=new HashMap<>();
//        params.put("appid","wxb5b6dfa9e8b12f50");
//        params.put("secret","6da768a60cdd737cc30c32134d7071c6");
//        ResponseEntity<Object> responseEntity = restTemplate.getForEntity("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={appid}&secret={secret}",Object.class,params);
//        Map<String,String>  maps = (Map<String, String>) responseEntity.getBody();
//        System.out.println(maps.get("access_token"));
//        RestTemplate restTemplates=new RestTemplate();
//        AccessSmsXiaoxi accessSmsXiaoxi =new AccessSmsXiaoxi();
//        accessSmsXiaoxi.setTouser("oh3hV0vxuYVBgUk_UA7YUYN_hS6U");
//        accessSmsXiaoxi.setTemplate_id("76gYqXCxZqRaSYGguPlz481Wurs2hMvYU6fjAhXaaG8");
//        ResponseEntity<String> responseEntityss=restTemplates.postForEntity("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+maps.get("access_token"),accessSmsXiaoxi,String.class); //提交的body内容为user对象，请求的返回的body类型为String
//        String body=responseEntityss.getBody();
     }


    @Test
    public void tegnxSms() {
//        RestTemplate restTemplate=new RestTemplate();
//        Map<String,String> params=new HashMap<>();
//        params.put("appid","wxb5b6dfa9e8b12f50");
//        params.put("secret","6da768a60cdd737cc30c32134d7071c6");
//        ResponseEntity<Object> responseEntity = restTemplate.getForEntity("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={appid}&secret={secret}",Object.class,params);
//        System.out.println(responseEntity);
//        System.out.println("==================");
//        System.out.println(responseEntity.getStatusCode());
//        System.out.println(responseEntity.getStatusCodeValue());
//        System.out.println(responseEntity.getBody());
//        System.out.println("========7777777777777==========");
//        Map<String,String>  maps = (Map<String, String>) responseEntity.getBody();
//        System.out.println("========9999999999999999==========");
//        System.out.println(maps);
//        System.out.println(maps.get("access_token"));
//        System.out.println("========10101010101010==========");
//        AccessToken accessToken = (AccessToken) responseEntity.getBody();
//        System.out.println(accessToken);
//        System.out.println(accessToken.getAccessToken());
//        System.out.println(accessToken.getExpiresIn());
//        System.out.println("========78888888887==========");
//        System.out.println(responseEntity.getClass());
        //此处将要发送的数据转换为json格式字符串
//        String jsonText = "{id：1}";
//        JSONObject json = (JSONObject) JSONObject.parse(jsonText);

//        HttpClient client = HttpClients.createDefault();
//        // 要调用的接口方法
//        String url = "http://www.baidu.com";
//        HttpPost post = new HttpPost(url);
//        JSONObject jsonObject = null;
//        try {
////            StringEntity s = new StringEntity(json.toString());
////            s.setContentEncoding("UTF-8");
////            s.setContentType("application/json");
////            post.setEntity(s);
//            post.addHeader("content-type", "text/xml");
//            HttpResponse res = client.execute(post);
//            String response1 = EntityUtils.toString(res.getEntity());
//            System.out.println(response1);
//            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
//                jsonObject = JSONObject.parseObject(result);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return jsonObject;

//        RestTemplate restTemplate=new RestTemplate();
//        Map<String,String> params=new HashMap<>();
//        params.put("name","dada");  //
//        ResponseEntity<String> responseEntity=restTemplate.getForEntity("http://118.24.255.51:8101/ceshi-toupiao",String.class,params);
//
//        System.out.println(responseEntity);


    }


}
