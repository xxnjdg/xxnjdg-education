package io.xxnjdg.notp.utils.objects;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-9 下午4:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageObject {

    /**
     * limit offset
     */

    private Integer offset;
    /**
     * limit offset
     */
    private Integer size;

    /**
     * 当前页
     */
    private Long currentPage;

    /**
     * 总页数
     */
    private Long totalPage;
}
