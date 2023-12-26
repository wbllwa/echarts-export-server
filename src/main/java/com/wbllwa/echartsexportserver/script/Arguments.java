package com.wbllwa.echartsexportserver.script;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ECharts参数
 * @author libw
 * @since 2023/12/26 11:15
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Arguments
{
    /**
     * EChats options
     */
    private String options;

    /**
     * 图片宽度
     */
    private String width;

    /**
     * 图片高度
     */
    private String height;
}
