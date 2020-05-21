package io.xxnjdg.notp.utils.custom.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.sun.xml.internal.bind.v2.TODO;
import io.xxnjdg.notp.utils.constant.ObjectField;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-17 下午11:13
 */
public class ListToTreeUtil {

    // TODO: 20-4-18 没测试完

    private static final String PARENT_FIELD_NAME = ObjectField.PARENT_FIELD_NAME;
    private static final String CHILDREN_FIELD_NAME = ObjectField.CHILDREN_FIELD_NAME;
    private static final String PRIMARY_KEY_NAME = ObjectField.PRIMARY_KEY_NAME;
    private static final String SORT_NAME = ObjectField.SORT_NAME;
    private static final Boolean IS_SORT = true;
    private static final Boolean REMOVE_LIST = true;

    public static <T,E> List<T> getTree(List<T> originalList,E customParentId) throws Exception{
        return getTree(originalList,PRIMARY_KEY_NAME,PARENT_FIELD_NAME,CHILDREN_FIELD_NAME,customParentId,IS_SORT,SORT_NAME,REMOVE_LIST);
    }

    public static <T,E> List<T> getTree(List<T> originalList,E customParentId,Boolean isSort) throws Exception{
        return getTree(originalList,PRIMARY_KEY_NAME,PARENT_FIELD_NAME,CHILDREN_FIELD_NAME,customParentId,isSort,SORT_NAME,REMOVE_LIST);
    }

    public static <T,E> void fillTree(List<T> parentList, List<T> originalList,E customParentId) throws Exception {
        fillTree(parentList,originalList,PRIMARY_KEY_NAME,PARENT_FIELD_NAME,CHILDREN_FIELD_NAME,customParentId,IS_SORT,SORT_NAME,REMOVE_LIST);
    }

    public static <T,E> void fillTree(List<T> parentList, List<T> originalList,E customParentId,Boolean removeList) throws Exception {
        fillTree(parentList,originalList,PRIMARY_KEY_NAME,PARENT_FIELD_NAME,CHILDREN_FIELD_NAME,customParentId,IS_SORT,SORT_NAME,removeList);
    }

    /**
     * 把列表转换为树结构
     *
     * @param originalList 原始list数据
     * @param keyName 作为唯一标示的字段名称
     * @return 组装后的集合
     */
    private static <T,E> List<T> getTree(List<T> originalList, String keyName,String parentFieldName,String childrenFieldName,E customParentId,Boolean isSort,String sortName,Boolean removeList) throws Exception {

        if (originalList == null || customParentId == null){
            return null;
        }

        // 获取根节点，即找出父节点为空的对象
        List<T> topList = new ArrayList<>();
        for (int i = 0; i < originalList.size(); i++) {
            T t = originalList.get(i);
            E parentId = BeanUtil.getProperty(t, parentFieldName);
            if (ObjectUtil.equal(customParentId,parentId)) {
                topList.add(t);
            }
        }

        // 将根节点从原始list移除，减少下次处理数据
        originalList.removeAll(topList);

        if (isSort){
            CollUtil.sortByProperty(topList, sortName);
            CollUtil.reverse(topList);
        }

        // 递归封装树
        fillTree(topList, originalList, keyName, parentFieldName, childrenFieldName,customParentId,isSort,sortName,removeList);

        return topList;
    }

    /**
     * 封装树
     *
     * @param parentList 要封装为树的父对象集合
     * @param originalList 原始list数据
     * @param keyName 作为唯一标示的字段名称
     * @param parentFieldName 模型中作为parent字段名称
     * @param childrenFieldName 模型中作为children的字段名称
     */
    private static <T,E> void fillTree(List<T> parentList, List<T> originalList, String keyName, String parentFieldName, String childrenFieldName,E customParentId,Boolean isSort,String sortName,Boolean removeList) throws Exception {
        if (parentList == null || originalList == null || customParentId == null){
            return;
        }

        for (int i = 0; i < parentList.size(); i++) {
            List<T> children = fillChildren(parentList.get(i), originalList, keyName, parentFieldName, childrenFieldName,customParentId,isSort,sortName);
            if (children.isEmpty()) {
                continue;
            }

            if (removeList){
                originalList.removeAll(children);
            }

            fillTree(children, originalList, keyName, parentFieldName, childrenFieldName,customParentId,isSort,sortName,removeList);
        }
    }

    /**
     * 封装子对象
     *
     * @param parent 父对象
     * @param originalList 待处理对象集合
     * @param keyName 作为唯一标示的字段名称
     * @param parentFieldName 模型中作为parent字段名称
     * @param childrenFieldName 模型中作为children的字段名称
     */
    private static <T,E> List<T> fillChildren(T parent, List<T> originalList, String keyName, String parentFieldName, String childrenFieldName,E customParentId,Boolean isSort,String sortName) throws Exception {
        List<T> childList = new ArrayList<>();
        E parentId = BeanUtil.getProperty(parent, keyName);
        for (int i = 0; i < originalList.size(); i++) {
            T t = originalList.get(i);
            E childParentId = BeanUtil.getProperty(t, parentFieldName);
            if (ObjectUtil.equal(parentId,childParentId)) {
                childList.add(t);
            }
        }
        if (!childList.isEmpty()) {
            if (isSort){
                CollUtil.sortByProperty(childList, sortName);
                CollUtil.reverse(childList);
            }
            FieldUtils.writeDeclaredField(parent, childrenFieldName, childList, true);
        }
        return childList;
    }

}
