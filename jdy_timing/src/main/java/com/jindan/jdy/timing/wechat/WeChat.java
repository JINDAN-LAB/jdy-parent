package com.jindan.jdy.timing.wechat;


import com.jindan.jdy.service.foodsafety.JdyAppletFootSafetyPersonService;
import com.jindan.jdy.timing.dto.AccessSmsXiaoxi;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.springframework.context.annotation.FilterType.CUSTOM;

@Slf4j
@Api(description="测试投票")
@CrossOrigin //跨域
@RestController
@EnableAutoConfiguration
public class WeChat {

        @Autowired
        WxMpService wxMpService;


    @RequestMapping("/wxpublic/verify_wx_token")
    public String verifyWXToken(HttpServletRequest request) throws AesException {
        String msgSignature = request.getParameter("signature");
        String msgTimestamp = request.getParameter("timestamp");
        String msgNonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        if (WXPublicUtils.verifyUrl(msgSignature, msgTimestamp, msgNonce)) {
            return echostr;
        }
        return "true";
    }

    @RequestMapping("/tuisong")
    public String tuisong(HttpServletRequest request) throws AesException {

        RestTemplate restTemplate=new RestTemplate();
        Map<String,String> params=new HashMap<>();
        params.put("appid","wxb5b6dfa9e8b12f50");
        params.put("secret","6da768a60cdd737cc30c32134d7071c6");
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={appid}&secret={secret}",Object.class,params);
        Map<String,String>  maps = (Map<String, String>) responseEntity.getBody();
        RestTemplate restTemplates=new RestTemplate();
        AccessSmsXiaoxi accessSmsXiaoxi =new AccessSmsXiaoxi();
        accessSmsXiaoxi.setTouser("oh3hV0vxuYVBgUk_UA7YUYN_hS6U");
        accessSmsXiaoxi.setTemplate_id("76gYqXCxZqRaSYGguPlz481Wurs2hMvYU6fjAhXaaG8");

        ResponseEntity<String> responseEntityss=restTemplates.postForEntity("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+maps.get("access_token"),accessSmsXiaoxi,String.class); //提交的body内容为user对象，请求的返回的body类型为String
        String body=responseEntityss.getBody();

       return "";
    }






}
