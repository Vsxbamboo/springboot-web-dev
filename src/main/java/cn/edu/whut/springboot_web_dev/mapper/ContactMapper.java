package cn.edu.whut.springboot_web_dev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.edu.whut.springboot_web_dev.dto.ContactId;
import cn.edu.whut.springboot_web_dev.model.Contact;

@Mapper
public interface ContactMapper {
    @Select("SELECT * FROM contacts WHERE username = #{username}")
    public List<Contact> findByUsername(String username);

    @Insert("INSERT INTO contacts (username, name, province, city, address, postal_code, date) VALUES (#{username}, #{name}, #{province}, #{city}, #{address}, #{postalCode}, #{date})")
    public void insert(Contact contact);

    @Delete("DELETE FROM contacts WHERE username = #{username} AND name = #{name}")
    public void delete(ContactId contactId);

    @Update("UPDATE contacts SET name = #{contact.name}, province = #{contact.province}, city = #{contact.city}, address = #{contact.address}, postal_code = #{contact.postalCode}, date = #{contact.date} WHERE username = #{contact.username} AND name = #{name}")
    public void update(@Param("name") String name, @Param("contact") Contact contact);
}
