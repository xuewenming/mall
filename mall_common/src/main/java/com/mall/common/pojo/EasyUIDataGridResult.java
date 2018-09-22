package com.mall.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 查询商品返回类型
 * @author Sam
 * @date 2018/9/18
 * @time 20:49
 */
public class EasyUIDataGridResult implements Serializable {
    private static final long serialVersionUID = -6849721563764815745L;

    private Long total;
    private List<?> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
