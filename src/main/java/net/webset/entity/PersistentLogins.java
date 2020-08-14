package net.webset.entity;

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
public class PersistentLogins extends Model<PersistentLogins> {

    private static final long serialVersionUID = 1L;

    @TableField(USERNAME)
    private String username;

    @TableId(SERIES)
    private String series;

    @TableField(TOKEN)
    private String token;

    @TableField(LAST_USED)
    private LocalDateTime lastUsed;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public LocalDateTime getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(LocalDateTime lastUsed) {
        this.lastUsed = lastUsed;
    }

    public static final String USERNAME = "username";

    public static final String SERIES = "series";

    public static final String TOKEN = "token";

    public static final String LAST_USED = "last_used";

    @Override
    protected Serializable pkVal() {
        return this.series;
    }

    @Override
    public String toString() {
        return "PersistentLogins{" +
        "username=" + username +
        ", series=" + series +
        ", token=" + token +
        ", lastUsed=" + lastUsed +
        "}";
    }
}
