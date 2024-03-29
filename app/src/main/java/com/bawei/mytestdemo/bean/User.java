package com.bawei.mytestdemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @describe(描述)：com.bawei.mytestdemo.bean
 * @data（日期）: 20:2019/10/28
 * @time（时间）: 20:03
 * @author（作者）: 盖磊
 **/
@Entity
public class User {
    // "headPic": "http://172.17.8.100/images/small/default/user.jpg",
    //        "nickName": "D5_s3A48",
    //        "phone": "18612344321",
    //        "sessionId": "15722641126619672",
    //        "sex": 1,
    //        "userId": 9672

    public String headPic;
    public String nickName;
    public String phone;
    public String sessionId;
    public int sex;
    public boolean check;
    @Id
    public Long userId;
    @Generated(hash = 280000703)
    public User(String headPic, String nickName, String phone, String sessionId,
            int sex, boolean check, Long userId) {
        this.headPic = headPic;
        this.nickName = nickName;
        this.phone = phone;
        this.sessionId = sessionId;
        this.sex = sex;
        this.check = check;
        this.userId = userId;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public String getHeadPic() {
        return this.headPic;
    }
    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }
    public String getNickName() {
        return this.nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getSessionId() {
        return this.sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    public int getSex() {
        return this.sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public boolean getCheck() {
        return this.check;
    }
    public void setCheck(boolean check) {
        this.check = check;
    }
    public Long getUserId() {
        return this.userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
