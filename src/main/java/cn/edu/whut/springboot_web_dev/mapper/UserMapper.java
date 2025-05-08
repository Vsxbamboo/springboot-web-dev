package cn.edu.whut.springboot_web_dev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.edu.whut.springboot_web_dev.dto.PwdUpdateRequest;
import cn.edu.whut.springboot_web_dev.model.User;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE username = #{username}")
    User findByUsername(String username);

    @Insert("Insert into users(username, password, email, balance, birthday, avatar_id) values(#{username}, #{password}, #{email}, #{balance}, #{birthday}, #{avatarId})")
    void insert(User user);

    @Update("UPDATE users SET password = #{newPassword} WHERE username = #{username}")
    void updatePassword(PwdUpdateRequest request);

    @Select("SELECT username FROM users")
    public List<String> getAllUsernames();
}
