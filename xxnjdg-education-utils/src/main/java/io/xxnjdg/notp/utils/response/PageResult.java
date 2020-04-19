package io.xxnjdg.notp.utils.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-19 下午4:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T extends Serializable> implements Serializable {

    /**
     * 当前列表
     */
    private List<T> currentList;

    /**
     * 总页数
     */
    private Long totalPage;

    /**
     * 总数
     */
    private Long totalCount;

    /**
     * 当前页
     */
    private Long currentPage;

    /**
     * 当前列表数
     */
    private Long currentListSize;
}
