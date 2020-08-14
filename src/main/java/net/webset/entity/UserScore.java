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
@TableName(value = "b_user_score",resultMap = "userScoreMap")
public class UserScore extends Model<UserScore> {

    private static final long serialVersionUID = 1L;

    /**
     * 答题结果主键
     */
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField(USERID)
    private Integer userid;

    /**
     * 试卷id
     */
    @TableField(TESTPAGEID)
    private Integer testpageid;

    /**
     * 试卷得分
     */
    @TableField(SCORE)
    private Integer score;

    /**
     * 创建时间
     */
    @TableField(CREATEDATE)
    private LocalDateTime createdate;

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
    public Integer getTestpageid() {
        return testpageid;
    }

    public void setTestpageid(Integer testpageid) {
        this.testpageid = testpageid;
    }
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
    public LocalDateTime getCreatedate() {
        return createdate;
    }

    public void setCreatedate(LocalDateTime createdate) {
        this.createdate = createdate;
    }

    public static final String ID = "id";

    public static final String USERID = "userid";

    public static final String TESTPAGEID = "testpageid";

    public static final String SCORE = "score";

    public static final String CREATEDATE = "createdate";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UserScore{" +
        "id=" + id +
        ", userid=" + userid +
        ", testpageid=" + testpageid +
        ", score=" + score +
        ", createdate=" + createdate +
        "}";
    }
}
