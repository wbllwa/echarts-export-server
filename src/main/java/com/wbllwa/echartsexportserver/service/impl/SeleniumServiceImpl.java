package com.wbllwa.echartsexportserver.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import com.wbllwa.echartsexportserver.service.SeleniumService;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.OutputStream;

/**
 * @author libw
 * @since 2023/12/26 15:58
 */
@Slf4j
@Service
public class SeleniumServiceImpl implements SeleniumService
{
    @Autowired
    private WebDriver driver;

    @Override
    public WebDriver getDriver()
    {
        return driver;
    }

    @Override
    public Object executeScript(String script, Object... args)
    {
        return ((JavascriptExecutor) driver).executeScript(script, args);
    }

    @Override
    public File screenShotAs(WebElement webElement, File file)
    {
        File screenshotAs = webElement.getScreenshotAs(OutputType.FILE);
        return FileUtil.copyFile(screenshotAs, file);
    }

    @Override
    public void screenShotAs(WebElement webElement, OutputStream outputStream)
    {
        byte[] bytes = webElement.getScreenshotAs(OutputType.BYTES);
        IoUtil.write(outputStream, true, bytes);
    }
}
