package io.xxnjdg.notp.course.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-18 下午6:28
 */
@Data
public class ZoneVO implements Serializable {


    private static final long serialVersionUID = 686526492775775134L;

    /**
     * 专区编号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 专区名称
     */
    private String zoneName;

    /**
     * 专区描述
     */
    private String zoneDesc;

    /**
     * 课程信息
     */
    private List<ZoneCourseVO> zoneCourseList = new ArrayList<>();

}
