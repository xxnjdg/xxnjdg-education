package io.xxnjdg.notp.system.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.system.admin.object.business.WebsiteNavArticleBO;
import io.xxnjdg.notp.system.admin.object.business.WebsiteNavBO;
import io.xxnjdg.notp.system.admin.object.convert.WebsiteNavMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.WebsiteNavArticleDTO;
import io.xxnjdg.notp.system.admin.object.data.transfer.WebsiteNavDTO;
import io.xxnjdg.notp.system.admin.object.error.WebsiteNavArticleEnum;
import io.xxnjdg.notp.system.admin.service.WebsiteNavAdminService;
import io.xxnjdg.notp.system.admin.service.WebsiteNavArticleAdminService;
import io.xxnjdg.notp.system.mapper.WebsiteNavMapper;
import io.xxnjdg.notp.system.object.persistent.WebsiteNav;
import io.xxnjdg.notp.utils.config.SnowFlakeId;
import io.xxnjdg.notp.utils.constant.HttpStatus;
import io.xxnjdg.notp.utils.constant.ParentId;
import io.xxnjdg.notp.utils.custom.utils.ListToTreeUtil;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 19:54
 */
@Service
public class WebsiteNavAdminServiceImpl extends ServiceImpl<WebsiteNavMapper, WebsiteNav> implements WebsiteNavAdminService {

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Autowired
    private WebsiteNavArticleAdminService websiteNavArticleAdminService;

    @Override
    public PageResult<WebsiteNavBO> listWebsiteNavByPage(WebsiteNavDTO websiteNavDTO) {
        PageResult<WebsiteNavBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<WebsiteNav> wrapper = new QueryWrapper<WebsiteNav>()
                .lambda();

        Integer statusId = websiteNavDTO.getStatusId();
        Long parentId = websiteNavDTO.getParentId();
        String navName = null;

        if (statusId != null) {
            wrapper.eq(WebsiteNav::getStatusId, statusId);
        }

        if (parentId != null) {
            wrapper.eq(WebsiteNav::getParentId, parentId);
        }

        if (StrUtil.isNotBlank(websiteNavDTO.getNavName())) {
            navName = websiteNavDTO.getNavName();
            wrapper.like(WebsiteNav::getNavName, navName);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                websiteNavDTO.getPageCurrent(), websiteNavDTO.getPageSize(), count);

        //查询
        List<WebsiteNav> websiteNavList =
                this.baseMapper.listWebsiteNavByPage(statusId, parentId, navName, pageObject.getOffset(), pageObject.getSize());

        List<WebsiteNavBO> websiteNavBOList = WebsiteNavMapStruct.INSTANCE.P2B(websiteNavList);

        List<WebsiteNavBO> list = WebsiteNavMapStruct.INSTANCE.P2B(this.list());


        try {
            ListToTreeUtil.fillTree(websiteNavBOList, list, ParentId.ZERO_PARENT_ID.getStatus(), false);
        } catch (Exception e) {
            throw new BaseException(HttpStatus.ERROR.getStatus(),e.getMessage());
        }

        List<WebsiteNavArticleBO> websiteNavArticleBOList = websiteNavArticleAdminService.listWebsiteNavArticle();
        if (CollUtil.isNotEmpty(websiteNavArticleBOList)){
            setArticle(websiteNavBOList, websiteNavArticleBOList);
        }

        return result
                .setCurrentList(websiteNavBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) websiteNavList.size());
    }

    @Override
    public Boolean saveWebsiteNav(WebsiteNavDTO websiteNavDTO) {
        if (!ObjectUtil.equal(websiteNavDTO.getParentId(),0L)){
            this.getWebsiteNavById(websiteNavDTO);
        }

        //生成主键id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long id = snowflake.nextId();

        WebsiteNav websiteNav = WebsiteNavMapStruct.INSTANCE.DT2P(websiteNavDTO).setId(id);

        boolean save = this.save(websiteNav);
        if (!save){
            throw new BaseException(WebsiteNavArticleEnum.SAVE_ERROR);
        }

        return true;
    }

    @Override
    public WebsiteNavBO getWebsiteNavById(WebsiteNavDTO websiteNavDTO) {
        WebsiteNav websiteNav = this.getById(websiteNavDTO.getId());
        if (websiteNav == null){
            throw new BaseException(WebsiteNavArticleEnum.GET_ERROR);
        }
        return WebsiteNavMapStruct.INSTANCE.P2B(websiteNav);
    }

    @Override
    @Transactional
    public Boolean updateWebsiteNavById(WebsiteNavDTO websiteNavDTO) {
        WebsiteNav websiteNav = WebsiteNavMapStruct.INSTANCE.DT2P(websiteNavDTO);

        boolean update = this.updateById(websiteNav);
        if (!update){
            throw new BaseException(WebsiteNavArticleEnum.UPDATE_ERROR);
        }

        Integer statusId = websiteNavDTO.getStatusId();
        if (statusId!=null){
            List<WebsiteNav> websiteNavList = this.list();
            if (CollUtil.isEmpty(websiteNavList)){
                throw new BaseException(WebsiteNavArticleEnum.DELETE_ERROR);
            }
            ArrayList<WebsiteNav> list = new ArrayList<>();
            updateChildren(websiteNavList,list,websiteNavDTO.getId());
            if (CollUtil.isNotEmpty(list)){
                list.forEach(websiteNav1 -> websiteNav1.setStatusId(statusId));
            }
            boolean batch = this.updateBatchById(list);
            if (!batch){
                throw new BaseException(WebsiteNavArticleEnum.UPDATE_ERROR);
            }
        }

        return true;
    }

    @Override
    @Transactional
    public Boolean deleteWebsiteNavById(WebsiteNavDTO websiteNavDTO) {
        List<WebsiteNav> websiteNavList = this.list();
        if (CollUtil.isEmpty(websiteNavList)){
            throw new BaseException(WebsiteNavArticleEnum.DELETE_ERROR);
        }
        ArrayList<Long> list = new ArrayList<>();
        list.add(websiteNavDTO.getId());
        deleteChildren(websiteNavList, list, websiteNavDTO.getId());
        boolean remove = this.removeByIds(list);
        if (!remove){
            throw new BaseException(WebsiteNavArticleEnum.DELETE_ERROR);
        }
        return true;
    }

    private void updateChildren(List<WebsiteNav> websiteNavList, ArrayList<WebsiteNav> list, Long id) {
        websiteNavList.forEach(websiteNav -> {
            if (ObjectUtil.equal(id,websiteNav.getParentId())){
                list.add(websiteNav);
                updateChildren(websiteNavList,list,websiteNav.getId());
            }
        });
    }

    private void deleteChildren(List<WebsiteNav> websiteNavList, ArrayList<Long> list, Long id) {
        websiteNavList.forEach(websiteNav -> {
            if (ObjectUtil.equal(id,websiteNav.getParentId())){
                list.add(websiteNav.getId());
                deleteChildren(websiteNavList,list,websiteNav.getId());
            }
        });
    }

    private void setArticle(List<WebsiteNavBO> websiteNavBOList, List<WebsiteNavArticleBO> websiteNavArticleBOList) {
        websiteNavBOList.forEach(websiteNavBO -> {
            for (WebsiteNavArticleBO websiteNavArticleBO : websiteNavArticleBOList) {
                if (ObjectUtil.equal(websiteNavBO.getId(),websiteNavArticleBO.getNavId())){
                    websiteNavBO.setIsArticle(1);
                    break;
                }
            }
            if (CollUtil.isNotEmpty(websiteNavBO.getChildren())){
                setArticle(websiteNavBO.getChildren(),websiteNavArticleBOList);
            }
        });
    }
}
