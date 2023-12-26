package com.wbllwa.echartsexportserver.service;

import com.wbllwa.echartsexportserver.script.Arguments;

import java.io.OutputStream;

/**
 * ECharts导出服务
 * @author libw
 * @since 2023/12/26 11:57
 */
public interface EchartsService
{
    /**
     * 生成ECharts图片
     * @param arguments
     * @param outputStream
     */
    void generateEChartsPicture(Arguments arguments, OutputStream outputStream);

}
