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
@TableName(value = "b_book",resultMap = "bookMap")
public class Book extends Model<Book> {

    private static final long serialVersionUID = 1L;

    /**
     * 书籍ID
     */
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    /**
     * 书籍名称
     */
    @TableField(BOOKNAME)
    private String bookname;

    /**
     * 书籍描述
     */
    @TableField(BOOKDESCRIPT)
    private String bookdescript;

    /**
     * 中图分类号
     */
    @TableField(BOOKISDN)
    private String bookisdn;

    /**
     * 作者
     */
    @TableField(AUTHOR)
    private String author;

    /**
     * 出版商
     */
    @TableField(PUBLISHER)
    private String publisher;

    /**
     * 借阅次数
     */
    @TableField(FREQUENCY)
    private Integer frequency;

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
    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public String getBookdescript() {
        return bookdescript;
    }

    public void setBookdescript(String bookdescript) {
        this.bookdescript = bookdescript;
    }
    public String getBookisdn() {
        return bookisdn;
    }

    public void setBookisdn(String bookisdn) {
        this.bookisdn = bookisdn;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static final String ID = "id";

    public static final String BOOKNAME = "bookname";

    public static final String BOOKDESCRIPT = "bookdescript";

    public static final String BOOKISDN = "bookisdn";

    public static final String AUTHOR = "author";

    public static final String PUBLISHER = "publisher";

    public static final String FREQUENCY = "frequency";

    public static final String REMARK = "remark";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Book{" +
        "id=" + id +
        ", bookname=" + bookname +
        ", bookdescript=" + bookdescript +
        ", bookisdn=" + bookisdn +
        ", author=" + author +
        ", publisher=" + publisher +
        ", frequency=" + frequency +
        ", remark=" + remark +
        "}";
    }
}
