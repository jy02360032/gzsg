package net.webset.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.util.Date;

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
@TableName(value = "b_article",resultMap = "articleMap")
public class Article extends Model<Article> {

    private static final long serialVersionUID = 1L;

    /**
     * 文章主键
     */
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    /**
     * 文章标题
     */
    @TableField(TITLE)
    private String title;

    /**
     * 文章作者
     */
    @TableField(AUTHOR)
    private String author;

    /**
     * 文章内容
     */
    @TableField(CONTENT)
    private String content;

    /**
     * 视频地址
     */
    @TableField(VIDEOURL)
    private String videourl;

    /**
     * 类别
     */
    @TableField(CATEGORY)
    private Integer category;

    /**
     * 创建时间
     */
    @TableField(CREATEDATE)
    private Date createdate;

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
    @TableField(DESCRIBES)
    private String describes;

    /**
     * 更新时间
     */
    @TableField(LAST_MODIFIED)
    private Date lastModified;

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
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }
    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
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
    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }
    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public static final String ID = "id";

    public static final String TITLE = "title";

    public static final String AUTHOR = "author";

    public static final String CONTENT = "content";

    public static final String VIDEOURL = "videourl";

    public static final String CATEGORY = "category";

    public static final String CREATEDATE = "createdate";

    public static final String ISTOP = "istop";

    public static final String ISDEL = "isdel";

    public static final String DESCRIBES = "describes";

    public static final String LAST_MODIFIED = "last_modified";
    
    public static final String CORE = "article";

	public static final String TBNAME = "b_article";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Article{" +
        "id=" + id +
        ", title=" + title +
        ", author=" + author +
        ", content=" + content +
        ", videourl=" + videourl +
        ", category=" + category +
        ", createdate=" + createdate +
        ", istop=" + istop +
        ", isdel=" + isdel +
        ", describes=" + describes +
        ", lastModified=" + lastModified +
        "}";
    }
}
