package com.wbllwa.echartsexportserver.config;

import cn.hutool.core.util.StrUtil;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverLogLevel;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author libw
 * @since 2023/12/26 11:40
 */
@Configuration
@EnableConfigurationProperties(WebDriverProperties.class)
public class WebDriverConfig
{
    @Autowired
    private WebDriverProperties webDriverProperties;

    @Bean
    public WebDriver buildWebDriver()
    {
        // 设置chrome driver位置
        System.setProperty("webdriver.chrome.driver", webDriverProperties.getChromeDriverPath());

//        System.setProperty("webdriver.chrome.whitelistedIps", "");
        ChromeOptions options = new ChromeOptions();
        // 开启无头模式
        options.setHeadless(true);
        // 设置日志
        options.setLogLevel(ChromeDriverLogLevel.SEVERE);
        // 系统代理
        String proxyStr = webDriverProperties.getProxy();
        if (StrUtil.isNotEmpty(proxyStr))
        {
            Proxy proxy = new Proxy();
            proxy.setHttpProxy(proxyStr);
            proxy.setSslProxy(proxyStr);
            options.setProxy(proxy);
        }

        // 设置chrome位置
        options.setBinary(webDriverProperties.getChromePath());
        options.addArguments("--remote-allow-origins=*");
        // 设置页面加载策略
//        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        return new ChromeDriver(options);
    }
}
