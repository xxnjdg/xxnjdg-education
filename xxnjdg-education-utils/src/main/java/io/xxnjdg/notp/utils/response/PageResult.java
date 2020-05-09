package io.xxnjdg.notp.utils.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
@Accessors(chain = true)
public class PageResult<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = -6774238104393246872L;
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
