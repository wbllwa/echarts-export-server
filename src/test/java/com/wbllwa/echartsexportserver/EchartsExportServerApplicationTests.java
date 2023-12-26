package com.wbllwa.echartsexportserver;

import cn.hutool.core.io.FileUtil;
import com.wbllwa.echartsexportserver.script.Arguments;
import com.wbllwa.echartsexportserver.service.EchartsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.OutputStream;

@SpringBootTest
class EchartsExportServerApplicationTests {

    @Autowired
    private EchartsService echartsService;

    /**
     * 默认输出文件夹
     */
    private String LOCAL_PATH = "E:\\echarts\\";

    /**
     * 获取默认文件输出流
     * @return
     */
    private OutputStream getLocalFileOutputStream()
    {
        return FileUtil.getOutputStream(LOCAL_PATH + System.currentTimeMillis() + ".png");
    }

    @Test
    void basicLineChart()
    {
        String options = "{\"animation\": false,\"xAxis\":{\"type\":\"category\",\"data\":[\"Mon\",\"Tue\",\"Wed\",\"Thu\",\"Fri\",\"Sat\",\"Sun\"]},\"yAxis\":{\"type\":\"value\"},\"series\":[{\"data\":[150,230,224,218,135,147,260],\"type\":\"line\"}]}";
        Arguments arguments = Arguments.builder()
                .options(options)
                .build();
        echartsService.generateEChartsPicture(arguments, getLocalFileOutputStream());
    }

    @Test
    void stackedAreaChart()
    {
        String options = "{\"animation\": false,\"title\":{\"text\":\"Stacked Area Chart\"},\"tooltip\":{\"trigger\":\"axis\",\"axisPointer\":{\"type\":\"cross\",\"label\":{\"backgroundColor\":\"#6a7985\"}}},\"legend\":{\"data\":[\"Email\",\"Union Ads\",\"Video Ads\",\"Direct\",\"Search Engine\"]},\"toolbox\":{\"feature\":{\"saveAsImage\":{}}},\"grid\":{\"left\":\"3%\",\"right\":\"4%\",\"bottom\":\"3%\",\"containLabel\":true},\"xAxis\":[{\"type\":\"category\",\"boundaryGap\":false,\"data\":[\"Mon\",\"Tue\",\"Wed\",\"Thu\",\"Fri\",\"Sat\",\"Sun\"]}],\"yAxis\":[{\"type\":\"value\"}],\"series\":[{\"name\":\"Email\",\"type\":\"line\",\"stack\":\"Total\",\"areaStyle\":{},\"emphasis\":{\"focus\":\"series\"},\"data\":[120,132,101,134,90,230,210]},{\"name\":\"Union Ads\",\"type\":\"line\",\"stack\":\"Total\",\"areaStyle\":{},\"emphasis\":{\"focus\":\"series\"},\"data\":[220,182,191,234,290,330,310]},{\"name\":\"Video Ads\",\"type\":\"line\",\"stack\":\"Total\",\"areaStyle\":{},\"emphasis\":{\"focus\":\"series\"},\"data\":[150,232,201,154,190,330,410]},{\"name\":\"Direct\",\"type\":\"line\",\"stack\":\"Total\",\"areaStyle\":{},\"emphasis\":{\"focus\":\"series\"},\"data\":[320,332,301,334,390,330,320]},{\"name\":\"Search Engine\",\"type\":\"line\",\"stack\":\"Total\",\"label\":{\"show\":true,\"position\":\"top\"},\"areaStyle\":{},\"emphasis\":{\"focus\":\"series\"},\"data\":[820,932,901,934,1290,1330,1320]}]}";
        Arguments arguments = Arguments.builder()
                .options(options)
                .build();
        echartsService.generateEChartsPicture(arguments, getLocalFileOutputStream());
    }

    @Test
    void pie()
    {
        String options = "{\"animation\": false,\"tooltip\":{\"show\": true,\"trigger\":\"item\"},\"legend\":{\"top\":\"5%\",\"left\":\"center\"},\"series\":[{\"name\":\"Access From\",\"type\":\"pie\",\"radius\":[\"40%\",\"70%\"],\"avoidLabelOverlap\":false,\"label\":{\"show\":false,\"position\":\"center\"},\"emphasis\":{\"label\":{\"show\":true,\"fontSize\":40,\"fontWeight\":\"bold\"}},\"labelLine\":{\"show\":false},\"data\":[{\"value\":1048,\"name\":\"Search Engine\"},{\"value\":735,\"name\":\"Direct\"},{\"value\":580,\"name\":\"Email\"},{\"value\":484,\"name\":\"Union Ads\"},{\"value\":300,\"name\":\"Video Ads\"}]}]}";
        Arguments arguments = Arguments.builder()
                .options(options)
                .build();
        echartsService.generateEChartsPicture(arguments, getLocalFileOutputStream());
    }
}
