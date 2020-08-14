package net.webset.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "b_userconnection",resultMap = "userconnectionMap")
public class Userconnection extends Model<Userconnection> {

    private static final long serialVersionUID = 1L;

    @TableId("userId")
    private String userId;

    @TableField(PROVIDERID)
    private String providerId;

    @TableField(PROVIDERUSERID)
    private String providerUserId;

    @TableField(RANK)
    private Integer rank;

    @TableField(DISPLAYNAME)
    private String displayName;

    @TableField(PROFILEURL)
    private String profileUrl;

    @TableField(IMAGEURL)
    private String imageUrl;

    @TableField(ACCESSTOKEN)
    private String accessToken;

    @TableField(SECRET)
    private String secret;

    @TableField(REFRESHTOKEN)
    private String refreshToken;

    @TableField(EXPIRETIME)
    private Long expireTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
    public String getProviderUserId() {
        return providerUserId;
    }

    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public static final String USERID = "userId";

    public static final String PROVIDERID = "providerId";

    public static final String PROVIDERUSERID = "providerUserId";

    public static final String RANK = "rank";

    public static final String DISPLAYNAME = "displayName";

    public static final String PROFILEURL = "profileUrl";

    public static final String IMAGEURL = "imageUrl";

    public static final String ACCESSTOKEN = "accessToken";

    public static final String SECRET = "secret";

    public static final String REFRESHTOKEN = "refreshToken";

    public static final String EXPIRETIME = "expireTime";

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "Userconnection{" +
        "userId=" + userId +
        ", providerId=" + providerId +
        ", providerUserId=" + providerUserId +
        ", rank=" + rank +
        ", displayName=" + displayName +
        ", profileUrl=" + profileUrl +
        ", imageUrl=" + imageUrl +
        ", accessToken=" + accessToken +
        ", secret=" + secret +
        ", refreshToken=" + refreshToken +
        ", expireTime=" + expireTime +
        "}";
    }
}
