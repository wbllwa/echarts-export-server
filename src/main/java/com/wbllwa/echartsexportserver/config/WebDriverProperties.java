package com.wbllwa.echartsexportserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * WebDriver配置文件
 * @author libw
 * @since 2023/12/26 11:37
 */
@ConfigurationProperties(prefix = "web-driver")
@Data
public class WebDriverProperties
{
    /**
     * 下载链接 https://googlechromelabs.github.io/chrome-for-testing/
     * chrome可执行文件路径
     */
    private String chromePath;

    /**
     * chromeDriver可执行文件路径
     */
    private String chromeDriverPath;

    /**
     * 代理 hostname:ip
     */
    private String proxy;
}
