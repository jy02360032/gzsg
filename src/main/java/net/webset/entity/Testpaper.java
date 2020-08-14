package net.webset.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 梁雪峰
 * @since 2019-04-27
 */
@TableName(value = "b_testpaper",resultMap = "testpaperMap")
public class Testpaper extends Model<Testpaper> {

    private static final long serialVersionUID = 1L;

    /**
     * 试卷主键
     */
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    /**
     * 试卷题目
     */
    @TableField(TITLE)
    private String title;

    /**
     * 作者
     */
    @TableField(AUTHOR)
    private String author;

    /**
     * 创建时间
     */
    @TableField(CREATEDATE)
    private LocalDateTime createdate;

    /**
     * 修改时间
     */
    @TableField(MODIFYDATE)
    private LocalDateTime modifydate;

    /**
     * 是否置顶
     */
    @TableField(ISTOP)
    private Integer istop;

    /**
     * 是否删除
     */
    @TableField(ISDEL)
    private Integer isdel;

    /**
     * 描述
     */
    @TableField(DESCRIPTION)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public LocalDateTime getCreatedate() {
        return createdate;
    }

    public void setCreatedate(LocalDateTime createdate) {
        this.createdate = createdate;
    }
    public LocalDateTime getModifydate() {
        return modifydate;
    }

    public void setModifydate(LocalDateTime modifydate) {
        this.modifydate = modifydate;
    }
    public Integer getIstop() {
        return istop;
    }

    public void setIstop(Integer istop) {
        this.istop = istop;
    }
    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static final String ID = "id";

    public static final String TITLE = "title";

    public static final String AUTHOR = "author";

    public static final String CREATEDATE = "createdate";

    public static final String MODIFYDATE = "modifydate";

    public static final String ISTOP = "istop";

    public static final String ISDEL = "isdel";

    public static final String DESCRIPTION = "description";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Testpaper{" +
        "id=" + id +
        ", title=" + title +
        ", author=" + author +
        ", createdate=" + createdate +
        ", modifydate=" + modifydate +
        ", istop=" + istop +
        ", isdel=" + isdel +
        ", description=" + description +
        "}";
    }
}
