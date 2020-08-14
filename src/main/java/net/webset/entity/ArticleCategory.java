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
@TableName(value = "b_article_category",resultMap = "articleCategoryMap")
public class ArticleCategory extends Model<ArticleCategory> {

    private static final long serialVersionUID = 1L;

    /**
     * id主键
     */
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    /**
     * 文章id
     */
    @TableField(ARTICLEID)
    private Integer articleid;

    /**
     * 文件类型
     */
    @TableField(FILETYPE)
    private String filetype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }
    
    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public static final String ID = "id";

    public static final String ARTICLEID = "articleid";

    public static final String FILETYPE = "filetype";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ArticleCategory{" +
        "id=" + id +
        ", articleid=" + articleid +
        ", filetype=" + filetype +
        "}";
    }
}
