package io.xxnjdg.notp.utils.custom.utils;

import cn.hutool.core.util.StrUtil;
import io.xxnjdg.notp.utils.constant.DefaultPageValue;
import io.xxnjdg.notp.utils.objects.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-27 下午5:48
 */
final public class PageObjectUtil {
    private Logger logger = LoggerFactory.getLogger(PageObjectUtil.class);

    public static PageObject countPageOffsetAndSize(String pageCurrent, String pageSize, int count){
        Integer newPageCurrent;
        Integer newPageSize;

        //没有值设置默认值
        if (StrUtil.isBlank(pageCurrent)){
            newPageCurrent = DefaultPageValue.DEFAULT_CURRENT_PAGE;
        }else {
            newPageCurrent = new Integer(pageCurrent);
        }

        //没有值设置默认值
        if (StrUtil.isBlank(pageSize)){
            newPageSize = DefaultPageValue.DEFAULT_CURRENT_LIST_SIZE;
        }else{
            newPageSize = new Integer(pageSize);
        }

        //总数 + 列表数 算总页数
        int totalPage = cn.hutool.core.util.PageUtil.totalPage(count, newPageSize);

        //算 limit offset size
        int[] startEnd;
        if (totalPage < newPageCurrent){
            newPageCurrent = totalPage;
        }

        //设置 limit
        startEnd = cn.hutool.core.util.PageUtil.transToStartEnd(newPageCurrent-1, newPageSize);

        return new PageObject(startEnd[0],newPageSize,Long.valueOf(newPageCurrent), (long) totalPage);
    }

}
