package com.wbllwa.echartsexportserver.service.impl;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Assert;
import com.wbllwa.echartsexportserver.script.Arguments;
import com.wbllwa.echartsexportserver.service.EchartsService;
import com.wbllwa.echartsexportserver.service.SeleniumService;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.OutputStream;

/**
 * @author libw
 * @since 2023/12/25 16:18
 */
@Slf4j
@Service
public class EchartsServiceImpl implements EchartsService
{
    @Autowired
    private SeleniumService seleniumService;

    private static final String ECHARTS_JS = "script/echarts.min.js";
    private static final String SCRIPT_JS = "script/script.js";

    /**
     * EChart图表ID
     */
    private By ECHART = By.id("demo");

    @Override
    public void generateEChartsPicture(Arguments arguments, OutputStream outputStream)
    {
        String options = arguments.getOptions();
        Assert.notNull(options, IllegalArgumentException::new);
        options = commonOptions(options);
        // 加载Echarts库
        seleniumService.executeScript(getScriptStr(ECHARTS_JS));
        // 执行脚本
        seleniumService.executeScript(getScriptStr(SCRIPT_JS), options);

        WebDriver driver = seleniumService.getDriver();
        WebElement element = driver.findElement(ECHART);
        seleniumService.screenShotAs(element, outputStream);
    }

    /**
     * 设置通用参数 自定义参数无法覆盖通用参数
     * @param options
     * @return
     */
    private String commonOptions(String options)
    {
        return options;
    }

    /**
     * 获取JavaScript脚本
     * @param resource
     * @return
     */
    private String getScriptStr(String resource)
    {
        return ResourceUtil.readUtf8Str(resource);
    }
}
