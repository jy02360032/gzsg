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
@TableName(value = "b_lend",resultMap = "lendMap")
public class Lend extends Model<Lend> {

    private static final long serialVersionUID = 1L;

    /**
     * 借阅表主键
     */
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    /**
     * 书籍ID
     */
    @TableField(BOOKID)
    private Integer bookid;

    /**
     * 借出时间
     */
    @TableField(LENDTIME)
    private LocalDateTime lendtime;

    /**
     * 收回时间
     */
    @TableField(REGAINTIME)
    private LocalDateTime regaintime;

    /**
     * 备注
     */
    @TableField(REMARK)
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }
    public LocalDateTime getLendtime() {
        return lendtime;
    }

    public void setLendtime(LocalDateTime lendtime) {
        this.lendtime = lendtime;
    }
    public LocalDateTime getRegaintime() {
        return regaintime;
    }

    public void setRegaintime(LocalDateTime regaintime) {
        this.regaintime = regaintime;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static final String ID = "id";

    public static final String BOOKID = "bookid";

    public static final String LENDTIME = "lendtime";

    public static final String REGAINTIME = "regaintime";

    public static final String REMARK = "remark";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Lend{" +
        "id=" + id +
        ", bookid=" + bookid +
        ", lendtime=" + lendtime +
        ", regaintime=" + regaintime +
        ", remark=" + remark +
        "}";
    }
}
