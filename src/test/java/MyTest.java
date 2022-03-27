
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kuang.KryType.AuthType;
import com.kuang.KryType.KryAPI;
import com.kuang.config.KryApiParamConfig;
import com.kuang.pojo.*;
import com.kuang.service.KryCallService;
import okhttp3.OkHttpClient;
import org.apache.poi.ss.formula.atp.Switch;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyTest {

//    private Lock lock = new ReentrantLock();
//    public volatile int count = 0;
//    private AtomicInteger atomicInteger = new AtomicInteger(0);
//
//
//    public void incr(String threadName){
//        lock.lock();
//        System.out.println(threadName + " => Locked!!!!");
//        try {
//            System.out.println(count);
//            count++;
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            lock.unlock();
//            System.out.println(threadName + " => Unlocked!!!!");
//        }
//
//    }
//
//    public void incr2(String threadName){
//        try {
//            System.out.println(threadName + "_safe" + " => " + atomicInteger.getAndIncrement());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }





    @Test
    public void test() throws Exception {
//        List<Thread> threadList = new ArrayList<>();
//        for (int i = 0; i < 10000; i++) {
//            new Thread(){
//                @Override
//                public void run() {
//                    incr(Thread.currentThread().getName());
////                    System.out.println(Thread.currentThread().getName() + " => " +count);
//                }
//            }.start();
//        }


//==========================Date=====================================================
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String today = simpleDateFormat.format(date);
//        Calendar rightNow = Calendar.getInstance();
//        rightNow.setTime(date);
//        rightNow.add(Calendar.DAY_OF_YEAR, 2);
//        Date twoDaysAfterDate = rightNow.getTime();
//        String twoDaysAfter = simpleDateFormat.format(twoDaysAfterDate);
//        System.out.println("twoDaysAfter=>"+twoDaysAfter);
//        System.out.println("today=>"+today);
//==========================Redis-Jedis=====================================================
//        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        RedisTemplate redisTemplate=(RedisTemplate) applicationContext.getBean("distributionRedisTemplate");
//        VinItemSimple vinItemSimple = new VinItemSimple();
//        vinItemSimple.setItemCount(1);
//        vinItemSimple.setCategory("tool");
//        vinItemSimple.setId("1234");
//        Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent(vinItemSimple.getId(), vinItemSimple, 3, TimeUnit.HOURS);
////        redisTemplate.opsForValue().set(vinItemSimple.getId(), vinItemSimple, 3, TimeUnit.HOURS);
//
//        while (!aBoolean){
//            Thread.sleep(100);
//            System.out.println("false");
//            System.out.println("deletekey start");
//            redisTemplate.delete("1234");
//            System.out.println("deletekey end");
//            aBoolean = redisTemplate.opsForValue().setIfAbsent(vinItemSimple.getId(), vinItemSimple, 3, TimeUnit.HOURS);
//        }
//        if (aBoolean){
//            System.out.println("true");
//            VinItemSimple o = (VinItemSimple)redisTemplate.opsForValue().get("1234");
//            System.out.println(o);
//        }else {
//            System.out.println("false");
//        }

        //==========================Email=====================================================
//        // 服务器地址:
//        String smtp = "smtp.gmail.com";
//        // 登录用户名:
//        String username = "alan2610107@gmail.com";
//        // 登录口令:
//        String password = "Movie11221100";
//        // 连接到SMTP服务器587端口:
//        Properties props = new Properties();
//        props.put("mail.smtp.host", smtp); // SMTP主机名
//        props.put("mail.smtp.port", "587"); // 主机端口号
//        props.put("mail.smtp.auth", "true"); // 是否需要用户认证
//        props.put("mail.smtp.starttls.enable", "true"); // 启用TLS加密
//
//        // 获取Session实例:
//        Session session = Session.getInstance(props, new Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        });
//        // 设置debug模式便于调试:
//        session.setDebug(true);
//
//        MimeMessage message = new MimeMessage(session);
//        Date today = new Date();
//        Date backupTime=DateUtils.addDays(today, -1);
//        System.out.println("昨天"+backupTime);
//        message.setSentDate(backupTime);
//        // 设置发送方地址:
//        message.setFrom(new InternetAddress("alan2610107@gmail.com"));
//        // 设置接收方地址:
//        message.setRecipient(Message.RecipientType.TO, new InternetAddress("alan2610107@yahoo.com.tw"));
//        // 设置邮件主题:
//        message.setSubject("Hello", "UTF-8");
//        // 设置邮件正文:
//        message.setText("喵喵喵，This is from JavaMail. Date:" + backupTime, "UTF-8");
//
//        // 发送:
//        Transport.send(message);

//        ==================JSON==============================
//        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        RedisTemplate redisTemplate=(RedisTemplate) applicationContext.getBean("redisTemplate");
//        VinItem vinItem1 = new VinItem("e15ea3a686a54abfac7fb7c977863da5","itemName1","brand1",1,1,1,"1");
//        VinItem vinItem2 = new VinItem("nvjdfosngoafkn2143214nvkdsnr3144","itemName2","brand2",1,1,1,"1");
//        String s = JSON.toJSONString(vinItem1);
//        String s2 = JSON.toJSONString(vinItem2);
//        System.out.println("JSONString=>"+s);
//        System.out.println(redisTemplate.hasKey("vinItemfoodinmain1"));
//        redisTemplate.opsForHash().put("123","e15ea3a686a54abfac7fb7c977863da5",s);
//        redisTemplate.opsForHash().put("123","nvjdfosngoafkn2143214nvkdsnr3144",s2);
//        Set<String> keys = redisTemplate.opsForHash().keys("123");
//        Map<String,String> map = redisTemplate.opsForHash().entries("123");
//        List<VinItem> values = redisTemplate.opsForHash().values("123");
//        for (int i = 0; i < values.size(); i++) {
//            System.out.println(values.get(i));
//        }
//        for (String key: keys) {
//            System.out.println(key);
//            VinItem vinItemOutput = JSON.parseObject(map.get(key), VinItem.class);
//            System.out.println(vinItemOutput);
//        }
//      ==========================KryOrderDetail=======================================
//        OkHttpClient okHttpClient = new OkHttpClient();
//        KryApiParamConfig kryApiParamConfig = new KryApiParamConfig();
//        kryApiParamConfig.setAppKey("54e3ffc62fea15205a3e7bebcaa11d6e");
//        kryApiParamConfig.setAppSecret("12dfcc0ddcddf91face61b2ba7253961");
//        kryApiParamConfig.setProjectName("vinvin");
//        kryApiParamConfig.setUrl("https://openapi.keruyun.com");
//        kryApiParamConfig.setProjectVersion("1.0");
//        final KryCallService kryCallService = new KryCallService(okHttpClient, kryApiParamConfig);
//        Long shopId = 870305696L;
//        String token = kryCallService.getToken(AuthType.SHOP, shopId);
//        KryOrderDetail orderDetailDTO = new KryOrderDetail();
//        orderDetailDTO.setShopIdenty(shopId);
//        List<Long> orderIds = new ArrayList<>();
//        orderIds.add(562257799351438336L);
//        orderDetailDTO.setIds(orderIds);
//        String apicall = kryCallService.postCall(KryAPI.ORDER_DETAIL, AuthType.SHOP, shopId, token, orderDetailDTO);
//        System.out.println(apicall);
//        String kryResult = JSONObject.parseObject(apicall, KryResult.class).getResult();
//        System.out.println(kryResult);
//        List<KryOrderDetailInfo> kryOrderDetailInfos = JSON.parseArray(kryResult, KryOrderDetailInfo.class);
//        for (int i = 0; i < kryOrderDetailInfos.size(); i++) {
//            KryOrderDetailInfo kryOrderDetailInfo = kryOrderDetailInfos.get(i);
//            System.out.println(kryOrderDetailInfo);
//            List<KryDishInfo> kryDishInfos = JSON.parseArray(kryOrderDetailInfo.getDishInfos(), KryDishInfo.class);
//            System.out.println("kryDishInfos.size()=>"+kryDishInfos.size());
//            for (int j = 0; j < kryDishInfos.size(); j++) {
//                KryDishInfo kryDishInfo = kryDishInfos.get(j);
////                System.out.println(kryDishInfos);
//                List<KryDishProperties> kryDishProperties = new ArrayList<>();
//                if(!kryDishInfo.getChildNodes().equals("[]")){
//                    List<KryDishInfo> kryDishInfosChild = JSON.parseArray(kryDishInfo.getChildNodes(), KryDishInfo.class);
//                    System.out.println("kryDishInfosChild.size=>"+kryDishInfosChild.size());
//                    for (int k = 0; k < kryDishInfosChild.size(); k++) {
//                        System.out.println(k);
//                        KryDishInfo kryDishInfoChild = kryDishInfosChild.get(k);
//                        kryDishProperties = JSON.parseArray(kryDishInfoChild.getDishProperties(), KryDishProperties.class);
//                        for (int s = 0; s < kryDishProperties.size(); s++) {
//                            kryDishInfoChild.setDishPropertyName(kryDishProperties.get(s).getDishPropertyName());
//                        }
//                        kryDishInfoChild.setOrderId(String.valueOf(560864684765873152L));
//                        System.out.println(kryDishInfoChild);
//                    }
//                }else {
//                    kryDishProperties = JSON.parseArray(kryDishInfo.getDishProperties(), KryDishProperties.class);
//                    for (int k = 0; k < kryDishProperties.size(); k++) {
//                        kryDishInfo.setDishPropertyName(kryDishProperties.get(k).getDishPropertyName());
//                    }
//                    kryDishInfo.setOrderId(String.valueOf(560864684765873152L));
//                    System.out.println(kryDishInfo);
//                }
//
//
//
//            }
//        }


//      ==========================KryOrders=======================================
//        Long page = 1L;
//        int totalRows=0;
//        do {
//            OkHttpClient okHttpClient = new OkHttpClient();
//            KryApiParamConfig kryApiParamConfig = new KryApiParamConfig();
//            kryApiParamConfig.setAppKey("54e3ffc62fea15205a3e7bebcaa11d6e");
//            kryApiParamConfig.setAppSecret("12dfcc0ddcddf91face61b2ba7253961");
//            kryApiParamConfig.setProjectName("vinvin");
//            kryApiParamConfig.setUrl("https://openapi.keruyun.com");
//            kryApiParamConfig.setProjectVersion("1.0");
//            final KryCallService kryCallService = new KryCallService(okHttpClient, kryApiParamConfig);
//            Long shopId = 870270864L;
//            String token = kryCallService.getToken(AuthType.SHOP, shopId);
//            KryOrders kryOrders = new KryOrders();
//            kryOrders.setShopIdenty(shopId);
//            kryOrders.setStartTime(1637884800000L);
//            kryOrders.setEndTime(1637971200000L);
//            kryOrders.setPageNo(page);
//            String apicall = kryCallService.postCall(KryAPI.ORDERS, AuthType.SHOP, shopId, token, kryOrders);
//        System.out.println(apicall);
//            String kryResult = JSONObject.parseObject(apicall, KryResult.class).getResult();
//            KryPage kryPage = JSONObject.parseObject(kryResult, KryPage.class);
//        System.out.println(kryPage);
//            totalRows = Integer.parseInt(kryPage.getTotalRows());
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            List<KryOrder> kryOrdersList = JSON.parseArray(kryPage.getItems(), KryOrder.class);
//            for (int i = 0; i < kryOrdersList.size(); i++) {
//                KryOrder kryOrder = kryOrdersList.get(i);
//                kryOrder.setOrderTime(formatter.format(new Timestamp(Long.parseLong(kryOrder.getOrderTime()))));
//                kryOrder.setCheckOutTime(formatter.format(new Timestamp(Long.parseLong(kryOrder.getCheckOutTime()))));
//                kryOrder.setWarehouse("shop1");
//                System.out.println(kryOrder);
//            }
//            page++;
////            System.out.println(totalRows);
//
//        }while (totalRows>=100);


//============================KryCategory==============================================================
//        OkHttpClient okHttpClient = new OkHttpClient();
//        KryApiParamConfig kryApiParamConfig = new KryApiParamConfig();
//        kryApiParamConfig.setAppKey("54e3ffc62fea15205a3e7bebcaa11d6e");
//        kryApiParamConfig.setAppSecret("12dfcc0ddcddf91face61b2ba7253961");
//        kryApiParamConfig.setProjectName("vinvin");
//        kryApiParamConfig.setUrl("https://openapi.keruyun.com");
//        kryApiParamConfig.setProjectVersion("2.0");
//        final KryCallService kryCallService = new KryCallService(okHttpClient, kryApiParamConfig);
//        Long shopId = 870270864L;
//        String token = kryCallService.getToken(AuthType.SHOP, shopId);
//        List<Long> ids = new ArrayList<>();
////        ids.add(513678675088004096L);
//        ids.add(544149907553240064L);
//        DishDetail dishDetail = new DishDetail(shopId,ids);
//        String apicall = kryCallService.postCall(KryAPI.DISH_DETAIL, AuthType.SHOP, shopId, token, dishDetail);
//
//        String kryResult = JSONObject.parseObject(apicall, KryResult.class).getResult();
//        System.out.println(kryResult);
//        List<KryDishCategorys> kryDishCategoryList = JSONArray.parseArray(kryResult, KryDishCategorys.class);
//        for (KryDishCategorys kryDishCategorys: kryDishCategoryList) {
//            String categorys = kryDishCategorys.getCategorys();
////            System.out.println(categorys.substring(1,categorys.length()-1));
//            KryDishCategoryName kryDishCategoryName = JSONObject.parseObject(categorys.substring(1, categorys.length() - 1), KryDishCategoryName.class);
//            System.out.println(kryDishCategoryName.getCategoryName());
//        }


    }



}
