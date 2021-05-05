package com.edu.jdy.weixin;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;


import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

@Slf4j
@Api(description="微信公众号获取用户ID")
@CrossOrigin //跨域
@RequestMapping("/weixin")
@Controller
public class WeixinAuthUtils {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    private WxMpService wxMpService;

        
    @RequestMapping(value = "/wxLogin", method = RequestMethod.GET)
    public String wxLogin() throws ParseException {
        WxMpInMemoryConfigStorage wxMpConfigStorage = new WxMpInMemoryConfigStorage();
        wxMpConfigStorage.setAppId("wxb5b6dfa9e8b12f50");
        wxMpConfigStorage.setSecret("6da768a60cdd737cc30c32134d7071c6");
        wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage);
        String oauth2buildAuthorizationUrl = wxMpService.oauth2buildAuthorizationUrl("http://www.jindankeji.top/jdy-edus/weixin/login", WxConsts.OAuth2Scope.SNSAPI_USERINFO,  null);
        System.out.println(oauth2buildAuthorizationUrl);
        return "redirect:" + oauth2buildAuthorizationUrl;
    }

    @GetMapping("/login")
    public String login(@RequestParam("code") String code,
                        @RequestParam("state") String returnUrl, HttpServletRequest request, HttpServletResponse response, ModelMap map) {

        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = null;
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();
        WxMpUser wxMpUser=null;
        try {
            wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        map.addAttribute("openId",openId);
        return "index/index";
    }



    @RequestMapping("/ceshi")
    public String ceshi(  ) {

       return "index/index";
    }



}
