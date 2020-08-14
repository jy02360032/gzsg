package net.webset.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName(value = "b_testquestion",resultMap = "testquestionMap")
public class Testquestion extends Model<Testquestion> {

    private static final long serialVersionUID = 1L;

    /**
     * 试题主键
     */
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    /**
     * 题目
     */
    @TableField(SUBJECT)
    private String subject;

    /**
     * 选项A
     */
    @TableField(OPTIONA)
    private String optionA;

    /**
     * 选项B
     */
    @TableField(OPTIONB)
    private String optionB;

    /**
     * 选项C
     */
    @TableField(OPTIONC)
    private String optionC;

    /**
     * 选项D
     */
    @TableField(OPTIOND)
    private String optionD;

    /**
     * 正确答案
     */
    @TableField(RIGHTKEY)
    private String rightkey;

    /**
     * 所属试卷id
     */
    @TableField(PID)
    private Integer pid;

    /**
     * 是否删除
     */
    @TableField(ISDEL)
    private Integer isdel;

    /**
     * 题目分数
     */
    @TableField(SCORE)
    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }
    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }
    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }
    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }
    public String getRightkey() {
        return rightkey;
    }

    public void setRightkey(String rightkey) {
        this.rightkey = rightkey;
    }
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public static final String ID = "id";

    public static final String SUBJECT = "subject";

    public static final String OPTIONA = "optionA";

    public static final String OPTIONB = "optionB";

    public static final String OPTIONC = "optionC";

    public static final String OPTIOND = "optionD";

    public static final String RIGHTKEY = "rightkey";

    public static final String PID = "pid";

    public static final String ISDEL = "isdel";

    public static final String SCORE = "score";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Testquestion{" +
        "id=" + id +
        ", subject=" + subject +
        ", optionA=" + optionA +
        ", optionB=" + optionB +
        ", optionC=" + optionC +
        ", optionD=" + optionD +
        ", rightkey=" + rightkey +
        ", pid=" + pid +
        ", isdel=" + isdel +
        ", score=" + score +
        "}";
    }
}
