package com.realestate.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.realestate.dao.PropertyDao;
import com.realestate.entity.Property;

@Service
public class PropertyService {
	@Autowired
	private PropertyDao propertyDao;
	public Optional<Property> getProperty(int id) {
		Optional<Property> property=null;
		try {
			property=this.propertyDao.findById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return property;
	}
	public List<Property> getAllProperties(){
		return this.propertyDao.findAll();
	}
	public Property setProperty(Property u) {
		return this.propertyDao.save(u);
	}
	public void deleteProperty(int id){
		this.propertyDao.deleteById(id);
	}
	public void updateUser(Property u,int id) {
		Optional<Property> optional=this.propertyDao.findById(id);
		Property property=optional.get();
		property.setPropertyType(null);
		property.setPropertyPrice(id);
		property.setPropertyArea(null);
		property.setPropertyCity(null);
		property.setPropertyState(null);
	}
}
