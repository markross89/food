package pl.coderslab.dao;

import pl.coderslab.model.ContactObject;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ContactDao {
	
	private static final String READ_CONTACT_QUERY = "SELECT * from contact where id = ?";
	
	public ContactObject read() {
		ContactObject contact = new ContactObject();
		try (Connection connection = DbUtil.getConnection();
			 PreparedStatement statement = connection.prepareStatement(READ_CONTACT_QUERY)
		) {
			statement.setInt(1, 1);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					contact.setPhoneNumber(resultSet.getInt("phone"));
					contact.setName(resultSet.getString("name"));
					contact.setEmail(resultSet.getString("email"));
					contact.setAddress(resultSet.getString("address"));
					contact.setDescription(resultSet.getString("description"));
					
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contact;
	}

}
