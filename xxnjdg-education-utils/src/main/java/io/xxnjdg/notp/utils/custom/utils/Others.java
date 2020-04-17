package io.xxnjdg.notp.utils.custom.utils;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-18 上午12:22
 */
public class Others {
    /*private List<CourseCategoryLevelVo> traverseLevel(List<CourseCategory> fullList, HashMap<Long, List<CourseCategory>> longListHashMap, BaseLevel baseLevel){
        CourseCategory courseCategory = new CourseCategory();
        courseCategory.setId(0L);

        ArrayList<CourseCategory> courseCategories = new ArrayList<>();
        courseCategories.add(courseCategory);

        return traverseLevel(courseCategories,fullList,longListHashMap,baseLevel);
    }

    private List<CourseCategoryLevelVo> traverseLevel(List<CourseCategory> parentList, List<CourseCategory> fullList, HashMap<Long, List<CourseCategory>> longListHashMap, BaseLevel baseLevel){

        if (parentList.isEmpty() || fullList.isEmpty() || longListHashMap == null || baseLevel==null ){
            return null;
        }

        List<CourseCategory> currentLevelList = filterLevelList(fullList, baseLevel);

        if (CollUtil.isEmpty(currentLevelList)){
            return handleSortAndPoToVo(longListHashMap);
        }

        buildChildrenList(parentList,currentLevelList,longListHashMap);

        BaseLevel nextInstance = baseLevel.getNextInstance();
        if(nextInstance == null){
            return handleSortAndPoToVo(longListHashMap);
        }

        return traverseLevel(currentLevelList,fullList,longListHashMap,nextInstance);
    }

    private List<CourseCategory> filterLevelList(List<CourseCategory> list,BaseLevel baseLevel){
        return list
                .stream()
                .filter(courseCategory -> baseLevel.getCurrentIndex().equals(courseCategory.getFloor()))
                .collect(Collectors.toList());
    }

    private ArrayList<CourseCategoryLevelVo> sortCourseCategoryLevelVo(List<CourseCategory> list){
        CollUtil.sortByProperty(list, ItemSort.SORT.getStatusText());

        ArrayList<CourseCategoryLevelVo> courseCategoryLevelVos = new ArrayList<>();

        for (int i = list.size()-1; i >= 0; i--) {
            courseCategoryLevelVos.add(BeanUtil.copyProperties(list.get(i),CourseCategoryLevelVo.class));
        }

        return courseCategoryLevelVos;
    }

    private void buildChildrenList(List<CourseCategory> firstList, List<CourseCategory> secondList, Map<Long, List<CourseCategory>> longListHashMap){
        firstList.forEach(first -> {
            secondList.forEach(second -> {
                if( first.getId().equals(second.getParentId())){
                    List<CourseCategory> courseCategories = longListHashMap.get(first.getId());
                    if(courseCategories == null){
                        courseCategories = new ArrayList<>();
                        longListHashMap.put(first.getId(),courseCategories);
                    }
                    courseCategories.add(second);
                }
            });
        });
    }

    private List<CourseCategoryLevelVo> handleSortAndPoToVo(HashMap<Long, List<CourseCategory>> longListHashMap,Long id){

        List<CourseCategory> courseCategories = longListHashMap.get(id);
        if (courseCategories == null){
            return null;
        }

        ArrayList<CourseCategoryLevelVo> courseCategoryLevelVos = sortCourseCategoryLevelVo(courseCategories);

        courseCategoryLevelVos.forEach(courseCategoryLevelVo -> {

            List<CourseCategoryLevelVo> courseCategoryLevelVos1 = handleSortAndPoToVo(longListHashMap, courseCategoryLevelVo.getId());

            courseCategoryLevelVo.setChildren(courseCategoryLevelVos1);

        });

        return courseCategoryLevelVos;
    }

    private List<CourseCategoryLevelVo> handleSortAndPoToVo(HashMap<Long, List<CourseCategory>> longListHashMap){
       return this.handleSortAndPoToVo(longListHashMap,0L);
    }*/
}
