package edu.guet.covid_19_visualization.msm.service;

import java.util.Map;

public interface CodeService {
    //发送短信的方法
    boolean send(Map<String, Object> param, String phone);
}
