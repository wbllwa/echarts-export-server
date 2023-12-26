package com.wbllwa.echartsexportserver.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.OutputStream;

/**
 * 自动化服务
 * 
 * @author libw
 * @since 2023/12/26 15:58
 */
public interface SeleniumService
{
    WebDriver getDriver();

    /**
     * 执行JavaScript脚本
     * @param script
     * @param args
     * @return
     */
    Object executeScript(String script, Object... args);

    /**
     * 截图并另存为文件
     * @param webElement
     * @param file
     * @return
     */
    File screenShotAs(WebElement webElement, File file);

    /**
     * 截图并将流另存为
     * @param webElement
     * @param outputStream
     */
    void screenShotAs(WebElement webElement, OutputStream outputStream);
}
