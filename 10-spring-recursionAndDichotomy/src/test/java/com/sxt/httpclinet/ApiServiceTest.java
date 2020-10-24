package com.sxt.httpclinet;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ApiServiceTest {

    private HttpClientUtil apiService;

    private static final String appKey = "";

    @Before
    public void init() {
        this.apiService = new HttpClientUtil();
    }

    @Test
    public void testGetEmpList() throws Exception {
        String url = "http://localhost:8090/getEmpList";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("age",21);
        HttpResult result = apiService.doGet(url, map);
        if (result != null){
            System.out.println(result.getCode());
            System.out.println(result.getBody());
        }
    }

    @Test
    public void testGetJsp() throws Exception {
        String url = "http://localhost:8090/hello";

        Map<String, Object> map = new HashMap<String, Object>();
        //map.put("age",21);
        HttpResult result = apiService.doGet(url, map);
        if (result != null){
            System.out.println(result.getCode());
            System.out.println(result.getBody());
        }
    }

    @Test
    public void testUploadFile() throws Exception {
        String url = "http://localhost:8090/upload";
        File file = new File("C:\\Users\\Lenovo\\Pictures\\my love\\274040-106.jpg");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("desc","how are you!");
        HttpResult result = apiService.uploadFile(url,file, map);
        if (result != null){
            System.out.println(result.getCode());
            System.out.println(result.getBody());
        }
    }
}
