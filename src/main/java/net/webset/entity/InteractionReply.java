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
@TableName(value = "b_interaction_reply",resultMap = "interactionReplyMap")
public class InteractionReply extends Model<InteractionReply> {

    private static final long serialVersionUID = 1L;

    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    @TableField(USERID)
    private Integer userid;

    @TableField(INTERACTIONID)
    private Integer interactionid;

    @TableField(REPLY)
    private String reply;

    /**
     * 回复时间
     */
    @TableField(CREATETIME)
    private LocalDateTime createtime;

    /**
     * 审核状态，0，未审核，1，通过，2不通过
     */
    @TableField(STATE)
    private Integer state;

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
    public Integer getInteractionid() {
        return interactionid;
    }

    public void setInteractionid(Integer interactionid) {
        this.interactionid = interactionid;
    }
    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public static final String ID = "id";

    public static final String USERID = "userid";

    public static final String INTERACTIONID = "interactionid";

    public static final String REPLY = "reply";

    public static final String CREATETIME = "createtime";

    public static final String STATE = "state";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "InteractionReply{" +
        "id=" + id +
        ", userid=" + userid +
        ", interactionid=" + interactionid +
        ", reply=" + reply +
        ", createtime=" + createtime +
        ", state=" + state +
        "}";
    }
}
