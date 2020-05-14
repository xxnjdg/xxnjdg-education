package io.xxnjdg.notp.utils.constant;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-12 下午4:00
 */
public interface AuditStatus {


    /**
     * 审核状态 0:待审核
     */
    Integer PENDING_APPROVAL = 0;

    /**
     * 审核状态 1:审核通过
     */
    Integer PASS = 1;

    /**
     * 审核状态 2:审核不通过
     */
    Integer NO_PASS = 2;

}
