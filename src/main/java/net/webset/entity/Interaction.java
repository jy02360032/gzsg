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
@TableName(value = "b_interaction",resultMap = "interactionMap")
public class Interaction extends Model<Interaction> {

    private static final long serialVersionUID = 1L;

    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @TableField(USERID)
    private Integer userid;

    /**
     * 创建日期
     */
    @TableField(CREATETIME)
    private LocalDateTime createtime;

    /**
     * 讨论标题
     */
    @TableField(TITLE)
    private String title;

    /**
     * 帖子内容
     */
    @TableField(TEXT)
    private String text;

    /**
     * 点击计数器
     */
    @TableField(CONT)
    private Integer cont;

    /**
     * 是否置顶：是-1，否-0
     */
    @TableField(STATUS)
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public Integer getCont() {
        return cont;
    }

    public void setCont(Integer cont) {
        this.cont = cont;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static final String ID = "id";

    public static final String USERID = "userid";

    public static final String CREATETIME = "createtime";

    public static final String TITLE = "title";

    public static final String TEXT = "text";

    public static final String CONT = "cont";

    public static final String STATUS = "status";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Interaction{" +
        "id=" + id +
        ", userid=" + userid +
        ", createtime=" + createtime +
        ", title=" + title +
        ", text=" + text +
        ", cont=" + cont +
        ", status=" + status +
        "}";
    }
}
