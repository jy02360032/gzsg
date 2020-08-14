package net.webset.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * <p>
 * 
 * </p>
 *
 * @author 梁雪峰
 * @since 2019-04-27
 */
@TableName(value = "b_category",resultMap = "categoryMap")
public class Category extends Model<Category> {

    private static final long serialVersionUID = 1L;

    /**
     * 文章类别主键
     */
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    /**
     * 文章类别名称
     */
    @TableField(CATEGORY)
    private String category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static final String ID = "id";

    public static final String CATEGORY = "category";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Category{" +
        "id=" + id +
        ", category=" + category +
        "}";
    }
}
