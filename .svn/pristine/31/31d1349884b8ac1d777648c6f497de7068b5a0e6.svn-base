package com.system.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * requset请求page对象
 */
@ApiModel(value = "分页对象")
public class ReqPage implements Serializable {

    /**
     * 偏移量
     */
    @ApiModelProperty(value = "偏移量", hidden = true)
    private Integer offset;

    /**
     * 页面大小  默认10
     */
    @Min(1)
    @NotNull
    @ApiModelProperty(value = "页面大小  默认10", dataType = "Integer")
    private Integer limit = 10;

    /**
     * 当前页码  默认1
     */
    @Min(1)
    @NotNull
    @ApiModelProperty(value = "当前页码  默认1", dataType = "Integer")
    private Integer pageNum = 1;


    public ReqPage(Integer pageNum, Integer limit) {
        this.setPageNum(pageNum);
        this.setLimit(limit);
    }

    public ReqPage() {
    }


    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        if (limit == null || limit < 1) {
            this.limit = 1;
        } else {
            this.limit = limit;
        }
    }

    public Integer getPageNum() {
        return this.getOffset();
    }

    public void setPageNum(Integer pageNum) {
        if (pageNum == null || pageNum < 1) {
            this.pageNum = 1;
        } else {
            this.pageNum = pageNum;
        }
    }

    public Integer getOffset() {
        return (this.pageNum - 1) * this.limit;
    }

    public int getTotalRows(int totalCount) {
        //int totalPageNum = (totalRecord  +  pageSize  - 1) / pageSize;
        return (int) Math.ceil(totalCount / this.limit);
    }

    @ApiModel(value = "分页对象QReqPage", parent = ReqPage.class)
    public static class QReqPage extends ReqPage {

        /**
         * 搜索关键字
         */
        @NotBlank
        @ApiModelProperty(value = "搜索关键字", dataType = "String")
        private String keyWord;

        public String getKeyWord() {
            return keyWord;
        }

        public void setKeyWord(String keyWord) {
            if (keyWord != null) {
                keyWord = keyWord.trim();
            }
            this.keyWord = keyWord;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("QReqPage{");
            sb.append("pageNum=").append(super.getPageNum());
            sb.append(", limit=").append(super.getLimit());
            sb.append(", keyWord='").append(keyWord).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ReqPage{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", limit=").append(limit);
        sb.append('}');
        return sb.toString();
    }
}
