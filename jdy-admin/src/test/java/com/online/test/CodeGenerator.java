//package com.online.test;
//
//import com.google.common.reflect.ClassPath;
////import com.jindan.jdy.controller.utils.SentSmsUtils;
//import com.jindan.jdy.common.dto.RiskPointDtoDetails;
//import com.jindan.jdy.common.pojo.JdyAppletFootSafetyPerson;
//import com.jindan.jdy.common.pojo.RiskPointContent;
//import com.jindan.jdy.common.pojo.RiskPointContentChaoqi;
//import com.jindan.jdy.common.pojo.RiskPointPersons;
//import com.jindan.jdy.controller.utils.CommonUtils;
//import com.jindan.jdy.controller.utils.SentSmsUtils;
//import com.jindan.jdy.service.foodsafety.JdyAppletFoodSafetyProblemsReultService;
//import com.jindan.jdy.service.foodsafety.JdyAppletFootSafetyPersonService;
//import com.jindan.jdy.service.risk.RiskPointContentChaoqiService;
//import com.jindan.jdy.service.risk.RiskPointPersonsService;
//import com.tencentcloudapi.common.Credential;
//import com.tencentcloudapi.common.exception.TencentCloudSDKException;
//import com.tencentcloudapi.common.profile.ClientProfile;
//import com.tencentcloudapi.common.profile.HttpProfile;
//import com.tencentcloudapi.sms.v20190711.SmsClient;
//import com.tencentcloudapi.sms.v20190711.models.*;
//import org.activiti.engine.*;
//import org.activiti.engine.repository.Deployment;
//import org.activiti.engine.runtime.ProcessInstance;
//import org.activiti.engine.task.Task;
//import org.apache.dubbo.config.annotation.Reference;
//import org.apache.zookeeper.*;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.io.InputStream;
//import java.math.BigDecimal;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.zip.ZipInputStream;
//
//
//public class CodeGenerator {
//
//
//    @Autowired
//    RiskPointPersonsService riskPointMakeoverService;
//
//    @Reference(version = "${service.version}", check = false)
//    RiskPointContentChaoqiService riskPointContentChaoqiService;
//
//    private Logger logger = LoggerFactory.getLogger(getClass());
//    private int i;
//
//    @Test
//    public void execute() throws Exception {
//        List<RiskPointContentChaoqi>  chaoqiList  = new ArrayList<>();
//        System.out.println(chaoqiList);
//        System.out.println("=========");
//        List<RiskPointDtoDetails> detailsList = riskPointMakeoverService.seleListBaohanrenwuWapper(new RiskPointPersons());
//        System.out.println(detailsList);
//        System.out.println("=========");
//        for (int i = 0; i <detailsList.size() ; i++) {
//            for (int j = 0; j < detailsList.get(i).getList().size(); j++) {  // 查询出来的结果
//                if(detailsList.get(i).getList().get(j).getResultList().size() > 0){
//                    if(Integer.valueOf((int) CommonUtils.getDateStringDistanceDays(CommonUtils.getPresenttime(),detailsList.get(i).getList().get(j).getResultList().get(0).getInsertTime())) > Integer.valueOf(detailsList.get(i).getPersonsList().get(0).getFrequency())){
//                    }else{
//                        RiskPointContentChaoqi riskPointContentChaoqi =new RiskPointContentChaoqi();
//                        riskPointContentChaoqi.setChaoqiTime(CommonUtils.getPresenttime());
//                        riskPointContentChaoqi.setContentId(detailsList.get(i).getList().get(j).getRiskIds());
//                        riskPointContentChaoqi.setChaoqiPerson(detailsList.get(i).getList().get(j).getRiskContents());
//                        chaoqiList.add(riskPointContentChaoqi);
//                    }
//                }
//            }
//        }
////输出超期的日期
//        System.out.println(chaoqiList);
//        System.out.println("=================");
////         boolean b = riskPointContentChaoqiService.saveBatch(chaoqiList);
////        logger.info("thread id:{},FixedPrintTask execute times:{}", b, b);
//        logger.info("thread id:{},FixedPrintTask execute times:{}", Thread.currentThread().getId(), ++i);
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    @Autowired
//    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法
//
//    @Test
//    public void ru12n() throws ParseException {
//        String messageId = String.valueOf(UUID.randomUUID());
//        String messageData = "test message, hello!";
//        String createTime = "yyyy-MM-dd HH:mm:ss";
//        Map<String, Object> map = new HashMap<>();
//        map.put("messageId", messageId);
//        map.put("messageData", messageData);
//        map.put("createTime", createTime);
//        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
//        rabbitTemplate.convertAndSend("direct-exchange", "hello", map);
//    }
//
//
//    public static int getFistNum(String s){
//        if(s==null || s.length()==0){
//            return -1;
//        }
//        char c = s.charAt(0);
//        if(c>='0' && c<='9'){
//            return c-'0';
//        }else{
//            return getFistNum(s.substring(1));
//        }
//
//
//    }
//
//    @Test
//    public void run() throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date =  sdf.parse("2020-08-08");
//        BigDecimal time = BigDecimal.valueOf(date.getTime()); // 得到指定日期的毫秒数
//        System.out.println(time);
//        BigDecimal day = BigDecimal.valueOf(30).multiply(BigDecimal.valueOf(86400000)) ;
//        System.out.println(day);
//        time = time .add( day);
//        System.out.println(time);
//        System.out.println("-----------------------------------");
//        Date dates = new Date();
//        dates.setTime(time.longValue());
//        System.out.println(new SimpleDateFormat("YYYY-MM-dd").format(dates));
//        System.out.println("-----------------------------------");
////        Date date1 = new Date(time);
////        System.out.println(date1);
////        System.out.println( (sdf.format(date1)));
////
////        int day = 80;
////        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////        try {
////            Date date = sdf.parse("2020-05-04");
////            Calendar cl = Calendar.getInstance();
////            cl.setTime(date);
////            cl.add(Calendar.DATE, day);
////           String temp = sdf.format(cl.getTime());
////          System.out.println(temp);
////        }catch(ParseException e){
////            e.printStackTrace();
////        }
////        Date d = new Date();
//// sdf.format(new Date(Long.parseLong(stamp))); // 时间戳转换日期
//
////        System.out.println(sdf.format( new Date(Long.parseLong("1595026632704"))));
//
////        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
////        String s= "2020-08-09";
////        Date date =  formatter.parse(s);
////        String .format("%tm",date );
////        String name =   String .format("%tm",date);
////        System.out.println(name);
////        String in1 = "";
////        String in2 = "";
////
////        String s="1515sdfeergegre1ergegreg1578egr%";
////        String regex="()[^\\d\r\n]*?(\\d+)[^\r\n]*?";
////        Pattern p=Pattern.compile(regex);
////        Matcher m=p.matcher(s);
////        while(m.find()){
////            in1 = m.group(2);
////            in2  = in1;
////            System.out.println(m.group(1)+"----------00000000000---------"+m.group(2));
////        }
////        System.out.println("00000000"+in2);
//
////        String[] phoneNumbers = new String[1];
////        String[] templateParams = new String[2];
////        phoneNumbers[0] = "+8613027766129";
////        templateParams[0] ="孔士豪";
////        templateParams[1] ="kongs";
////         SentSmsUtils.SentFasongSms("问题提交", "1400408129", "745475", phoneNumbers, templateParams);
//
//    }
//
//    @Test
//    public void tegnxSms() {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
//        Date date =  new Date();
//        System.out.println(df.format(date));// new Date()为获取当前系统时间
//        long time = date.getTime();
//        time = time -7*24*60*60*1000;
//        System.out.println("====================");
//        System.out.println(time);
//        Date date2 =  new Date(time);
//        System.out.println("====================");
//        System.out.println(date2);
//        System.out.println(df.format(date2));
//
////        String str = "https://kong15.oss-cn-beijing.aliyuncs.com/file/2020/08/01/adjunct/9de6f226-4add-415a-bcb0-ece7ca490fa3wxfb3f5eda159c0dbd.o6zAJs7YQeJxNZ8bjgwZpmKhDoio.8UVCnIvIufI0a6bc1844b8ebbeea6b6ffb5795a37fe9.jpg";
////        String[] strArr = str.split("https://kong15.oss-cn-beijing.aliyuncs.com/");
////        System.out.println(strArr.length); //这里输出3
////        for (int i = 0; i < strArr.length; ++i){
////            System.out.println(strArr[i]);//这里输出a b c
////        }
//
////        String[] inde=  {"+8613027766129"};
////        String[] templateParams=  {"kkkk"};
////        SentSmsUtils.SentFasongSms("303193", "1400408129", "679489", inde, templateParams);
//    }
//
////    @Test
////    public void tegnxunSms() {
////
////        try {
////            /* 必要步骤：
////             * 实例化一个认证对象，入参需要传入腾讯云账户密钥对 secretId 和 secretKey
////             * 本示例采用从环境变量读取的方式，需要预先在环境变量中设置这两个值
////             * 您也可以直接在代码中写入密钥对，但需谨防泄露，不要将代码复制、上传或者分享给他人
////             * CAM 密钥查询：https://console.cloud.tencent.com/cam/capi*/
////            Credential cred = new Credential("secretId", "secretKey");
////
////            // 实例化一个 http 选项，可选，无特殊需求时可以跳过
////            HttpProfile httpProfile = new HttpProfile();
////            // 设置代理
////            httpProfile.setProxyHost("host");
////            httpProfile.setProxyPort(2010);
////            /* SDK 默认使用 POST 方法
////             * 如需使用 GET 方法，可以在此处设置，但 GET 方法无法处理较大的请求 */
////            httpProfile.setReqMethod("POST");
////            /* SDK 有默认的超时时间，非必要请不要进行调整
////             * 如有需要请在代码中查阅以获取最新的默认值 */
////            httpProfile.setConnTimeout(60);
////            /* SDK 会自动指定域名，通常无需指定域名，但访问金融区的服务时必须手动指定域名
////             * 例如 SMS 的上海金融区域名为 sms.ap-shanghai-fsi.tencentcloudapi.com */
////            httpProfile.setEndpoint("sms.tencentcloudapi.com");
////
////            /* 非必要步骤:
////             * 实例化一个客户端配置对象，可以指定超时时间等配置 */
////            ClientProfile clientProfile = new ClientProfile();
////            /* SDK 默认使用 TC3-HMAC-SHA256 进行签名
////             * 非必要请不要修改该字段 */
////            clientProfile.setSignMethod("HmacSHA256");
////            clientProfile.setHttpProfile(httpProfile);
////            /* 实例化 SMS 的 client 对象
////             * 第二个参数是地域信息，可以直接填写字符串 ap-guangzhou，或者引用预设的常量 */
////            SmsClient client = new SmsClient(cred, "",clientProfile);
////            /* 实例化一个请求对象，根据调用的接口和实际情况，可以进一步设置请求参数
////             * 您可以直接查询 SDK 源码确定接口有哪些属性可以设置
////             * 属性可能是基本类型，也可能引用了另一个数据结构
////             * 推荐使用 IDE 进行开发，可以方便地跳转查阅各个接口和数据结构的文档说明 */
////            AddSmsTemplateRequest req = new AddSmsTemplateRequest();
////
////            /* 填充请求参数，这里 request 对象的成员变量即对应接口的入参
////             * 您可以通过官网接口文档或跳转到 request 对象的定义处查看请求参数的定义
////             * 基本类型的设置:
////             * 帮助链接：
////             * 短信控制台：https://console.cloud.tencent.com/smsv2
////             * sms helper：https://cloud.tencent.com/document/product/382/3773 */
////
////            /* 模板名称*/
//////            String templatename = "腾讯云";
//////            req.templateName(templatename);
//////
//////            /* 模板内容 */
//////            String templatecontent     = "{1}为您的登录验证码，请于{2}分钟内填写，如非本人操作，请忽略本短信。";
//////            req.templateContent    (templatecontent);
//////
//////            /* 短信类型：0表示普通短信, 1表示营销短信 */
//////            Long smstype = 0;
//////            req.smsType(smstype);
//////
//////            /* 是否国际/港澳台短信：0：表示国内短信，1：表示国际/港澳台短信。 */
//////            Long international = 0;
//////            req.international(session);
//////
//////            /* 模板备注：例如申请原因，使用场景等 */
//////            String remark = "xxx";
//////            req.remark(remark);
////
////            /* 通过 client 对象调用 AddSmsTemplate 方法发起请求。注意请求方法名与请求对象是对应的
////             * 返回的 res 是一个 AddSmsTemplateResponse 类的实例，与请求对象对应 */
////            AddSmsTemplateResponse res = client.AddSmsTemplate(req);
////
////            // 输出 JSON 格式的字符串回包
////            System.out.println(AddSmsTemplateResponse.toJsonString(res));
////
////            // 可以取出单个值，您可以通过官网接口文档或跳转到 response 对象的定义处查看返回字段的定义
////            System.out.println(res.getRequestId());
////
////        } catch (TencentCloudSDKException e) {
////            e.printStackTrace();
////        }
////    }
//
//
//
//    @Test
//    public void FasongSms() {
//
//        try {
//            /* 必要步骤：
//             * 实例化一个认证对象，入参需要传入腾讯云账户密钥对 secretId 和 secretKey
//             * 本示例采用从环境变量读取的方式，需要预先在环境变量中设置这两个值
//             * 您也可以直接在代码中写入密钥对，但需谨防泄露，不要将代码复制、上传或者分享给他人
//             * CAM 密钥查询：https://console.cloud.tencent.com/cam/capi*/
//            Credential cred = new Credential("secretId", "secretKey");
//
//            // 实例化一个 http 选项，可选，无特殊需求时可以跳过
//            HttpProfile httpProfile = new HttpProfile();
//            // 设置代理
//            httpProfile.setProxyHost("host");
//            httpProfile.setProxyPort(202);
//            /* SDK 默认使用 POST 方法。
//             * 如需使用 GET 方法，可以在此处设置，但 GET 方法无法处理较大的请求 */
//            httpProfile.setReqMethod("POST");
//            /* SDK 有默认的超时时间，非必要请不要进行调整
//             * 如有需要请在代码中查阅以获取最新的默认值 */
//            httpProfile.setConnTimeout(60);
//            /* SDK 会自动指定域名，通常无需指定域名，但访问金融区的服务时必须手动指定域名
//             * 例如 SMS 的上海金融区域名为 sms.ap-shanghai-fsi.tencentcloudapi.com */
//            httpProfile.setEndpoint("sms.tencentcloudapi.com");
//
//            /* 非必要步骤:
//             * 实例化一个客户端配置对象，可以指定超时时间等配置 */
//            ClientProfile clientProfile = new ClientProfile();
//            /* SDK 默认用 TC3-HMAC-SHA256 进行签名
//             * 非必要请不要修改该字段 */
//            clientProfile.setSignMethod("HmacSHA256");
//            clientProfile.setHttpProfile(httpProfile);
//            /* 实例化 SMS 的 client 对象
//             * 第二个参数是地域信息，可以直接填写字符串 ap-guangzhou，或者引用预设的常量 */
//            SmsClient client = new SmsClient(cred, "", clientProfile);
//            /* 实例化一个请求对象，根据调用的接口和实际情况，可以进一步设置请求参数
//             * 您可以直接查询 SDK 源码确定接口有哪些属性可以设置
//             * 属性可能是基本类型，也可能引用了另一个数据结构
//             * 推荐使用 IDE 进行开发，可以方便地跳转查阅各个接口和数据结构的文档说明 */
//            SendSmsRequest req = new SendSmsRequest();
//
//            /* 填充请求参数，这里 request 对象的成员变量即对应接口的入参
//             * 您可以通过官网接口文档或跳转到 request 对象的定义处查看请求参数的定义
//             * 基本类型的设置:
//             * 帮助链接：
//             * 短信控制台：https://console.cloud.tencent.com/smsv2
//             * sms helper：https://cloud.tencent.com/document/product/382/3773 */
//
//            /* 短信应用 ID: 在 [短信控制台] 添加应用后生成的实际 SDKAppID，例如1400006666 */
//            String appid = "1400009099";
//            req.setSmsSdkAppid(appid);
//
//            /* 短信签名内容: 使用 UTF-8 编码，必须填写已审核通过的签名，可登录 [短信控制台] 查看签名信息 */
//            String sign = "签名内容";
//            req.setSign(sign);
//
//            /* 国际/港澳台短信 senderid: 国内短信填空，默认未开通，如需开通请联系 [sms helper] */
//            String senderid = "xxx";
//            req.setSenderId(senderid);
//
//            /* 用户的 session 内容: 可以携带用户侧 ID 等上下文信息，server 会原样返回 */
//            String session = "xxx";
//            req.setSessionContext(session);
//
//            /* 短信码号扩展号: 默认未开通，如需开通请联系 [sms helper] */
//            String extendcode = "xxx";
//            req.setExtendCode(extendcode);
//
//            /* 模板 ID: 必须填写已审核通过的模板 ID，可登录 [短信控制台] 查看模板 ID */
//            String templateID = "400000";
//            req.setTemplateID(templateID);
//
//            /* 下发手机号码，采用 e.164 标准，+[国家或地区码][手机号]
//             * 例如+8613711112222， 其中前面有一个+号 ，86为国家码，13711112222为手机号，最多不要超过200个手机号*/
//            String[] phoneNumbers = {"+8621212313123", "+8612345678902", "+8612345678903"};
//            req.setPhoneNumberSet(phoneNumbers);
//
//            /* 模板参数: 若无模板参数，则设置为空*/
//            String[] templateParams = {"5678"};
//            req.setTemplateParamSet(templateParams);
//
//            /* 通过 client 对象调用 SendSms 方法发起请求。注意请求方法名与请求对象是对应的
//             * 返回的 res 是一个 SendSmsResponse 类的实例，与请求对象对应 */
//            SendSmsResponse res = client.SendSms(req);
//            // 输出 JSON 格式的字符串回包
//            System.out.println(SendSmsResponse.toJsonString(res));
//            // 可以取出单个值，您可以通过官网接口文档或跳转到 response 对象的定义处查看返回字段的定义
//            System.out.println(res.getRequestId());
//
//        } catch (TencentCloudSDKException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//// 统计短信发送数据
//    @Test
//    public void TongjiSms() {
//
//        try {
//            /* 必要步骤：
//             * 实例化一个认证对象，入参需要传入腾讯云账户密钥对 secretId 和 secretKey
//             * 本示例采用从环境变量读取的方式，需要预先在环境变量中设置这两个值
//             * 您也可以直接在代码中写入密钥对，但需谨防泄露，不要将代码复制、上传或者分享给他人
//             * CAM 密钥查询：https://console.cloud.tencent.com/cam/capi */
//            Credential cred = new Credential("secretId", "secretKey");
//
//            // 实例化一个 http 选项，可选，无特殊需求时可以跳过
//            HttpProfile httpProfile = new HttpProfile();
//            // 设置代理
//            httpProfile.setProxyHost("host");
//            httpProfile.setProxyPort(5050);
//            /* SDK 默认使用 POST 方法。
//             * 如需使用 GET 方法，可以在此处设置，但 GET 方法无法处理较大的请求 */
//            httpProfile.setReqMethod("POST");
//            /* SDK 有默认的超时时间，非必要请不要进行调整
//             * 如有需要请在代码中查阅以获取最新的默认值 */
//            httpProfile.setConnTimeout(60);
//            /* SDK 会自动指定域名，通常无需指定域名，但访问金融区的服务时必须手动指定域名
//             * 例如 SMS 的上海金融区域名为 sms.ap-shanghai-fsi.tencentcloudapi.com */
//            httpProfile.setEndpoint("sms.tencentcloudapi.com");
//
//            /* 非必要步骤:
//             * 实例化一个客户端配置对象，可以指定超时时间等配置 */
//            ClientProfile clientProfile = new ClientProfile();
//            /* SDK 默认用 TC3-HMAC-SHA256 进行签名
//             * 非必要请不要修改该字段 */
//            clientProfile.setSignMethod("HmacSHA256");
//            clientProfile.setHttpProfile(httpProfile);
//
//            /* 实例化 SMS 的 client 对象
//             * 第二个参数是地域信息，可以直接填写字符串 ap-guangzhou，或者引用预设的常量 */
//            SmsClient client = new SmsClient(cred, "",clientProfile);
//
//            /* 实例化一个请求对象，根据调用的接口和实际情况，可以进一步设置请求参数
//             * 您可以直接查询 SDK 源码确定接口有哪些属性可以设置
//             * 属性可能是基本类型，也可能引用了另一个数据结构
//             * 推荐使用 IDE 进行开发，可以方便地跳转查阅各个接口和数据结构的文档说明 */
//            SendStatusStatisticsRequest req = new SendStatusStatisticsRequest();
//
//            /* 填充请求参数，这里 request 对象的成员变量即对应接口的入参
//             * 您可以通过官网接口文档或跳转到 request 对象的定义处查看请求参数的定义
//             * 基本类型的设置:
//             * 帮助链接：
//             * 短信控制台：https://console.cloud.tencent.com/smsv2
//             * sms helper：https://cloud.tencent.com/document/product/382/3773 */
//
//            /* 短信应用 ID: 在 [短信控制台] 添加应用后生成的实际 SDKAppID，例如1400006666 */
//            String appid = "1400009099";
//            req.setSmsSdkAppid(appid);
//
//            // 设置拉取最大条数，最多100条
//            Long limit = 5L;
//            req.setLimit(limit);
//            /* 偏移量，目前固定设置为0 */
//            Long offset = 0L;
//            req.setOffset(offset);
//            /* 开始时间，yyyymmddhh 需要拉取的起始时间，精确到小时 */
//            String startdatetime = "2019071100";
////            req.setStartDateTime(startdatetime);
//            /* 结束时间，yyyymmddhh 需要拉取的截止时间，精确到小时
//             * 注：EndDataTime 必须大于 StartDateTime */
//            String enddatatime = "2019071123";
////            req.setEndDataTime(enddatatime);
//
//            /* 通过 client 对象调用 SendStatusStatistics 方法发起请求。注意请求方法名与请求对象是对应的
//             * 返回的 res 是一个 SendStatusStatisticsResponse 类的实例，与请求对象对应 */
////            SendStatusStatisticsResponse res = client.SendStatusStatisticsStatus(req);
////
////            // 输出 JSON 格式的字符串回包
////            System.out.println(SendStatusStatisticsStatusResponse.toJsonString(res));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
////拉取回执状态
//@Test
//public void HuizhiSms() {
//    try {
//        /* 必要步骤：
//         * 实例化一个认证对象，入参需要传入腾讯云账户密钥对 secretId 和 secretKey
//         * 本示例采用从环境变量读取的方式，需要预先在环境变量中设置这两个值
//         * 您也可以直接在代码中写入密钥对，但需谨防泄露，不要将代码复制、上传或者分享给他人
//         * CAM 密钥查询：https://console.cloud.tencent.com/cam/capi */
//        Credential cred = new Credential("secretId", "secretKey");
//        // 实例化一个 http 选项，可选，无特殊需求时可以跳过。
//        HttpProfile httpProfile = new HttpProfile();
//        // 设置代理
//        httpProfile.setProxyHost("host");
//        httpProfile.setProxyPort(21121);
//        /* SDK 默认使用 POST 方法。
//         * 如需使用 GET 方法，可以在此处设置，但 GET 方法无法处理较大的请求 */
//        httpProfile.setReqMethod("POST");
//        /* SDK 有默认的超时时间，非必要请不要进行调整
//         * 如有需要请在代码中查阅以获取最新的默认值 */
//        httpProfile.setConnTimeout(60);
//        /* SDK 会自动指定域名，通常无需指定域名，但访问金融区的服务时必须手动指定域名
//         * 例如 SMS 的上海金融区域名为 sms.ap-shanghai-fsi.tencentcloudapi.com */
//        httpProfile.setEndpoint("sms.tencentcloudapi.com");
//        /* 非必要步骤:
//         * 实例化一个客户端配置对象，可以指定超时时间等配置 */
//        ClientProfile clientProfile = new ClientProfile();
//        /* SDK 默认用 TC3-HMAC-SHA256 进行签名
//         * 非必要请不要修改该字段 */
//        clientProfile.setSignMethod("HmacSHA256");
//        clientProfile.setHttpProfile(httpProfile);
//        /* 实例化 SMS 的 client 对象
//         * 第二个参数是地域信息，可以直接填写字符串 ap-guangzhou，或者引用预设的常量 */
//        SmsClient client = new SmsClient(cred, "",clientProfile);
//        /* 实例化一个请求对象，根据调用的接口和实际情况，可以进一步设置请求参数
//         * 您可以直接查询 SDK 源码确定接口有哪些属性可以设置
//         * 属性可能是基本类型，也可能引用了另一个数据结构
//         * 推荐使用 IDE 进行开发，可以方便地跳转查阅各个接口和数据结构的文档说明 */
//        PullSmsSendStatusRequest req = new PullSmsSendStatusRequest();
//        /* 填充请求参数，这里 request 对象的成员变量即对应接口的入参
//         * 您可以通过官网接口文档或跳转到 request 对象的定义处查看请求参数的定义
//         * 基本类型的设置:
//         * 帮助链接：
//         * 短信控制台：https://console.cloud.tencent.com/smsv2
//         * sms helper：https://cloud.tencent.com/document/product/382/3773 */
//        /* 短信应用 ID: 在 [短信控制台] 添加应用后生成的实际 SDKAppID，例如1400006666 */
//        String appid = "1400009099";
//        req.setSmsSdkAppid(appid);
//        // 设置拉取最大条数，最多100条
//        Long limit = 5L;
//        req.setLimit(limit);
//        /* 通过 client 对象调用 PullSmsSendStatus 方法发起请求。注意请求方法名与请求对象是对应的
//         * 返回的 res 是一个 PullSmsSendStatusResponse 类的实例，与请求对象对应 */
//        PullSmsSendStatusResponse res = client.PullSmsSendStatus(req);
//        // 输出 JSON 格式的字符串回包
//        System.out.println(PullSmsSendStatusResponse.toJsonString(res));
//    } catch (TencentCloudSDKException e) {
//        e.printStackTrace();
//    }
//
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    @Test
//    public void yasuo() {
//        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
//        System.out.println(defaultProcessEngine);
//        /**
//         * 获取当前class对象
//         */
//        InputStream inputStream = this.getClass()
//                /**
//                 *  获取类加载器
//                 */
//                .getClassLoader()
//                /**
//                 * 获取指定文件资源流
//                 */
//                .getResourceAsStream("repository/BPMN.zip");
//        /**
//         * 实例化zip输入流对象
//         */
//        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
//        /**
//         *  部署Service
//         */
//        Deployment deployment = defaultProcessEngine.getRepositoryService()
//                /**
//                 *  创建部署
//                 */
//                .createDeployment()
//                /**
//                 *   流程名称
//                 */
//                .name("HelloWorld流程2")
//                /**
//                 *  添加zip是输入流
//                 */
//                .addZipInputStream(zipInputStream)
//                /**
//                 *  部署
//                 */
//                .deploy();
//        System.out.println("流程部署ID:" + deployment.getId());
//        System.out.println("流程部署Name:" + deployment.getName());
//
////         第四步：
//        System.out.println("-----=======--------");
//        System.out.println(deployment.getName());
//        System.out.println(deployment.getId());
//        System.out.println("-----=======--------");
//    }
//
//    //处理任务信息
//    @Test
//    public void completTask() {
//        //任务id
//         ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//         String taskId = "8305";   // 创建TaskService
//         TaskService taskService = processEngine.getTaskService();   //完成任务
//         taskService.complete(taskId);
//         System.out.println("完成任务id="+taskId);
//    }
//
//
////    查询任务信息
//    @Test
//    public void findPersonalTaskList() {   // 任务负责人
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//         String assignee = "zhangsan";
//        // 创建TaskService
//         TaskService taskService = processEngine.getTaskService();
//         List<Task> list = taskService.createTaskQuery().processDefinitionKey("myProcess_1")//
//                          .taskAssignee(assignee)//只查询该任务负责人的任务
//                          .list();
//
//        for (Task task : list) {
//            System.out.println(" 流 程 实 例 id ： " + task.getProcessInstanceId());
//            System.out.println("任务id：" + task.getId());
//            System.out.println("任务负责人：" + task.getAssignee());
//            System.out.println("任务名称：" + task.getName());
//
//        }
//    }
//
//
//    //    第二部
//    @Test
//    public void rs() {
//        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
//
//        RuntimeService runtimeService = defaultProcessEngine.getRuntimeService();   // 根据流程定义key启动流程
//        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_1");
//        System.out.println(" 流程定义id ： " + processInstance.getProcessDefinitionId());
//        System.out.println("流程实例id：" + processInstance.getId());
//        System.out.println(" 当前活动Id ： " + processInstance.getActivityId());
//    }
//
////    第一步
//    @Test
//    public void runss() {
//        //  1.创建ProcessEngine 对象
////           ProcessEngines.getDefaultProcessEngine();
////        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
////        //获取ProcessEngine对象
////        ProcessEngine processEngine = configuration.buildProcessEngine();
////        System.out.println("==================");
////        System.out.println(processEngine);
//
////        第二种创建方式：
//        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
//        System.out.println(defaultProcessEngine);
////        第二步得到RepositoryService实例
//        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();
//        System.out.println(repositoryService);
//        System.out.println("================------------==============");
////        第三步进行部署
//        Deployment deploy = repositoryService.createDeployment()
//                .addClasspathResource( "repository/startindex.bpmn")
//                .addClasspathResource( "repository/startindex.png")
//                .name("请假流程").deploy();
////         第四步：
//        System.out.println("-----=======--------");
//        System.out.println(deploy.getName());
//        System.out.println(deploy.getId());
//        System.out.println("-----=======--------");
//
//
//
//
//
//
//
//
//
//
////        System.out.println(0 % 2 == 0);
////        String tempString = "后款30天85";
////        String regEx = "[^0-9]";
////        Pattern p = Pattern.compile(regEx);
////        Matcher m = p.matcher(tempString);
////        System.out.println("===="+p);
////        System.out.println("========="+m);
////        String resultString = m.replaceAll("").trim();
////        int result = Integer.valueOf(resultString);
////        System.out.println("----"+result);
////        int  nums =0;
////        String str = "后款30天85";
////        //正则表达式，用于匹配非数字串，+号用于匹配出多个非数字串
////        String regEx = "[^0-9]+";
////        Pattern pattern = Pattern.compile(regEx);
////        //用定义好的正则表达式拆分字符串，把字符串中的数字留出来
////        if (str != null && !str.equals("")) {
////            String[] cs = pattern.split(str);
////            System.out.println(cs);
////            System.out.println("------------");
////            if (cs.length >= 2) {
////                nums = Integer.parseInt(cs[1]);
////            } else {
////                nums = 0;
////            }
////        }else{
////            nums = 0;
////        }
////
////        System.out.println(nums);
////        System.out.println("==================");
////        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
////        System.out.println(formatter.format(new Date()));
////        try {
////            long distanceDays = CommonUtils.getDistanceDays("2020-05-01", "2020-05-15");
////            System.out.println("ppppppppppppppppppppp");
////            System.out.println(distanceDays);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//    }
////    @Test
////    public void initTables() {
////        //创建数据源
////        DriverManagerDataSource dataSource=new DriverManagerDataSource();
////        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
////        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/0705activiti");
////        dataSource.setUsername("root");
////        dataSource.setPassword("123456");
////
////        // 创建流程引擎的配置
////        ProcessEngineConfiguration configuration = ProcessEngineConfiguration
////                .createStandaloneProcessEngineConfiguration();
////        configuration.setJdbcDriver("com.mysql.jdbc.Driver");
////        configuration.setJdbcUrl("jdbc:mysql://106.13.122.154:3306/jdy");
////        configuration.setJdbcUsername("root");
////        configuration.setJdbcPassword("Jindan.root");
//////		configuration.setDataSource(dataSource);
////        /**
////         * ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE  如果数据库里面没有activit的表，也不会创建
////         * ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP 创建表，使用完之后删除
////         * ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE  如果数据库里面没有表，就创建
////         *
////         * dorp-create 代表如果数据库里面有表，那么先删除再创建
////         *
////         */
////        //配置表的初始化的方式
////        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
////
////        //得到流程引擎
////        ProcessEngine processEngine=configuration.buildProcessEngine();
////        System.out.println(processEngine);
////
////    }
////
//
//
//    private static int deleteCount = 0;
//    private static int moveCount = 0;
//
//    @Test
//    public void aaaaa() throws  Exception{
//        //
//        //旧zk服务器
//        ZooKeeper oldzk = null;
//         oldzk = new ZooKeeper("192.168.1.112:2181", 60000, null);
//
//        //新zk服务器
//        ZooKeeper newzk = new ZooKeeper("172.17.32.105:2181", 60000, null);
//        //需要迁移的节点
//        String node = "/dubbo";
//        //删除指定节点
//        delete(newzk, node);
//        System.out.println("删除节点数:" + deleteCount);
//        //获取节点下的一级子节点
//        List<String> children = oldzk.getChildren(node, false);
//        move(oldzk, newzk, children, node);
//        System.out.println("移动节点数:" + moveCount);
//        oldzk.close();
//        newzk.close();
//    }
//
//    private static boolean delete(ZooKeeper newzk, String node) throws Exception {
//        List<String> children = newzk.getChildren(node, false);
//        if (children == null || children.size() == 0) {
//            //System.out.println("delete node:" + node);
//            newzk.delete(node, -1);
//            deleteCount++;
//            return true;
//        } else {
//            for (String child : children) {
//                while (!delete(newzk, node + "/" + child)) {
//                }
//            }
//            return false;
//        }
//    }
//    /**
//     * 移动指定zk1的指定节点到指定zk2的节点下.
//     * @param oldzk 旧zk
//     * @param newzk 新zk
//     * @param children 子节点
//     * @param parent 父节点
//     * @throws KeeperException 异常
//     * @throws InterruptedException 异常
//     */
//    private static void move(ZooKeeper oldzk, ZooKeeper newzk, List<String> children, String parent) throws KeeperException, InterruptedException {
//        if (newzk.exists(parent, false) == null) {
//            newzk.create(parent, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//            System.out.println("create " + parent);
//        }
//        if (children == null || children.isEmpty()) {
//            return;
//        } else {
//            for (String child : children) {
//                String c = parent + "/" + child;
//                //System.out.println(c);
//                byte[] data = oldzk.getData(c, false, null);
//                if (newzk.exists(c, false) == null) {
//                    newzk.create(c, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//                    moveCount++;
//                } else {
//                    newzk.setData(c, data, -1, null, null);
//                    moveCount++;
//                }
//                //递归移动
//                move(oldzk, newzk, oldzk.getChildren(c, false), c);
//            }
//        }
//    }
//
//}
